CREATE TABLE IF NOT EXISTS user (
  id int(11) NOT NULL,
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO user (id, `first_name`, `last_name`, `email`) VALUES
(1, 'Tallie', 'Bessell', 'tbessell0@unicef.org'),
(2, 'Rivkah', 'Rugiero', 'rrugiero1@umn.edu'),
(3, 'Dulsea', 'Coslett', 'dcoslett2@google.fr'),
(4, 'Heloise', 'Kiley', 'hkiley3@google.co.jp'),
(5, 'Agnese', 'Gannaway', 'agannaway4@japanpost.jp'),
(6, 'Mollie', 'Lavallin', 'mlavallin5@cornell.edu'),
(7, 'Pauletta', 'Ashdown', 'pashdown6@scribd.com'),
(8, 'Euell', 'Cofax', 'ecofax7@bandcamp.com'),
(9, 'Jobyna', 'Skullet', 'jskullet8@virginia.edu'),
(10, 'Barnett', 'Krug', 'bkrug9@techcrunch.com'),
(11, 'Abbye', 'Zappel', 'azappela@wikipedia.org'),
(12, 'Eduino', 'Roust', 'eroustb@jalbum.net'),
(13, 'Marianne', 'De la Eglise', 'mdelaeglisec@creativecommons.com'),
(14, 'Weidar', 'Graundisson', 'wgraundissond@yolasite.com'),
(15, 'Levi', 'Graith', 'lgraithe@independent.co.uk'),
(16, 'Maritsa', 'Fellnee', 'mfellneef@so-net.ne.jp'),
(17, 'Jackie', 'Pattle', 'jpattleg@cisco.com'),
(18, 'Natassia', 'Woltering', 'nwolteringh@etsy.com'),
(19, 'Casi', 'Randle', 'crandlei@miibeian.gov.cn'),
(20, 'Verney', 'Channer', 'vchannerj@technorati.com'),
(21, 'Antonio', 'Pavkovic', 'antoniopavkovic123@gmail.com');