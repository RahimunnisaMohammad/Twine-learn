package com.example.demo.LoginController;

import com.example.demo.dto.QuizDTO;
import com.example.demo.model.Quiz;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Create new quiz
    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDTO dto) {
        Quiz saved = quizService.createQuiz(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all quizzes
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    // Get quiz by ID
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String id) {
        Quiz quiz = quizService.getQuizById(id);
        return quiz != null ? ResponseEntity.ok(quiz) : ResponseEntity.notFound().build();
    }

    // Get quizzes created by a specific mentor
    @GetMapping("/creator/{mentorId}")
    public ResponseEntity<List<Quiz>> getQuizzesByMentor(@PathVariable String mentorId) {
        return ResponseEntity.ok(quizService.getQuizzesByCreator(mentorId));
    }

    // Delete quiz by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable String id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok("Quiz deleted successfully");
    }
}
