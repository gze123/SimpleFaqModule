package assignmentListTesting.dao;

import assignmentListTesting.model.Answer;

import java.util.List;

public interface AnswerDao {
    long save(Answer answer);
    Answer get(long id);
    List<Answer> getQuestion(long questionId);
    void delete(long id);
    void update(long id, Answer answer);
}
