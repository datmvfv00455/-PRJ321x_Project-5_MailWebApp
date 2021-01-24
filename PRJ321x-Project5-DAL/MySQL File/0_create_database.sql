CREATE DATABASE IF NOT EXISTS prj321x_project5;

USE prj321x_project5;
 
CREATE TABLE user_table(
    user_id int not null auto_increment,
    user_name varchar(60) not null,
    user_password varchar(255) not null,

    PRIMARY KEY (user_id)
);

 
 
INSERT INTO  user_table(user_name, user_password)
VALUES ('operator',  'operator#A1');

INSERT INTO  user_table(user_name, user_password)
VALUES ('operator1',  'operator#A1');

INSERT INTO  user_table(user_name, user_password)
VALUES ('operator2',  'operator#A1');

INSERT INTO  user_table(user_name, user_password)
VALUES ('operator3',  'operator#A1');
  
 