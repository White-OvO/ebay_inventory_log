DROP TABLE IF EXISTS sold_inventory;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS inventory;


-- item number is 6 numbers with a dash
--     567-456inventorycustomerinventoryinvetorytransactionscustomer


-- category needs to be an enum
CREATE TABLE inventory(
inventory_id INT AUTO_INCREMENT NOT NULL,
category_id  ENUM('Electronics', 'Legos',  'Miscellaneous') NOT NULL, 
item_number INT NOT NULL,
item_name VARCHAR(150) NOT NULL,
amount_avaliable INT NULL,
seller_name VARCHAR(100)NOT NULL,

 PRIMARY KEY (inventory_id)
);
SELECT * FROM inventory;


-- THE MAIN TABLE , WITHOUT CUSTOMERS THERES NO TRANSCATIONS.

-- what and when should i use constraint


-- Ebayuser names are numbers and words




CREATE TABLE customer(
 customer_id INT AUTO_INCREMENT NOT NULL ,
 Ebay_username VARCHAR(50),
 PRIMARY KEY (customer_id)
 
);

Select * from customer;

-- THIS TABLE IS SO WE CAN HAUNT DOWN WHICH SHIPPING CARRIER WE NEED TO CHASE DOWN FOR INSURANCE MONEY
 -- transacations
CREATE TABLE transactions(
 transaction_id INT AUTO_INCREMENT NOT NULL,
 customer_id INT NOT NULL,
 date_sold DATE NULL,
 buyer_paid DECIMAL (4,2),
 taxes_per_transaction DECIMAL (4,2),
 shipping_cost DECIMAL(4,2),
 seller_fee DECIMAL(4,2),
  PRIMARY KEY (transaction_id),
  FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
  
);
 
 
 

SELECT * FROM transactions;



CREATE TABLE sold_inventory(
order_id INT AUTO_INCREMENT NOT NULL , 
Ebay_order_number INT  NOT NULL,
transaction_id INT NOT NULL,
item_number INT NOT NULL,
 PRIMARY KEY (order_id) ,
  FOREIGN KEY (transaction_Id) REFERENCES transactions (transaction_Id) ON DELETE CASCADE
);



