package com.learningcenter.demo.mistake4.dtoventity.good;

import jakarta.validation.constraints.*;
public record CreateGoalRequest(@NotNull Long subjectId, @NotBlank String title) {}
