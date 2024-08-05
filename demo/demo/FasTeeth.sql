USE FasTeeth;

CREATE TABLE users (
    user_no INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(255) NOT NULL UNIQUE,
    user_name VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_birth DATE NOT NULL,
    user_phone VARCHAR(255),
    user_mail VARCHAR(255),
    gender VARCHAR(255)
) ENGINE=INNODB;

CREATE TABLE Dentist (
    doc_no INT PRIMARY KEY AUTO_INCREMENT,
    doc_id VARCHAR(255) NOT NULL UNIQUE,
    doc_name VARCHAR(255) NOT NULL,
    doc_hospital VARCHAR(255) NOT NULL,
    doc_pwd VARCHAR(255) NOT NULL,
    doc_phone VARCHAR(255),
    doc_mail VARCHAR(255)
) ENGINE=INNODB;

CREATE TABLE dentists (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    doc_no BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    category VARCHAR(255)
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    dentist_id INT NOT NULL,
    appointment_date_time DATETIME NOT NULL,
    description VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(user_no),
    FOREIGN KEY (dentist_id) REFERENCES Dentist(doc_no)
) ENGINE=INNODB;