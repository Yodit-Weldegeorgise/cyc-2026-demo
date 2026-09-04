package com.learningcenter.demo.mistake4.dtoventity.bad;

import com.learningcenter.demo.shared.entity.Goal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("badDtoGoalController") @RequestMapping("/demo/bad/entity/children")
public class GoalController {
    private final GoalService service;
    public GoalController(GoalService service) { this.service = service; }
    @PostMapping("/{childId}/goals") @ResponseStatus(HttpStatus.CREATED)
    public Goal createGoal(@PathVariable Long childId, @RequestBody CreateGoalRequest request) { return service.createGoal(childId, request); }
}
