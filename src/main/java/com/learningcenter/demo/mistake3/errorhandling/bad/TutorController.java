package com.learningcenter.demo.mistake3.errorhandling.bad;

import com.learningcenter.demo.shared.dto.TutorResponse;
import org.springframework.web.bind.annotation.*;

@RestController("badErrorTutorController") @RequestMapping("/demo/bad/tutors")
public class TutorController {
    private final TutorService service;
    public TutorController(TutorService service) { this.service = service; }
    @GetMapping("/{tutorId}") public TutorResponse getTutorDetails(@PathVariable Long tutorId) { return service.getTutorDetails(tutorId); }
}
