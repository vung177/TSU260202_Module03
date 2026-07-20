-- Stored procedure to delete students with age less than the given limit
DELIMITER $$
CREATE PROCEDURE delete_students_by_age(IN in_age INT)
BEGIN
    DELETE FROM students WHERE age < in_age;
END $$
DELIMITER ;
