package com.learningcenter.demo.shared.entity;

import jakarta.persistence.*;

@Entity @Table(name = "parents")
public class Parent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long parentId;
    private String name;
    private Integer creditBalance;
    protected Parent() {}
    public Parent(String name, Integer creditBalance) { this.name = name; this.creditBalance = creditBalance; }
    public Long getParentId() { return parentId; }
    public String getName() { return name; }
    public Integer getCreditBalance() { return creditBalance; }
}
