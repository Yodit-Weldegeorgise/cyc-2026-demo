package com.learningcenter.demo.mistake3.errorhandling.good;

import com.learningcenter.demo.shared.dto.TutorResponse;
import com.learningcenter.demo.shared.repository.TutorRepository;
import org.springframework.stereotype.Service;

@Service("goodErrorTutorService")
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public TutorResponse getTutorDetails(Long tutorId) {

        var tutor = tutorRepository.findById(tutorId);

        if (tutor.isEmpty()) {
            throw new TutorNotFoundException(tutorId);
        }

        var t = tutor.get();


        return new TutorResponse(
                t.getTutorId(),
                t.getName()
        );
    }
}