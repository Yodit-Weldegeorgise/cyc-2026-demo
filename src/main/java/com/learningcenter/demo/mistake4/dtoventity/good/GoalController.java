package com.learningcenter.demo.mistake4.dtoventity.good;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("goodDtoGoalController") @RequestMapping("/demo/good/dto/children")
public class GoalController {
    private final GoalService service;
    public GoalController(GoalService service) { this.service = service; }
    @PostMapping("/{childId}/goals") @ResponseStatus(HttpStatus.CREATED)
    public GoalResponse createGoal(@PathVariable Long childId, @Valid @RequestBody CreateGoalRequest request) { return service.createGoal(childId, request); }
}
