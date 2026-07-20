-- Session 14 Exercise 02: Stored Procedure to update a student
USE session14_db;

DROP PROCEDURE IF EXISTS update_student;
DELIMITER //
CREATE PROCEDURE update_student(
    IN in_id INT,
    IN in_name VARCHAR(255),
    IN in_age INT
)
BEGIN
    UPDATE students
    SET name = in_name,
        age = in_age
    WHERE id = in_id;
END //
DELIMITER ;
