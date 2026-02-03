package com.example.demo.service;

import com.example.demo.dto.VideoDTO;
import com.example.demo.model.Vedio;
import com.example.demo.repository.VedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VedioService {

    @Autowired
    private VedioRepository vedioRepository;

    // Upload a new video
    public Vedio uploadVideo(VideoDTO dto) {
        Vedio vedio = new Vedio();
        vedio.setMentorId(dto.getMentorId());
        vedio.setTitle(dto.getTitle());
        vedio.setDescription(dto.getDescription());
        vedio.setSubject(dto.getSubject());
        vedio.setVideoUrl(dto.getVideoUrl());
        return vedioRepository.save(vedio);
    }

    // Fetch all videos
    public List<Vedio> getAllVideos() {
        return vedioRepository.findAll();
    }

    // Fetch a single video by ID
    public Vedio getVideoById(String id) {
        Optional<Vedio> optional = vedioRepository.findById(id);
        return optional.orElse(null);
    }

    // Fetch all videos uploaded by a specific mentor
    public List<Vedio> getVideosByMentorId(String mentorId) {
        return vedioRepository.findByMentorId(mentorId);
    }

    // Delete a video by ID
    public boolean deleteVideo(String id) {
        if (vedioRepository.existsById(id)) {
            vedioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
