package com.learningcenter.demo.mistake3.errorhandling.good;
public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException(Long id) { super("Session with ID " + id + " was not found."); }
}
