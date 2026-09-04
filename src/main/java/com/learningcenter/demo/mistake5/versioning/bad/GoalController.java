package com.learningcenter.demo.mistake5.versioning.bad;

import com.learningcenter.demo.shared.entity.Goal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("badVersioningGoalController")
@RequestMapping("/demo/bad/children")
public class GoalController {

    private final GoalService service;

    public GoalController(GoalService service) {
        this.service = service;
    }

    @PostMapping("/{childId}/goals")
    @ResponseStatus(HttpStatus.CREATED)
    public Goal createGoal(
            @PathVariable Long childId,
            @RequestBody CreateGoalRequest request
    ) {
        return service.createGoal(childId, request);
    }
}