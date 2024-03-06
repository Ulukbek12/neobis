CREATE TABLE customer(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
bakery_id INT,
name VARCHAR(20),
phoneNumber VARCHAR(20),
FOREIGN KEY (bakery_id) REFERENCES bakeryItem(bakery_id)
);

ALTER TABLE customer
AUTO_INCREMENT = 10;