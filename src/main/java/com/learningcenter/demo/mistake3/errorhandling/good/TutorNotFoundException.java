package com.learningcenter.demo.mistake3.errorhandling.good;

public class TutorNotFoundException extends RuntimeException {

    public TutorNotFoundException(Long tutorId) {
        super(
                "Tutor with ID "
                        + tutorId
                        + " was not found."
        );
    }
}