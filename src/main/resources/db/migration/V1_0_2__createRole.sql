CREATE TABLE IF NOT EXISTS roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO roles (id, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'VISITOR'),
(4, 'USER'),
(5, 'VISITOR'),
(6, 'USER'),
(7, 'USER'),
(8, 'VISITOR'),
(9, 'USER'),
(10, 'ADMIN'),
(11, 'VISITOR'),
(12, 'VISITOR'),
(13, 'USER'),
(14, 'USER'),
(15, 'VISITOR'),
(16, 'USER'),
(17, 'VISITOR'),
(18, 'USER'),
(19, 'VISITOR'),
(20, 'VISITOR'),
(21, 'ADMIN');