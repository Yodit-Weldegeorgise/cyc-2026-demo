package com.learningcenter.demo.mistake5.versioning.good;

import com.learningcenter.demo.shared.dto.GoalResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("goodVersioningGoalController")
@RequestMapping("/demo/good/v1/children")
public class GoalController {

    private final GoalService service;

    public GoalController(GoalService service) {
        this.service = service;
    }

    @PostMapping("/{childId}/goals")
    @ResponseStatus(HttpStatus.CREATED)
    public GoalResponse createGoal(
            @PathVariable Long childId,
            @Valid @RequestBody CreateGoalRequest request
    ) {
        return service.createGoal(childId, request);
    }
}