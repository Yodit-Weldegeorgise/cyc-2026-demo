package com.learningcenter.demo.mistake3.errorhandling.good;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

public record ApiErrorResponse(
        int status,
        String code,
        String message,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        Map<String, String> fieldErrors
) {

    public static ApiErrorResponse of(
            int status,
            String code,
            String message
    ) {
        return new ApiErrorResponse(
                status,
                code,
                message,
                Map.of()
        );
    }
}