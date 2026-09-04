# 5 Mistakes Developers Make When Building Java APIs (and How to Fix Them)

Runnable Spring Boot conference examples grounded in the Learning Center cohort project. This edition covers four mistakes; each package contains a deliberately simplified bad version beside a focused improvement. The bad examples isolate one issue and are not production recommendations.

## The four mistakes

1. Inconsistent REST API design
2. Missing or misplaced request validation
3. Unclear error responses and incorrect HTTP status codes
4. Returning JPA entities instead of DTOs

## Requirements and commands

Java 21+ and Maven 3.9+ are required.

```bash
mvn spring-boot:run
mvn test
```

The in-memory H2 data is recreated at startup. The H2 console is at `http://localhost:8080/h2-console` using JDBC URL `jdbc:h2:mem:learningcenter` and user `sa`.

## Demo requests

```bash
# 1: singular/camelCase versus plural/kebab-case resources
curl localhost:8080/demo/bad/review
curl localhost:8080/demo/bad/parents/1/creditBalance
curl localhost:8080/demo/good/reviews
curl localhost:8080/demo/good/parents/1/credit-balance

# 2: manual service validation versus boundary validation
curl -i -X POST localhost:8080/demo/bad/validation/children/1/goals -H 'Content-Type: application/json' -d '{"subjectId":null,"title":""}'
curl -i -X POST localhost:8080/demo/good/validation/children/1/goals -H 'Content-Type: application/json' -d '{"subjectId":null,"title":""}'

# 3: vague/wrong failures versus actionable errors
curl -i localhost:8080/demo/bad/tutors/99999
curl -i localhost:8080/demo/good/tutors/99999
curl -i localhost:8080/demo/bad/sessions/99999
curl -i localhost:8080/demo/good/sessions/99999
curl -i localhost:8080/demo/good/sessions/demo/unexpected

# 4: persistence entity versus an explicit response DTO
curl -i -X POST localhost:8080/demo/bad/entity/children/1/goals -H 'Content-Type: application/json' -d '{"subjectId":1,"title":"Improve multiplication skills"}'
curl -i -X POST localhost:8080/demo/good/dto/children/1/goals -H 'Content-Type: application/json' -d '{"subjectId":1,"title":"Improve multiplication skills"}'
```

## Suggested 25-minute order

Introduction 3 min; API design 4 min; validation 5 min; error handling 7 min; DTOs 5 min; summary 1 min; Q&A 5 min. Open no more than three main files per section and prioritize the observable HTTP result.

## Source note

The original snippets and paths were supplied from a Learning Center cohort project: `ReviewController`, `ParentController`, `GoalService`, `TutorService`, and `SessionService`. Supporting entities here are intentionally small so the before-and-after remains visible on stage.
