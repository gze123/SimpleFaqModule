package assignmentListTesting.dao;

import assignmentListTesting.model.Question;

import java.util.List;

public interface QuestionDao {
    long save(Question question);
    List<Question> list(long categoryId);
    Question get(long id);
    void delete(long id);
    void update(long id, Question question);
}

