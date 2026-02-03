package com.example.demo.LoginController;

import com.example.demo.dto.StudentFeedbackDTO;
import com.example.demo.model.StudentFeedbackView;
import com.example.demo.service.StudentFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/student/feedbacks")
public class StudentFeedbackController {

    @Autowired
    private StudentFeedbackService feedbackService;

    // Student creates feedback
    @PostMapping("/create")
    public ResponseEntity<StudentFeedbackView> createFeedback(@RequestBody StudentFeedbackDTO dto) {
    	StudentFeedbackView saved = feedbackService.createFeedback(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Student deletes their own feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable String id) {
        boolean deleted = feedbackService.deleteFeedback(id);
        return deleted ? ResponseEntity.ok("Feedback deleted successfully")
                       : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feedback not found");
    }
}
