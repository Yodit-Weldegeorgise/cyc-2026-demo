package com.learningcenter.demo.mistake4.dtoventity.good;
public record GoalResponse(
        Long goalId,
        ChildResponse child,
        SubjectResponse subject,
        String title
) {
    public record ChildResponse(
            Long childId,
            String name,
            int gradeLevel,
            ParentResponse parent
    ) {}

    public record ParentResponse(
            Long parentId,
            String name,
            Integer creditBalance
    ) {}

    public record SubjectResponse(
            Long subjectId,
            String name
    ) {}
}