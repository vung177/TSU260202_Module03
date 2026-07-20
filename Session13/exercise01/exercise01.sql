-- 1. Tạo database và sử dụng
CREATE DATABASE IF NOT EXISTS session13_db;
USE session13_db;

-- 2. Tạo bảng Students
CREATE TABLE IF NOT EXISTS Students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- 3. Viết các Stored Procedure

-- Thủ tục 1: get_all_students (Không có tham số, lấy tất cả sinh viên)
DROP PROCEDURE IF EXISTS get_all_students;
DELIMITER //
CREATE PROCEDURE get_all_students()
BEGIN
    SELECT * FROM Students;
END //
DELIMITER ;

-- Thủ tục 2: add_student (Thêm mới sinh viên)
DROP PROCEDURE IF EXISTS add_student;
DELIMITER //
CREATE PROCEDURE add_student(
    IN in_full_name VARCHAR(100),
    IN in_date_of_birth DATE,
    IN in_email VARCHAR(100)
)
BEGIN
    INSERT INTO Students (full_name, date_of_birth, email)
    VALUES (in_full_name, in_date_of_birth, in_email);
END //
DELIMITER ;

-- Thủ tục 3: update_student (Cập nhật thông tin sinh viên theo ID)
DROP PROCEDURE IF EXISTS update_student;
DELIMITER //
CREATE PROCEDURE update_student(
    IN in_id INT,
    IN in_full_name VARCHAR(100),
    IN in_date_of_birth DATE,
    IN in_email VARCHAR(100)
)
BEGIN
    UPDATE Students
    SET full_name = in_full_name,
        date_of_birth = in_date_of_birth,
        email = in_email
    WHERE student_id = in_id;
END //
DELIMITER ;

-- Thủ tục 4: find_student_by_id (Tìm sinh viên theo ID)
DROP PROCEDURE IF EXISTS find_student_by_id;
DELIMITER //
CREATE PROCEDURE find_student_by_id(
    IN in_id INT
)
BEGIN
    SELECT * FROM Students WHERE student_id = in_id;
END //
DELIMITER ;

-- Thủ tục 5: delete_student (Xóa sinh viên theo ID)
DROP PROCEDURE IF EXISTS delete_student;
DELIMITER //
CREATE PROCEDURE delete_student(
    IN in_id INT
)
BEGIN
    DELETE FROM Students WHERE student_id = in_id;
END //
DELIMITER ;


-- =======================================================
-- HƯỚNG DẪN GỌI VÀ KIỂM TRA THỬ CÁC THỦ TỤC TRÊN WORKBENCH:
-- =======================================================

-- A. Thêm mới sinh viên (Test add_student)
-- CALL add_student('Nguyễn Văn An', '2005-04-12', 'an.nguyen@gmail.com');
-- CALL add_student('Trần Thị Bình', '2004-09-18', 'binh.tran@gmail.com');

-- B. Lấy danh sách toàn bộ sinh viên (Test get_all_students)
-- CALL get_all_students();

-- C. Tìm kiếm sinh viên theo ID (Test find_student_by_id cho ID = 1)
-- CALL find_student_by_id(1);

-- D. Cập nhật thông tin sinh viên (Test update_student cho ID = 1)
-- CALL update_student(1, 'Nguyễn Văn An Cập Nhật', '2005-04-12', 'an.nguyen.updated@gmail.com');

-- E. Xóa sinh viên (Test delete_student cho ID = 2)
-- CALL delete_student(2);
