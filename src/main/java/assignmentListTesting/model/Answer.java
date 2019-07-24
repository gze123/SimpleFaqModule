package assignmentListTesting.model;

import javax.persistence.*;

@Entity
@Table(name = "ziyen_assignment_answer_testing")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long answerId;

    @Column
    private String answerName;

    @Column
    private long questionId;

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}
