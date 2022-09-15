CREATE TABLE IF NOT EXISTS privileges (
  id int(11) NOT NULL AUTO_INCREMENT,
  privilege_name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO privileges (id, `privilege_name`) VALUES
(1, 'read_write_delete'),
(2, 'read_write'),
(3, 'read'),
(4, 'read_write'),
(5, 'read'),
(6, 'read_write'),
(7, 'read_write'),
(8, 'read'),
(9, 'read_write'),
(10, 'read_write_delete'),
(11, 'read'),
(12, 'read'),
(13, 'read_write'),
(14, 'read_write'),
(15, 'read'),
(16, 'read_write'),
(17, 'read'),
(18, 'read_write'),
(19, 'read'),
(20, 'read'),
(21, 'read_write_delete');