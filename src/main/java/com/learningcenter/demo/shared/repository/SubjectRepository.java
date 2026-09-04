package com.learningcenter.demo.shared.repository;
import com.learningcenter.demo.shared.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SubjectRepository extends JpaRepository<Subject, Long> {}
