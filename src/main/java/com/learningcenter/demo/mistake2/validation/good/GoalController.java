package com.learningcenter.demo.mistake2.validation.good;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("goodValidationGoalController")
@RequestMapping("/demo/good/validation/children")
public class GoalController {
    private final GoalService goalService;
    public GoalController(GoalService goalService) { this.goalService = goalService; }
    @PostMapping("/{childId}/goals") @ResponseStatus(HttpStatus.CREATED)
    public String createGoal(@PathVariable Long childId, @Valid @RequestBody CreateGoalRequest request) {
        return goalService.createGoal(childId, request);
    }
}
