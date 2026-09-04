package com.learningcenter.demo.shared.entity;

import jakarta.persistence.*;

@Entity @Table(name = "tutors")
public class Tutor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long tutorId;
    private String name;
    private String email;
    protected Tutor() {}
    public Tutor(String name, String email) { this.name = name; this.email = email; }
    public Long getTutorId() { return tutorId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
