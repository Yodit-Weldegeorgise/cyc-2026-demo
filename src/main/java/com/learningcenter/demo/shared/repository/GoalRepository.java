package com.learningcenter.demo.shared.repository;
import com.learningcenter.demo.shared.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GoalRepository extends JpaRepository<Goal, Long> {}
