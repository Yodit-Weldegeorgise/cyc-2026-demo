package com.learningcenter.demo.mistake1.apidesign.good;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController("goodApiDesignReviewController")
@RequestMapping("/demo/good/reviews")
public class ReviewController {
    @GetMapping public List<Map<String, String>> getReviews() { return List.of(Map.of("review", "Great tutoring session")); }
}
