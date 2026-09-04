package com.learningcenter.demo.mistake2.validation.good;

import jakarta.validation.constraints.*;

public record CreateGoalRequest(
        @NotNull(message = "Subject ID is required") Long subjectId,
        @NotBlank(message = "Goal title is required") @Size(max = 150, message = "Goal title must not exceed 150 characters") String title) {}
