package com.example.demo.repository;

import com.example.demo.model.MentorFeedbackView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorFeedbackRepository extends MongoRepository<MentorFeedbackView, String> {
    List<MentorFeedbackView> findByVideoId(String videoId);
    List<MentorFeedbackView> findByStudentId(String studentId);
}
