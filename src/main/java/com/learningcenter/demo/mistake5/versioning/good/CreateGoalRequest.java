package com.learningcenter.demo.mistake5.versioning.good;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateGoalRequest(
        @NotNull Long subjectId,
        @NotBlank String title
) {}