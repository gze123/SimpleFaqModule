package assignmentListTesting.service;

import assignmentListTesting.dao.QuestionDao;
import assignmentListTesting.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService{
    @Autowired
    private QuestionDao questionDao;

    @Override
    public long save(Question question) {
        return questionDao.save(question);
    }

    @Override
    public List<Question> list(long categoryId) {
        return questionDao.list(categoryId);
    }

    @Override
    public Question get(long id) {
        return questionDao.get(id);
    }

    @Override
    public void delete(long id) {
        questionDao.delete(id);
    }

    @Override
    public void update(long id, Question question) {
        questionDao.update(id,question);
    }
}
