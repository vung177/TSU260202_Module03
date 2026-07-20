-- Session 14 Exercise 01: Table and stored procedure for adding students
CREATE DATABASE IF NOT EXISTS session14_db;
USE session14_db;

-- Table definition
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    age INT
);

-- Stored Procedure to add a single student (called repeatedly in transaction)
DROP PROCEDURE IF EXISTS add_students;
DELIMITER //
CREATE PROCEDURE add_students(
    IN in_name VARCHAR(255),
    IN in_age INT
)
BEGIN
    INSERT INTO students(name, age) VALUES (in_name, in_age);
END //
DELIMITER ;
