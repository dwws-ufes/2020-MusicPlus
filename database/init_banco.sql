
-- CREATE DATABASE musicplus;
CREATE USER 'musicplus'@'%' IDENTIFIED WITH mysql_native_password BY 'senha123';
GRANT ALL ON musicplus.* TO 'musicplus'@'%';
