use vlsdb;
drop table users;

CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  user varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  phone int NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO USERS (id, user, email, phone, password) values
(1, "Teddy Bear", "test@ge.com", 92008080, "rotiprata");
