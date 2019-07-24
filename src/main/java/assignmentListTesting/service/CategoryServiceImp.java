package assignmentListTesting.service;

import assignmentListTesting.dao.CategoryDao;
import assignmentListTesting.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public long save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Override
    public Category get(long id) {
        return categoryDao.get(id);
    }

    @Override
    public void delete(long id) {
        categoryDao.delete(id);
    }

    @Override
    public void update(long id, Category category) {
        categoryDao.update(id, category);
    }

}
