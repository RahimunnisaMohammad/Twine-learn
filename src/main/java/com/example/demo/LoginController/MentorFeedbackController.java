package com.example.demo.LoginController;

import com.example.demo.model.MentorFeedbackView;
import com.example.demo.service.MentorFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mentor/feedbacks")
public class MentorFeedbackController {

    @Autowired
    private MentorFeedbackService feedbackService;

    // Get all feedbacks
    @GetMapping
    public ResponseEntity<List<MentorFeedbackView>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }

    // Get feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MentorFeedbackView>> getFeedbackById(@PathVariable String id) {
    	Optional<MentorFeedbackView> feedback = feedbackService.getFeedbackById(id);
        return feedback != null ? ResponseEntity.ok(feedback)
                                : ResponseEntity.notFound().build();
    }
    
    
    
    

    // Get feedbacks for a specific video
    @GetMapping("/video/{videoId}")
    public ResponseEntity<List<MentorFeedbackView>> getFeedbacksByVideoId(@PathVariable String videoId) {
        return ResponseEntity.ok(feedbackService.getFeedbacksByVideoId(videoId));
    }

    // Get feedbacks by specific student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<MentorFeedbackView>> getFeedbacksByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(feedbackService.getFeedbacksByStudentId(studentId));
    }
}
