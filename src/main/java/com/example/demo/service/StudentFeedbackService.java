package com.example.demo.service;

import com.example.demo.dto.StudentFeedbackDTO;
import com.example.demo.model.StudentFeedbackView;
import com.example.demo.repository.StudentFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentFeedbackService {

    @Autowired
    private StudentFeedbackRepository studentFeedbackRepository;

    public StudentFeedbackView createFeedback(StudentFeedbackDTO dto) {
    	StudentFeedbackView feedback = new StudentFeedbackView();
        feedback.setVideoId(dto.getVideoId());
        feedback.setStudentId(dto.getStudentId());
        feedback.setComment(dto.getComment());
        feedback.setRating(dto.getRating());

        return studentFeedbackRepository.save(feedback);
    }

    public boolean deleteFeedback(String id) {
        if (studentFeedbackRepository.existsById(id)) {
            studentFeedbackRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<StudentFeedbackView> getFeedbackById(String id) {
        return studentFeedbackRepository.findById(id);
    }
}
