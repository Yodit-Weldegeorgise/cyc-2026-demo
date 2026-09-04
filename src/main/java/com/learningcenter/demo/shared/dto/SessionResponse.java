package com.learningcenter.demo.shared.dto;

import com.learningcenter.demo.shared.entity.Session;

public record SessionResponse(
        Long sessionId,
        String sessionNotes
) {

    public SessionResponse(Session session) {
        this(
                session.getSessionId(),
                session.getSessionNotes()
        );
    }
}