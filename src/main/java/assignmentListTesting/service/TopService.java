package assignmentListTesting.service;

import assignmentListTesting.model.TopModel;

import java.util.List;

public interface TopService {
    List<TopModel> categoryList();
    void deleteCategory(long id);
    void deleteQuestion(long id);
}
