package com.example.demo.repository;

import com.example.demo.model.Vedio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VedioRepository extends MongoRepository<Vedio, String> {

    // Find videos uploaded by a specific mentor
    List<Vedio> findByMentorId(String mentorId);
}
