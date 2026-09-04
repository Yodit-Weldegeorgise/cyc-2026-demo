package com.learningcenter.demo.mistake3.errorhandling.good;

import com.learningcenter.demo.shared.entity.Session;
import com.learningcenter.demo.shared.repository.SessionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.Optional;

@Service("goodErrorSessionService")
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session getSessionById(Long sessionId) {

        if (sessionId == null) {
            throw new ErrorResponseException(
                    HttpStatus.BAD_REQUEST,
                    ProblemDetail.forStatusAndDetail(
                            HttpStatus.BAD_REQUEST,
                            "Session ID is required"
                    ),
                    null
            );
        }

        Optional<Session> sessionOptional =
                sessionRepository.findById(sessionId);

        if (sessionOptional.isPresent()) {
            return sessionOptional.get();
        } else {
            //best way to handle this is to throw a custom exception and handle it in a @ControllerAdvice class
            throw new SessionNotFoundException(sessionId);

        }
    }
}