package com.learningcenter.demo.mistake5.versioning.bad;

public record CreateGoalRequest(
        Long subjectId,
        String title
) {}