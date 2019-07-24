package assignmentListTesting.service;

import assignmentListTesting.dao.AnswerDao;
import assignmentListTesting.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public long save(Answer answer) {
        return answerDao.save(answer);
    }

    @Override
    public Answer get(long id) {
        return answerDao.get(id);
    }

    @Override
    public List<Answer> getQuestion(long questionId) {
        return answerDao.getQuestion(questionId);
    }

    @Override
    public void delete(long id) {
        answerDao.delete(id);
    }

    @Override
    public void update(long id, Answer answer) {
        answerDao.update(id,answer);
    }
}
