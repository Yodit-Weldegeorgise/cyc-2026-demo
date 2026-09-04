package com.learningcenter.demo.shared.repository;
import com.learningcenter.demo.shared.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SessionRepository extends JpaRepository<Session, Long> {}
