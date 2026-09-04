package com.learningcenter.demo.shared.dto;

public record GoalResponse(
        Long goalId,
        Long childId,
        Long subjectId,
        String subjectName,
        String title
) {}