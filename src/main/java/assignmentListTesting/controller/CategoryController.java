package assignmentListTesting.controller;

import assignmentListTesting.model.Answer;
import assignmentListTesting.model.Category;
import assignmentListTesting.model.Question;
import assignmentListTesting.model.TopModel;
import assignmentListTesting.service.AnswerService;
import assignmentListTesting.service.CategoryService;
import assignmentListTesting.service.QuestionService;
import assignmentListTesting.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private TopService topService;

    //Add new category
    @PostMapping("/addCategory")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> saveCategory(@RequestBody Category category){
        long id = categoryService.save(category);
        return ResponseEntity.ok().body("New Category added" + id);
    }

    //get all Category
    @GetMapping("/categoryList")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> categoryList = categoryService.list();
        return ResponseEntity.ok().body(categoryList);
    }

    //Get Category by id
    @GetMapping("/findCategory/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Category> getCategory(@PathVariable("id") long id){
        Category category = categoryService.get(id);
        return ResponseEntity.ok().body(category);
    }

    //update Category by id
    @PutMapping("/editCategory/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateCategory(@PathVariable("id") long id, @RequestBody Category category){
        categoryService.update(id, category);
        return ResponseEntity.ok().body("Category updated");
    }

    //delete Category by id
    @DeleteMapping("/deleteCategory/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id){
        topService.deleteCategory(id);
        return ResponseEntity.ok().body("Category deleted");
    }

    //Add new category
    @PostMapping("/addQuestion")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> saveCategory(@RequestBody Question question){
        long id = questionService.save(question);
        return ResponseEntity.ok().body("New Question added" + id);
    }


    //get question by id
    @GetMapping("/questionList/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Question>> listQuestion(@PathVariable("id") long id){
        List<Question> questionList = questionService.list(id);
        return ResponseEntity.ok().body(questionList);
    }

    //update Question by id
    @PutMapping("/editQuestion/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateQuestion(@PathVariable("id") long id, @RequestBody Question question){
        questionService.update(id, question);
        return ResponseEntity.ok().body("Question "+id+" updated");
    }

    //delete question by id
    @DeleteMapping("/deleteQuestion/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") long id){
        topService.deleteQuestion(id);
        return ResponseEntity.ok().body("Question deleted");
    }

    //get whole categoryObject
    @GetMapping("/categoryComplete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> listCategoryObject(){
        List<TopModel> topModelList = topService.categoryList();
        return ResponseEntity.ok().body(topModelList);
    }

    //Add new answer
    @PostMapping("/addAnswer")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> saveAnswer(@RequestBody Answer answer){
        long id = answerService.save(answer);
        return ResponseEntity.ok().body("New answer added " + id);
    }

    //Get Answer by id
    @GetMapping("/findAnswer/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Answer> getAnswer(@PathVariable("id") long id){
        Answer answer = answerService.get(id);
        return ResponseEntity.ok().body(answer);
    }

    //Get Answer by questionId
    @GetMapping("/findAnswerByQuestion/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Answer>> getAnswerByQuestion(@PathVariable("id") long id){
        List<Answer> answer = answerService.getQuestion(id);
        return ResponseEntity.ok().body(answer);
    }

    //update answer by id
    @PutMapping("/editAnswer/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> updateAnswer(@PathVariable("id") long id, @RequestBody Answer answer){
        answerService.update(id, answer);
        return ResponseEntity.ok().body("Answer "+id+" updated");
    }
    //delete answer by id
    @DeleteMapping("/deleteAnswer/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteAnswer(@PathVariable("id") long id){
        answerService.delete(id);
        return ResponseEntity.ok().body("Answer deleted");
    }

}
