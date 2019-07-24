package assignmentListTesting.dao;

import assignmentListTesting.model.Answer;
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
public class AnswerDaoImp implements AnswerDao {

    @Autowired
    private EntityManager entityManager;

    public Session getSessionFactory(){
        return entityManager.unwrap(Session.class);
    }

    @Override
    public long save(Answer answer) {
        getSessionFactory().save(answer);
        return answer.getAnswerId();
    }

    @Override
    public Answer get(long answerId) {
        return getSessionFactory().get(Answer.class, answerId);
    }

    @Override
    public List<Answer> getQuestion(long questionId){
        Session session = getSessionFactory();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Answer> criteriaQuery = criteriaBuilder.createQuery(Answer.class);
        Root<Answer> root = criteriaQuery.from(Answer.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("questionId"),questionId));
        Query<Answer> query = session.createQuery(criteriaQuery);
        List<Answer> answer = query.getResultList();
        return answer;
    }

    @Override
    public void update(long id, Answer answer) {
        Answer answer1 = get(id);
        answer1.setAnswerName(answer.getAnswerName());
        save(answer1);
        getSessionFactory().update(answer1);
    }

    @Override
    public void delete(long id) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaDelete<Answer> delete = criteriaBuilder.createCriteriaDelete(Answer.class);
        Root root = delete.from(Answer.class);
        delete.where(criteriaBuilder.equal(root.get("answerId"),id));
        this.entityManager.createQuery(delete).executeUpdate();
    }


}
