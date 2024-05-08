-DDL
CREATE DATABASE rentalcar_server_db;
CREATE DATABASE rentcar_db;
USE rentcar_db;

CREATE TABLE users (
`user_id` VARCHAR(20) PRIMARY KEY,
`user_password` VARCHAR(255) NOT NULL,
`user_name` VARCHAR(20) NOT NULL,
`user_birth` DATE NOT NULL,
`user_telecom` VARCHAR(3) NOT NULL CHECK (`user_telecom` IN ('skt', 'kt', 'lgt')),
`user_phone` VARCHAR(11) NOT NULL UNIQUE KEY CHECK(`user_phone` REGEXP ('^[0-9]{11}$')),
`admin` TINYINT NOT NULL DEFAULT(0),
`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
`mod_date` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW()
);

SELECT * FROM users;

TRUNCATE TABLE users;

CREATE TABLE cars (
`car_code` INT AUTO_INCREMENT PRIMARY KEY,
`car_num` VARCHAR(7),
`car_abroad` ENUM('국산', '외제') NOT NULL,
`car_brand` VARCHAR(20) NOT NULL,
`car_name` VARCHAR(20) NOT NULL,
`car_type` CHAR(2) NOT NULL CHECK (`car_type` IN ('소형', '중형', '대형')),
`car_seat` ENUM('2', '5', '9') NOT NULL,
`car_oil` ENUM('휘발유', '경유') NOT NULL,
`car_year` INT NOT NULL,
`car_price` INT NOT NULL,
`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
`mod_date` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW()
) AUTO_INCREMENT = 1000;

SELECT * FROM cars;
TRUNCATE TABLE cars;

INSERT INTO cars(car_num, car_abroad, car_brand, car_name, car_type, car_seat, car_oil, car_year, car_price)
VALUES 
("21하2142", "국산", "현대", "더 뉴 아반떼", "중형", '5', "휘발유", 2001, 5000),
("32호1924", "외제", "BMW", "BMW 3 Series", "중형", '5', "휘발유", 2015, 7000),
("97허7890", "외제", "Audi", "아우디 A6", "대형", '5', "휘발유", 2012, 6000),
("56하6321", "국산", "기아", "K5", "중형", '5', "휘발유", 2019, 5300),
("45호9325", "외제", "Mercedes-Benz", "메르세데스 E-Class", "대형", '5', "휘발유", 2020, 8000),
("78하2356", "국산", "쌍용", "QM6", "대형", '9', "휘발유", 2020, 4900),
("27호7512", "국산", "기아", "스포티지", "중형", '5', "휘발유", 2018, 6700),
("13허5321", "외제", "Jaguar", "재규어 F-Type", "대형", '2', "휘발유", 2016, 9000),
("86호1245", "외제", "Porsche", "포르쉐 카이엔", "대형", '5', "휘발유", 2022, 9500),
("57하7890", "국산", "쌍용", "티볼리", "소형", '5', "휘발유", 2023, 4000),
("84호2431", "국산", "기아", "K3", "소형", '5', "휘발유", 2020, 3600),
("29하9823", "외제", "Lamborghini", "람보르기니 우르스", "대형", '5', "휘발유", 2019, 9500),
("17호7612", "외제", "Ferrari", "페라리 488 GTB", "대형", '2', "휘발유", 2018, 9800),
("92하1982", "외제", "Lexus", "렉서스 RX", "대형", '5', "휘발유", 2016, 8500),
("28하3294", "외제", "Rolls-Royce", "롤스로이스 고스트", "대형", '5', "휘발유", 2019, 9900),
("46호8921", "국산", "기아", "K7", "대형", '5', "휘발유", 2019, 6900),
("59하5214", "외제", "Bentley", "벤틀리 벤테이가", "대형", '5', "휘발유", 2023, 9600),
("67호1478", "국산", "쌍용", "무쏘", "중형", '5', "휘발유", 2021, 5700),
("33허2345", "외제", "Maserati", "마세라티 그란투리스모", "대형", '5', "휘발유", 2020, 9200),
("88하3321", "국산", "기아", "모닝", "소형", '5', "휘발유", 2024, 3200),
("75하4712", "외제", "Bugatti", "부가티 베이론", "대형", '2', "휘발유", 2017, 9800),
("56호7321", "외제", "Ferrari", "페라리 812 슈퍼패스트", "대형", '2', "휘발유", 2019, 9900),
("49하1245", "국산", "현대", "그랜저", "대형", '5', "휘발유", 2020, 6500),
("72하3579", "외제", "McLaren", "맥라렌 720S", "대형", '2', "휘발유", 2022, 9600),
("82하4891", "국산", "쌍용", "코란도", "대형", '5', "휘발유", 2023, 6200),
("68호1473", "외제", "Lamborghini", "람보르기니 우라칸", "대형", '2', "휘발유", 2024, 10000);

CREATE TABLE reservations (
`reservation_num` INT PRIMARY KEY,
`user_id` VARCHAR(20) REFERENCES users (`user_id`),
`car_code` INT REFERENCES cars (`car_code`),
`car_price` INT REFERENCES cars (`car_price`),
`borrow_date` DATETIME NOT NULL,
`return_date` DATETIME NOT NULL,
`rent_place` VARCHAR(20) NOT NULL,
`status` ENUM('예약중', '대여중', '반납완료', '예약취소') NOT NULL,
`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
`mod_date` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW()
);

SELECT * FROM reservations;

CREATE TABLE board (
`board_code` INT AUTO_INCREMENT PRIMARY KEY,
`user_id` VARCHAR(20) REFERENCES users (`user_id`),
`title` VARCHAR(30) NOT NULL,
`content` VARCHAR(1000) NOT NULL,
`admin` TINYINT REFERENCES users (`admin`),
`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
`mod_date` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW()
) AUTO_INCREMENT = 1000;
