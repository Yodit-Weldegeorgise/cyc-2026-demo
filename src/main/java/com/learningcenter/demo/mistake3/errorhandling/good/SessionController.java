package com.learningcenter.demo.mistake3.errorhandling.good;

import com.learningcenter.demo.shared.dto.SessionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("goodErrorSessionController")
@RequestMapping("/demo/good/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionResponse> getSessionById(
            @PathVariable Long sessionId) {

        var session = sessionService.getSessionById(sessionId);

        return ResponseEntity.ok(
                new SessionResponse(session)
        );
    }
}