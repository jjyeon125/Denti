use FasTeeth;

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
) ENGINE=INNODB
