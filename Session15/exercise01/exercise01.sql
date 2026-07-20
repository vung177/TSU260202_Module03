-- Create database and table
CREATE DATABASE IF NOT EXISTS ProductManagement;
USE ProductManagement;

DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
    Product_Id INT AUTO_INCREMENT PRIMARY KEY,
    Product_Name VARCHAR(100) NOT NULL UNIQUE,
    Product_Price FLOAT NOT NULL CHECK (Product_Price > 0),
    Product_Title VARCHAR(200) NOT NULL,
    Product_created DATE NOT NULL,
    Product_catalog VARCHAR(100) NOT NULL,
    Product_Status BIT NOT NULL DEFAULT 1
);

-- Procedure: Get all products
DELIMITER $$
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM Product;
END $$
DELIMITER ;

-- Procedure: Check catalog existence
DELIMITER $$
CREATE PROCEDURE check_catalog_exists(IN in_catalog VARCHAR(100), OUT out_exists INT)
BEGIN
    SELECT COUNT(*) INTO out_exists FROM Product WHERE Product_catalog = in_catalog LIMIT 1;
END $$
DELIMITER ;

-- Procedure: Add product
DELIMITER $$
CREATE PROCEDURE add_product(
    IN in_name VARCHAR(100),
    IN in_price FLOAT,
    IN in_title VARCHAR(200),
    IN in_created DATE,
    IN in_catalog VARCHAR(100),
    IN in_status BIT
)
BEGIN
    INSERT INTO Product (Product_Name, Product_Price, Product_Title, Product_created, Product_catalog, Product_Status)
    VALUES (in_name, in_price, in_title, in_created, in_catalog, in_status);
END $$
DELIMITER ;

-- Procedure: Update product by id
DELIMITER $$
CREATE PROCEDURE update_product(
    IN in_id INT,
    IN in_name VARCHAR(100),
    IN in_price FLOAT,
    IN in_title VARCHAR(200),
    IN in_created DATE,
    IN in_catalog VARCHAR(100),
    IN in_status BIT
)
BEGIN
    UPDATE Product
    SET Product_Name = in_name,
        Product_Price = in_price,
        Product_Title = in_title,
        Product_created = in_created,
        Product_catalog = in_catalog,
        Product_Status = in_status
    WHERE Product_Id = in_id;
END $$
DELIMITER ;

-- Procedure: Delete product by id
DELIMITER $$
CREATE PROCEDURE delete_product(IN in_id INT)
BEGIN
    DELETE FROM Product WHERE Product_Id = in_id;
END $$
DELIMITER ;

-- Procedure: Get product by id
DELIMITER $$
CREATE PROCEDURE get_product_by_id(IN in_id INT)
BEGIN
    SELECT * FROM Product WHERE Product_Id = in_id;
END $$
DELIMITER ;

-- Procedure: Search product by name (LIKE)
DELIMITER $$
CREATE PROCEDURE search_product_by_name(IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM Product WHERE Product_Name LIKE CONCAT('%', in_name, '%');
END $$
DELIMITER ;

-- Procedure: Count products by catalog
DELIMITER $$
CREATE PROCEDURE count_products_by_catalog(IN in_catalog VARCHAR(100), OUT out_count INT)
BEGIN
    SELECT COUNT(*) INTO out_count FROM Product WHERE Product_catalog = in_catalog;
END $$
DELIMITER ;
