DROP TABLE IF EXISTS sku;  
CREATE TABLE sku (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
sku VARCHAR(50) NOT NULL,  
name varchar(50) NOT NULL  ,
description varchar(50) NOT NULL  ,
price INT(10) NOT NULL  
);  