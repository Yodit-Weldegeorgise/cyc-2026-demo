package com.learningcenter.demo.mistake1.apidesign.bad;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController("badApiDesignReviewController")
@RequestMapping("/demo/bad/review")
public class ReviewController {
    @GetMapping public Map<String, String> getReview() { return Map.of("review", "Great tutoring session"); }
}
