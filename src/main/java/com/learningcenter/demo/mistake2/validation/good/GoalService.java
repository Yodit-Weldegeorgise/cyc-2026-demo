package com.learningcenter.demo.mistake2.validation.good;

import org.springframework.stereotype.Service;

@Service("goodValidationGoalService")
public class GoalService {
    public String createGoal(Long childId, CreateGoalRequest request) {
        // Existence, ownership, and duplicate checks belong here as business rules.
        return request.title().trim();
    }
}
