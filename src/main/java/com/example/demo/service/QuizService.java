package com.example.demo.service;

import com.example.demo.dto.QuizDTO;
import com.example.demo.model.Quiz;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDTO.getTitle());
        quiz.setQuestions(quizDTO.getQuestions());
        quiz.setCreatedBy(quizDTO.getCreatedBy());
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(String id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.orElse(null);
    }

    public List<Quiz> getQuizzesByCreator(String mentorId) {
        return quizRepository.findByCreatedBy(mentorId);
    }

    public void deleteQuiz(String id) {
        quizRepository.deleteById(id);
    }
}
