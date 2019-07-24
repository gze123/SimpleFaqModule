package assignmentListTesting.service;

import assignmentListTesting.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopServiceImp implements TopService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    public List<TopModel> categoryList(){
        List<TopModel> objectList = new ArrayList<>();

        List<Category> categoryList = categoryService.list();
        int listSize = categoryList.size();
        for (int i = 0 ;i < listSize; i ++){
            List<QuestionAndAnswer> questionAndAnswerList = new ArrayList<>();
            TopModel topModel = new TopModel();
            Category category = categoryList.get(i);
            String categoryName = category.getCategoryName();
            long categoryId = category.getCategoryId();

            topModel.setCategoryId(categoryId);
            topModel.setCategoryName(categoryName);

            List<Question> questionList = questionService.list(categoryId);
            if(questionList.size()>0) {
                for (int j = 0; j < questionList.size(); j++) {
                    QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
                    Question question = questionList.get(j);
                    questionAndAnswer.setQuestion(question);
                    List<Answer> answer = answerService.getQuestion(question.getQuestionId());
                    if (answer.size()>0){
                    questionAndAnswer.setAnswer(answer.get(0));
                    }
                    questionAndAnswerList.add(questionAndAnswer);
                }
            }
            topModel.setQuestionList(questionAndAnswerList);
            objectList.add(topModel);
        }
        return objectList;
    }

    public void deleteCategory(long id){
        List<Question> questionList = questionService.list(id);
        for(int i = 0; i < questionList.size(); i++ ){
            Question question = questionList.get(i);
            List<Answer> answer = answerService.getQuestion(question.getQuestionId());
            if (answer.size() > 0) {
                answerService.delete(answer.get(0).getAnswerId());
            }
            questionService.delete(question.getQuestionId());
        }
        categoryService.delete(id);
    }

    public void deleteQuestion(long id){
        Question question = questionService.get(id);
        List<Answer> answer = answerService.getQuestion(question.getQuestionId());
        if (answer.size() > 0){
            answerService.delete(answer.get(0).getAnswerId());
        }
        questionService.delete(id);
    }
}
