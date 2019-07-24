package assignmentListTesting.service;

import assignmentListTesting.model.Question;

import java.util.List;

public interface QuestionService {
    long save(Question question);
    List<Question> list(long CategoryId);
    Question get(long id);
    void delete(long id);
    void update(long id, Question question);

}

