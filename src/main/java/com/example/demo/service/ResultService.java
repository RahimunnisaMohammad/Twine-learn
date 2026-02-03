package com.example.demo.service;

import com.example.demo.dto.ResultDTO;
import com.example.demo.model.Result;
import com.example.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public Result submitResult(ResultDTO resultDTO) {
        Result result = new Result();
        result.setStudentId(resultDTO.getStudentId());
        result.setQuizId(resultDTO.getQuizId());
        result.setScore(resultDTO.getScore());
        return resultRepository.save(result);
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result getResultById(String id) {
        Optional<Result> result = resultRepository.findById(id);
        return result.orElse(null);
    }

    public List<Result> getResultsByStudentId(String studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    public List<Result> getResultsByQuizId(String quizId) {
        return resultRepository.findByQuizId(quizId);
    }

    public void deleteResult(String id) {
        resultRepository.deleteById(id);
    }
}
