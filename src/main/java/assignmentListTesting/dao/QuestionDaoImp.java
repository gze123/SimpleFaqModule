package assignmentListTesting.dao;

import assignmentListTesting.model.Question;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class QuestionDaoImp implements QuestionDao {

    @Autowired
    private EntityManager entityManager;

    public Session getSessionFactory(){
        return entityManager.unwrap(Session.class);
    }

    @Override
    public long save(Question question) {
        getSessionFactory().save(question);
        return question.getQuestionId();
    }

    @Override
    public List<Question> list(long categoryId) {
        Session session = getSessionFactory();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> root = criteriaQuery.from(Question.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("categoryId"),categoryId));
        Query<Question> query = session.createQuery(criteriaQuery);
        List<Question> questionList = query.getResultList();
        return questionList;
    }

    @Override
    public Question get(long id) {
        return getSessionFactory().get(Question.class,id);
    }

    @Override
    public void delete(long id) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaDelete<Question> delete = criteriaBuilder.createCriteriaDelete(Question.class);
        Root root = delete.from(Question.class);
        delete.where(criteriaBuilder.equal(root.get("questionId"),id));
        this.entityManager.createQuery(delete).executeUpdate();
    }

    @Override
    public void update(long id, Question question) {
        Question question1 = get(id);
        question1.setQuestionName(question.getQuestionName());
        save(question1);
        getSessionFactory().update(question1);
    }
}
