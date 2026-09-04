package com.learningcenter.demo.mistake3.errorhandling.good;

import com.learningcenter.demo.shared.dto.TutorResponse;
import org.springframework.web.bind.annotation.*;

@RestController("goodErrorTutorController")
@RequestMapping("/demo/good/tutors")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/{tutorId}")
    public TutorResponse getTutorDetails(
            @PathVariable Long tutorId) {

        return tutorService.getTutorDetails(tutorId);
    }
}