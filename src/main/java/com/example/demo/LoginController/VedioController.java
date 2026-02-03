package com.example.demo.LoginController;

import com.example.demo.dto.VideoDTO;
import com.example.demo.model.Vedio;
import com.example.demo.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins="*")
public class VedioController {

    @Autowired
    private VedioService vedioService;

    @PostMapping("/upload")
    public ResponseEntity<Vedio> uploadVideo(@RequestBody VideoDTO dto) {
        Vedio saved = vedioService.uploadVideo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Vedio>> getAllVideos() {
        return ResponseEntity.ok(vedioService.getAllVideos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vedio> getVideoById(@PathVariable String id) {
        Vedio video = vedioService.getVideoById(id);
        return video != null ? ResponseEntity.ok(video) : ResponseEntity.notFound().build();
    }

    @GetMapping("/mentor/{mentorId}")
    public ResponseEntity<List<Vedio>> getVideosByMentorId(@PathVariable String mentorId) {
        return ResponseEntity.ok(vedioService.getVideosByMentorId(mentorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable String id) {
        boolean deleted = vedioService.deleteVideo(id);
        return deleted ?
                ResponseEntity.ok("Video deleted successfully") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video not found");
    }
}
