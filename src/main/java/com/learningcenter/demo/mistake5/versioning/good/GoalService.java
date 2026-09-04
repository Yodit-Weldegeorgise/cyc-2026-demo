package com.learningcenter.demo.mistake5.versioning.good;

import com.learningcenter.demo.shared.dto.GoalResponse;
import com.learningcenter.demo.shared.entity.*;
import com.learningcenter.demo.shared.repository.*;
import org.springframework.stereotype.Service;

@Service("goodVersioningGoalService")
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

    public GoalResponse createGoal(
            Long childId,
            CreateGoalRequest request
    ) {
        Child child = children.findById(childId).orElseThrow();
        Subject subject = subjects.findById(request.subjectId()).orElseThrow();

        Goal goal = goals.save(
                new Goal(
                        child,
                        subject,
                        request.title().trim()
                )
        );

        return new GoalResponse(
                goal.getGoalId(),
                goal.getChild().getChildId(),
                goal.getSubject().getSubjectId(),
                goal.getSubject().getName(),
                goal.getTitle()
        );
    }
}