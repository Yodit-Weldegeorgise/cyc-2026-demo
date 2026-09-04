package com.learningcenter.demo.mistake2.validation.bad;

import org.springframework.stereotype.Service;

@Service("badValidationGoalService")
public class GoalService {
    public String createGoal(Long childId, CreateGoalRequest request) {
        if (request.subjectId() == null) throw new IllegalArgumentException("subjectId is required");
        if (request.title() == null || request.title().isBlank()) throw new IllegalArgumentException("title is required");
        return request.title().trim();
    }
}
