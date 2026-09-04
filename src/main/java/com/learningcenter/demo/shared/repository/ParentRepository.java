package com.learningcenter.demo.shared.repository;
import com.learningcenter.demo.shared.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ParentRepository extends JpaRepository<Parent, Long> {}
