package com.example.demo.service;

import com.example.demo.model.MentorFeedbackView;
import com.example.demo.repository.MentorFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorFeedbackService {

    @Autowired
    private MentorFeedbackRepository mentorFeedbackRepository;

    public List<MentorFeedbackView> getAllFeedbacks() {
        return mentorFeedbackRepository.findAll();
    }

    public Optional<MentorFeedbackView> getFeedbackById(String id) {
        return mentorFeedbackRepository.findById(id);
    }

    public List<MentorFeedbackView> getFeedbacksByVideoId(String videoId) {
        return mentorFeedbackRepository.findByVideoId(videoId);
    }

    public List<MentorFeedbackView> getFeedbacksByStudentId(String studentId) {
        return mentorFeedbackRepository.findByStudentId(studentId);
    }
}
