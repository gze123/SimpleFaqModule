package assignmentListTesting.service;

import assignmentListTesting.model.Answer;

import java.util.List;

public interface AnswerService {
    long save(Answer answer);
    Answer get(long id);
    List<Answer> getQuestion(long questionId);
    void delete(long id);
    void update(long id, Answer answer);
}
