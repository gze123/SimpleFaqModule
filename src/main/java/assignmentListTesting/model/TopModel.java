package assignmentListTesting.model;

import java.util.List;

public class TopModel {
    private long categoryId;
    private String categoryName;
    private List<QuestionAndAnswer> questionList;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public List<QuestionAndAnswer> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionAndAnswer> questionAndAnswerList) {
        this.questionList = questionAndAnswerList;
    }
}
