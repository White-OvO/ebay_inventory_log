USE ebay_client;
DROP TABLE IF EXISTS sold_inventory;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS inventory;



CREATE TABLE inventory(
inventory_id INT AUTO_INCREMENT NOT NULL,
category_id  ENUM('Electronics', 'Legos',  'Miscellaneous', 'Clothing', 'House') NOT NULL, 
item_number INT NOT NULL,
item_name VARCHAR(150) NOT NULL,
amount_avaliable INT NULL,
seller_name VARCHAR(100)NOT NULL,

 PRIMARY KEY (inventory_id)
);


CREATE TABLE customer(
 customer_id INT AUTO_INCREMENT NOT NULL ,
 Ebay_username VARCHAR(50),
 PRIMARY KEY (customer_id)

  
);


CREATE TABLE transactions(
 transactions_id INT AUTO_INCREMENT NOT NULL,
 customer_id INT,
 date_sold VARCHAR(100) NULL,
 buyer_paid INT ,
 taxes_per_transaction INT ,
 shipping_cost INT,
 seller_fee INT,
  PRIMARY KEY (transactions_id),
  FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
  
);


CREATE TABLE sold_inventory(
order_id INT AUTO_INCREMENT NOT NULL ,
inventory_id INT NOT NULL, 
Ebay_order_number INT  NOT NULL,
transactions_id INT NOT NULL,
 PRIMARY KEY (order_id) ,
  FOREIGN KEY (transactions_Id) REFERENCES transactions (transactions_Id) ON DELETE CASCADE,
FOREIGN KEY (inventory_id) REFERENCES inventory (inventory_id) ON DELETE CASCADE
);
SELECT * FROM sold_inventory;