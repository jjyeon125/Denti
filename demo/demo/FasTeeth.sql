use FasTeeth;

CREATE TABLE users (
    user_no INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(255) NOT NULL UNIQUE,
    user_name VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_birth DATE NOT NULL,
    user_phone VARCHAR(255),
    gender VARCHAR(255)
) ENGINE=INNODB;

-- 저도 긁어와서 잘 모릅니다;; 잘 아시는 분은 수정 부탁드립니다!