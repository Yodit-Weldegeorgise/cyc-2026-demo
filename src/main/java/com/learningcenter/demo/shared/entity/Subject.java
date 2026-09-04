package com.learningcenter.demo.shared.entity;

import jakarta.persistence.*;

@Entity @Table(name = "subjects")
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long subjectId;
    private String name;
    protected Subject() {}
    public Subject(String name) { this.name = name; }
    public Long getSubjectId() { return subjectId; }
    public String getName() { return name; }
}
