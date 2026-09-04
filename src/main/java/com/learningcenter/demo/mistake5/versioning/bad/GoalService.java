package com.learningcenter.demo.mistake5.versioning.bad;

import com.learningcenter.demo.shared.entity.*;
import com.learningcenter.demo.shared.repository.*;
import org.springframework.stereotype.Service;

@Service("badVersioningGoalService")
public class GoalService {

    private final GoalRepository goals;
    private final ChildRepository children;
    private final SubjectRepository subjects;

    public GoalService(
            GoalRepository goals,
            ChildRepository children,
            SubjectRepository subjects
    ) {
        this.goals = goals;
        this.children = children;
        this.subjects = subjects;
    }

    public Goal createGoal(
            Long childId,
            CreateGoalRequest request
    ) {
        Child child = children.findById(childId).orElseThrow();
        Subject subject = subjects.findById(request.subjectId()).orElseThrow();

        return goals.save(
                new Goal(
                        child,
                        subject,
                        request.title().trim()
                )
        );
    }
}