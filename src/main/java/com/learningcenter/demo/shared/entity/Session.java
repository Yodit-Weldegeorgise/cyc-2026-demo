package com.learningcenter.demo.shared.entity;

import jakarta.persistence.*;

@Entity @Table(name = "learning_sessions")
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long sessionId;
    private String sessionNotes;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "tutor_id") private Tutor tutor;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "child_id") private Child child;
    protected Session() {}
    public Session(String sessionNotes, Tutor tutor, Child child) { this.sessionNotes = sessionNotes; this.tutor = tutor; this.child = child; }
    public Long getSessionId() { return sessionId; }
    public String getSessionNotes() { return sessionNotes; }
}
