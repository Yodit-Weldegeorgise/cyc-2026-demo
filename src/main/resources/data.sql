INSERT INTO parents (parent_id, name, credit_balance)
VALUES (1, 'Amina Parent', 12);

INSERT INTO children (child_id, name, grade_level, parent_id)
VALUES (1, 'Sam Child', 5, 1);

INSERT INTO subjects (subject_id, name)
VALUES (1, 'Mathematics');

INSERT INTO tutors (tutor_id, name, email)
VALUES (1, 'Taylor Tutor', 'taylor@example.com');

INSERT INTO learning_sessions (
    session_id,
    session_notes,
    tutor_id,
    child_id
)
VALUES (
           1,
           'Fractions practice',
           1,
           1
       );