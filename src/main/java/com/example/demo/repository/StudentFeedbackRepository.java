package com.example.demo.repository;

import com.example.demo.model.StudentFeedbackView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentFeedbackRepository extends MongoRepository<StudentFeedbackView, String> {
    List<StudentFeedbackView> findByStudentId(String studentId);
}
