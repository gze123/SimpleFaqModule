package assignmentListTesting.dao;

import assignmentListTesting.model.Category;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImp implements CategoryDao {
    @Autowired
    private EntityManager entityManager;

    public Session getSessionFactory(){
        return entityManager.unwrap(Session.class);
    }

    @Override
    public long save(Category category) {
        getSessionFactory().save(category);
        return category.getCategoryId();
    }

    @Override
    public List<Category> list() {
        Session session = getSessionFactory();
        CriteriaQuery<Category> criteriaQuery = session.getCriteriaBuilder().createQuery(Category.class);
        criteriaQuery.from(Category.class);
        List<Category> categoryList = session.createQuery(criteriaQuery).getResultList();
        return categoryList;
    }

    @Override
    public Category get(long id) {
        return getSessionFactory().get(Category.class,id);
    }

    @Override
    public void delete(long id) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaDelete<Category> delete = criteriaBuilder.createCriteriaDelete(Category.class);
        Root root = delete.from(Category.class);
        delete.where(criteriaBuilder.equal(root.get("categoryId"),id));
        this.entityManager.createQuery(delete).executeUpdate();
    }


    @Override
    public void update(long id, Category category) {
        Category category1 = get(id);
        category1.setCategoryName(category.getCategoryName());
        save(category1);
        getSessionFactory().update(category1);
    }


}
