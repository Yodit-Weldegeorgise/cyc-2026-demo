package com.learningcenter.demo.shared.repository;
import com.learningcenter.demo.shared.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ChildRepository extends JpaRepository<Child, Long> {}
