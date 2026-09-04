package com.learningcenter.demo.shared.repository;
import com.learningcenter.demo.shared.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TutorRepository extends JpaRepository<Tutor, Long> {}
