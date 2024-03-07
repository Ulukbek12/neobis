CREATE TABLE bakeryItem(
bakery_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
type VARCHAR(20),
price DOUBLE
)

CREATE TABLE customer(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
bakery_id INT,
name VARCHAR(20),
phoneNumber VARCHAR(20),
FOREIGN KEY (bakery_id) REFERENCES bakeryItem(bakery_id)
);

ALTER TABLE customer
AUTO_INCREMENT = 10;


CREATE TABLE bakeryOrder(
order_id INT PRIMARY KEY AUTO_INCREMENT,
fullAmountOf DOUBLE,
status VARCHAR(20),
customer_id INT
);
ALTER TABLE bakeryOrder
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id) REFERENCES customer(customer_id);
ALTER TABLE bakeryOrder
AUTO_INCREMENT = 100;


CREATE TABLE payment(
payment_id INT PRIMARY KEY AUTO_INCREMENT,
amountOfPayment DOUBLE,
methodPayment VARCHAR(20),
order_id INT,
FOREIGN KEY(order_id) REFERENCES bakeryOrder(order_id)
);
ALTER TABLE payment
AUTO_INCREMENT = 1000;

SELECT * FROM payment;

CREATE TABLE delivery(
delivery_id INT PRIMARY KEY AUTO_INCREMENT,
address VARCHAR(20),
status VARCHAR(20),
order_id INT
);
ALTER TABLE delivery
AUTO_INCREMENT = 10000,
ADD CONSTRAINT fk_order_id
FOREIGN KEY(order_id) REFERENCES payment(order_id);