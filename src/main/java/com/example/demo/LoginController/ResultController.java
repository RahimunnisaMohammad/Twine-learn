package com.example.demo.LoginController;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Result;
import com.example.demo.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/submit")
    public ResponseEntity<Result> submitResult(@RequestBody ResultDTO resultDTO) {
        Result savedResult = resultService.submitResult(resultDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResult);
    }

    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        return ResponseEntity.ok(resultService.getAllResults());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable String id) {
        Result result = resultService.getResultById(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Result>> getResultsByStudent(@PathVariable String studentId) {
        return ResponseEntity.ok(resultService.getResultsByStudentId(studentId));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Result>> getResultsByQuiz(@PathVariable String quizId) {
        return ResponseEntity.ok(resultService.getResultsByQuizId(quizId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable String id) {
        resultService.deleteResult(id);
        return ResponseEntity.ok("Result deleted successfully");
    }
}
