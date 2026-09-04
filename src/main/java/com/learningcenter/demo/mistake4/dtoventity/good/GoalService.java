package com.learningcenter.demo.mistake4.dtoventity.good;

import com.learningcenter.demo.shared.entity.Child;
import com.learningcenter.demo.shared.entity.Goal;
import com.learningcenter.demo.shared.entity.Parent;
import com.learningcenter.demo.shared.entity.Subject;
import com.learningcenter.demo.shared.repository.ChildRepository;
import com.learningcenter.demo.shared.repository.GoalRepository;
import com.learningcenter.demo.shared.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service("goodDtoGoalService")
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

        Subject subject = subjects.findById(request.subjectId())
                .orElseThrow();

        Goal savedGoal = goals.save(
                new Goal(child, subject, request.title().trim())
        );

        return toResponse(savedGoal);
    }

    private GoalResponse toResponse(Goal goal) {
        Child child = goal.getChild();
        Parent parent = child.getParent();
        Subject subject = goal.getSubject();

        GoalResponse.ParentResponse parentResponse =
                new GoalResponse.ParentResponse(
                        parent.getParentId(),
                        parent.getName(),
                        parent.getCreditBalance()
                );

        GoalResponse.ChildResponse childResponse =
                new GoalResponse.ChildResponse(
                        child.getChildId(),
                        child.getName(),
                        child.getGradeLevel(),
                        parentResponse
                );

        GoalResponse.SubjectResponse subjectResponse =
                new GoalResponse.SubjectResponse(
                        subject.getSubjectId(),
                        subject.getName()
                );

        return new GoalResponse(
                goal.getGoalId(),
                goal.getTitle(),
                childResponse,
                subjectResponse
        );
    }
}