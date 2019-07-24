package assignmentListTesting.dao;

import assignmentListTesting.model.Category;

import java.util.List;

public interface CategoryDao {
    long save(Category category);
    List<Category> list();
    Category get(long id);
    void delete(long id);
    void update(long id, Category category);
}
