CREATE DATABASE cart_management;
USE cart_management;

CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          price DOUBLE,
                          imageUrl VARCHAR(255)
);

CREATE TABLE productCarts (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              userId INT,
                              productId INT,
                              quantity INT
);

INSERT INTO products (name, price, imageUrl) VALUES
                                                 ('Product 1', 10.0, 'http://example.com/product1.jpg'),
                                                 ('Product 2', 20.0, 'http://example.com/product2.jpg'),
                                                 ('Product 3', 30.0, 'http://example.com/product3.jpg'),
                                                 ('Product 4', 40.0, 'http://example.com/product4.jpg'),
                                                 ('Product 5', 50.0, 'http://example.com/product5.jpg'),
                                                 ('Product 6', 60.0, 'http://example.com/product6.jpg'),
                                                 ('Product 7', 70.0, 'http://example.com/product7.jpg'),
                                                 ('Product 8', 80.0, 'http://example.com/product8.jpg'),
                                                 ('Product 9', 90.0, 'http://example.com/product9.jpg'),
                                                 ('Product 10', 100.0, 'http://example.com/product10.jpg');

INSERT INTO productCarts (userId, productId, quantity) VALUES
                                                           (1, 1, 2),
                                                           (1, 2, 1),
                                                           (2, 3, 5),
                                                           (2, 4, 3),
                                                           (3, 5, 4),
                                                           (3, 6, 2),
                                                           (4, 7, 1),
                                                           (4, 8, 6),
                                                           (5, 9, 3),
                                                           (5, 10, 2);

DELIMITER //
CREATE PROCEDURE display_cart(IN userId INT)
BEGIN
    SELECT p.id, p.name, p.price, p.imageUrl, pc.quantity
    FROM products p
             JOIN productCarts pc ON p.id = pc.productId
    WHERE pc.userId = userId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_to_cart(IN userId INT, IN productId INT, IN quantity INT)
BEGIN
    IF EXISTS (SELECT 1 FROM productCarts WHERE userId = userId AND productId = productId) THEN
        UPDATE productCarts SET quantity = quantity + quantity WHERE userId = userId AND productId = productId;
    ELSE
        INSERT INTO productCarts (userId, productId, quantity) VALUES (userId, productId, quantity);
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE remove_from_cart(IN userId INT, IN productId INT)
BEGIN
    DELETE FROM productCarts WHERE userId = userId AND productId = productId;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT id, name, price, imageUrl FROM products;
END //
DELIMITER ;


-- Bt4:
CREATE TABLE employees (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(255) NOT NULL,
                           birthday DATE,
                           phone VARCHAR(20),
                           email VARCHAR(255),
                           salary DOUBLE,
                           position VARCHAR(100)
);

INSERT INTO employees (name, birthday, phone, email, salary, position) VALUES
                                                                           ('John Doe', '1990-05-15', '1234567890', 'john.doe@example creux', 50000, 'Developer'),
                                                                           ('Jane Smith', '1985-08-22', '0987654321', 'jane.smith@example.com', 60000, 'Manager'),
                                                                           ('Alice Johnson', '1992-03-10', '5555555555', 'alice.j@example.com', 45000, 'Analyst'),
                                                                           ('Bob Wilson', '1988-11-30', '4444444444', 'bob.wilson@example.com', 52000, 'Designer'),
                                                                           ('Emma Brown', '1995-07-25', '3333333333', 'emma.brown@example.com', 48000, 'Tester'),
                                                                           ('Michael Lee', '1990-01-12', '2222222222', 'michael.lee@example.com', 55000, 'Developer'),
                                                                           ('Sarah Davis', '1987-09-18', '1111111111', 'sarah.davis@example.com', 62000, 'Manager'),
                                                                           ('David Clark', '1993-04-05', '6666666666', 'david.clark@example.com', 47000, 'Analyst'),
                                                                           ('Laura Adams', '1989-12-15', '7777777777', 'laura.adams@example.com', 51000, 'Designer'),
                                                                           ('Chris Evans', '1994-06-20', '8888888888', 'chris.evans@example.com', 49000, 'Tester');

DELIMITER //
CREATE PROCEDURE get_employees_paginated(
    IN page INT,
    IN page_size INT,
    IN sort_field VARCHAR(50),
    IN sort_order VARCHAR(10)
)
BEGIN
    SET @offset = (page - 1) * page_size;
    SET @query = CONCAT('SELECT * FROM employees ORDER BY ', sort_field, ' ', sort_order, ' LIMIT ? OFFSET ?');
    PREPARE stmt FROM @query;
    SET @page_size = page_size;
    SET @offset_val = @offset;
    EXECUTE stmt USING @page_size, @offset_val;
    DEALLOCATE PREPARE stmt;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE count_employees(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM employees;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_employee(
    IN p_name VARCHAR(255),
    IN p_birthday DATE,
    IN p_phone VARCHAR(20),
    IN p_email VARCHAR(255),
    IN p_salary DOUBLE,
    IN p_position VARCHAR(100)
)
BEGIN
    INSERT INTO employees (name, birthday, phone, email, salary, position)
    VALUES (p_name, p_birthday, p_phone, p_email, p_salary, p_position);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_employee(
    IN p_id INT,
    IN p_name VARCHAR(255),
    IN p_birthday DATE,
    IN p_phone VARCHAR(20),
    IN p_email VARCHAR(255),
    IN p_salary DOUBLE,
    IN p_position VARCHAR(100)
)
BEGIN
    UPDATE employees
    SET name = p_name, birthday = p_birthday, phone = p_phone, email = p_email, salary = p_salary, position = p_position
    WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_employee(IN p_id INT)
BEGIN
    DELETE FROM employees WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE search_employees(
    IN search_term VARCHAR(255),
    IN page INT,
    IN page_size INT,
    IN sort_field VARCHAR(50),
    IN sort_order VARCHAR(10)
)
BEGIN
    SET @offset = (page - 1) * page_size;
    SET @query = CONCAT('SELECT * FROM employees WHERE name LIKE ? OR id = ? ORDER BY ', sort_field, ' ', sort_order, ' LIMIT ? OFFSET ?');
    PREPARE stmt FROM @query;
    SET @search = CONCAT('%', search_term, '%');
    SET @id = IF(search_term REGEXP '^[0-9]+$', search_term, -1);
    SET @page_size = page_size;
    SET @offset_val = @offset;
    EXECUTE stmt USING @search, @id, @page_size, @offset_val;
    DEALLOCATE PREPARE stmt;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE count_search_employees(IN search_term VARCHAR(255), OUT total INT)
BEGIN
    SET @search = CONCAT('%', search_term, '%');
    SET @id = IF(search_term REGEXP '^[0-9]+$', search_term, -1);
    SELECT COUNT(*) INTO total FROM employees WHERE name LIKE @search OR id = @id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_employee_by_id(IN p_id INT)
BEGIN
    SELECT * FROM employees WHERE id = p_id;
END //
DELIMITER ;


-- bt1:
CREATE TABLE books (
                       bookCode VARCHAR(50) PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255),
                       category VARCHAR(100),
                       quantity INT
);

INSERT INTO books (bookCode, title, author, category, quantity) VALUES
                                                                    ('B001', 'The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 10),
                                                                    ('B002', '1984', 'George Orwell', 'Dystopian', 15),
                                                                    ('B003', 'To Kill a Mockingbird', 'Harper Lee', 'Fiction', 8),
                                                                    ('B004', 'Pride and Prejudice', 'Jane Austen', 'Romance', 12),
                                                                    ('B005', 'The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 7),
                                                                    ('B006', 'Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', 20),
                                                                    ('B007', 'Animal Farm', 'George Orwell', 'Satire', 9),
                                                                    ('B008', 'Brave New World', 'Aldous Huxley', 'Dystopian', 11),
                                                                    ('B009', 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 14),
                                                                    ('B010', 'Fahrenheit 451', 'Ray Bradbury', 'Dystopian', 6);

DELIMITER //
CREATE PROCEDURE get_all_books()
BEGIN
    SELECT * FROM books;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_book(
    IN p_bookCode VARCHAR(50),
    IN p_title VARCHAR(255),
    IN p_author VARCHAR(255),
    IN p_category VARCHAR(100),
    IN p_quantity INT
)
BEGIN
    INSERT INTO books (bookCode, title, author, category, quantity)
    VALUES (p_bookCode, p_title, p_author, p_category, p_quantity);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_book(
    IN p_bookCode VARCHAR(50),
    IN p_title VARCHAR(255),
    IN p_author VARCHAR(255),
    IN p_category VARCHAR(100),
    IN p_quantity INT
)
BEGIN
    UPDATE books
    SET title = p_title, author = p_author, category = p_category, quantity = p_quantity
    WHERE bookCode = p_bookCode;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_book(IN p_bookCode VARCHAR(50))
BEGIN
    DELETE FROM books WHERE bookCode = p_bookCode;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE search_books(IN p_searchTerm VARCHAR(255))
BEGIN
    SELECT * FROM books
    WHERE title LIKE CONCAT('%', p_searchTerm, '%') OR bookCode = p_searchTerm;
END //
DELIMITER ;



-- bt2:
CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL, -- Store hashed passwords in production
                       email VARCHAR(255),
                       phone VARCHAR(20)
);

INSERT INTO users (username, password, email, phone) VALUES
    ('admin', 'password123', 'admin@example.com', '1234567890');

DELIMITER //
CREATE PROCEDURE add_user(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_phone VARCHAR(20)
)
BEGIN
    INSERT INTO users (username, password, email, phone)
    VALUES (p_username, p_password, p_email, p_phone);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE authenticate_user(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT * FROM users WHERE username = p_username AND password = p_password;
END //
DELIMITER ;