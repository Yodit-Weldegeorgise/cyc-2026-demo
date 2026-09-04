package com.learningcenter.demo.shared.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "children")
public class Child {

    public Child(String name, int gradeLevel, Parent parent) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.parent = parent;
    }

    protected Child() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long childId;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "grade_level")
    private int gradeLevel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}