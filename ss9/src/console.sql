CREATE DATABASE movie_ticketing;
USE movie_ticketing;

CREATE TABLE customers (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           username VARCHAR(50) UNIQUE NOT NULL,
                           phone VARCHAR(15),
                           address VARCHAR(255),
                           gender VARCHAR(10),
                           email VARCHAR(100) UNIQUE NOT NULL,
                           password VARCHAR(255) NOT NULL
);

CREATE TABLE movies (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(100) NOT NULL,
                        director VARCHAR(50),
                        genre VARCHAR(50),
                        description TEXT,
                        duration INT,
                        language VARCHAR(50)
);

CREATE TABLE screen_rooms (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              screen_room_name VARCHAR(50) NOT NULL,
                              total_seat INT NOT NULL
);

CREATE TABLE schedules (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           movie_title VARCHAR(100) NOT NULL,
                           show_time DATETIME NOT NULL,
                           screen_room_id BIGINT,
                           available_seats INT NOT NULL,
                           format VARCHAR(10),
                           FOREIGN KEY (screen_room_id) REFERENCES screen_rooms(id)
);

CREATE TABLE seats (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       screen_room_id BIGINT,
                       price DOUBLE DEFAULT 50000,
                       status VARCHAR(20) DEFAULT 'AVAILABLE',
                       FOREIGN KEY (screen_room_id) REFERENCES screen_rooms(id)
);

CREATE TABLE tickets (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         customer_id BIGINT,
                         schedule_id BIGINT,
                         total_money DOUBLE,
                         created_at DATETIME,
                         FOREIGN KEY (customer_id) REFERENCES customers(id),
                         FOREIGN KEY (schedule_id) REFERENCES schedules(id)
);

CREATE TABLE ticket_seats (
                              ticket_id BIGINT,
                              seat_id BIGINT,
                              PRIMARY KEY (ticket_id, seat_id),
                              FOREIGN KEY (ticket_id) REFERENCES tickets(id),
                              FOREIGN KEY (seat_id) REFERENCES seats(id)
);

INSERT INTO customers (username, phone, address, gender, email, password)
VALUES ('john_doe', '1234567890', '123 Main St', 'Male', 'john@example.com', 'password123');

INSERT INTO movies (title, director, genre, description, duration, language)
VALUES ('Inception', 'Christopher Nolan', 'Sci-Fi', 'A thief enters dreams to steal secrets.', 148, 'English');

INSERT INTO screen_rooms (screen_room_name, total_seat)
VALUES ('Room 1', 100);

INSERT INTO schedules (movie_title, show_time, screen_room_id, available_seats, format)
VALUES ('Inception', '2025-05-16 19:00:00', 1, 100, '3D');

INSERT INTO seats (screen_room_id, price, status)
VALUES (1, 50000, 'AVAILABLE'), (1, 50000, 'AVAILABLE');

DELIMITER //
CREATE PROCEDURE validate_customer(IN p_username VARCHAR(50), IN p_password VARCHAR(255), OUT p_customer_id BIGINT)
BEGIN
    SELECT id INTO p_customer_id
    FROM customers
    WHERE username = p_username AND password = p_password;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_all_movies()
BEGIN
    SELECT * FROM movies;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_movie_by_id(IN p_id BIGINT)
BEGIN
    SELECT * FROM movies WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_schedules_by_movie(IN p_movie_title VARCHAR(100))
BEGIN
    SELECT s.*, sr.screen_room_name
    FROM schedules s
             JOIN screen_rooms sr ON s.screen_room_id = sr.id
    WHERE s.movie_title = p_movie_title AND s.show_time >= NOW();
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_seats_by_screen_room(IN p_screen_room_id BIGINT)
BEGIN
    SELECT * FROM seats WHERE screen_room_id = p_screen_room_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE book_ticket(
    IN p_customer_id BIGINT,
    IN p_schedule_id BIGINT,
    IN p_total_money DOUBLE,
    IN p_seat_ids VARCHAR(255),
    OUT p_ticket_id BIGINT
)
BEGIN
    DECLARE v_seat_id BIGINT;
    DECLARE v_done INT DEFAULT 0;
    DECLARE cur CURSOR FOR SELECT CAST(REGEXP_SUBSTR(p_seat_ids, '[0-9]+') AS UNSIGNED) AS seat_id;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_done = 1;

    START TRANSACTION;

    INSERT INTO tickets (customer_id, schedule_id, total_money, created_at)
    VALUES (p_customer_id, p_schedule_id, p_total_money, NOW());

    SET p_ticket_id = LAST_INSERT_ID();

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO v_seat_id;
        IF v_done THEN LEAVE read_loop; END IF;

        UPDATE seats SET status = 'BOOKED' WHERE id = v_seat_id;
        INSERT INTO ticket_seats (ticket_id, seat_id) VALUES (p_ticket_id, v_seat_id);
    END LOOP;
    CLOSE cur;

    UPDATE schedules
    SET available_seats = available_seats - (SELECT COUNT(*) FROM seats WHERE FIND_IN_SET(id, p_seat_ids))
    WHERE id = p_schedule_id;

    COMMIT;
END //
DELIMITER ;

