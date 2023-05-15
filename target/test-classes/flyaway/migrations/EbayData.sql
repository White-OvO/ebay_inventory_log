

--customer
INSERT INTO customer (customer_id, Ebay_username) VALUES (1, 'ronnyalacost0');
INSERT INTO customer (customer_id, Ebay_username) VALUES (2, 'aaatechnologies');
INSERT INTO customer (customer_id, Ebay_username) VALUES (3, 'joseplope_85');
INSERT INTO customer (customer_id, Ebay_username) VALUES (4, 'canruo.ying');
INSERT INTO customer (customer_id, Ebay_username) VALUES (5, 'uw91');
INSERT INTO customer (customer_id, Ebay_username) VALUES (6, 'ty-89133');





--transactions
INSERT INTO transactions (transaction_id, customer_id, date_sold,buyer_paid,taxes_per_transaction,shipping_cost,seller_fees) VALUES (1,1,03/08/2023, 12.84, 0.84, 2.00, 2.00);
INSERT INTO transactions (transaction_id, customer_id, date_sold,buyer_paid,taxes_per_transaction,shipping_cost,seller_fees) VALUES (2,2,03/08/2023, 29.49, 1.40, 8.09, 4.21);
INSERT INTO transactions (transaction_id, customer_id, date_sold,buyer_paid,taxes_per_transaction,shipping_cost,seller_fees) VALUES (3,3,04/11/2023, 16.22, 1.22, 6.05, 2.45);
INSERT INTO transactions (transaction_id, customer_id, date_sold,buyer_paid,taxes_per_transaction,shipping_cost,seller_fees) VALUES (4,4,04/27/2023, 308.66, 22.81, 65.41, 41.20);
INSERT INTO transactions (transaction_id, customer_id, date_sold,buyer_paid,taxes_per_transaction,shipping_cost,seller_fees) VALUES (5,5,04/26/2023, 26.50, 1.50, 5.50, 3.81);
INSERT INTO transactions (transaction_id, customer_id, date_sold,buyer_paid,taxes_per_transaction,shipping_cost,seller_fees) VALUES (6,6,12/17/2022, 226.75, 16.75, 10.00, 29.55);





--sold inventory
INSERT INTO sold_inventory (order_id,Ebay_order_number,transacation_id, item_number ) VALUES (1,16-09794-95100,1,226-554,145-456);
INSERT INTO sold_inventory (order_id,Ebay_order_number,transacation_id, item_number ) VALUES (2,14-09796-03037,2,645-445,256-456);
INSERT INTO sold_inventory (order_id,Ebay_order_number,transacation_id, item_number ) VALUES (3,27-09922-17636,3,228-569,345-569);
INSERT INTO sold_inventory (order_id,Ebay_order_number,transacation_id, item_number ) VALUES (4,16-09992-44748,4,245-569,455-566);
INSERT INTO sold_inventory (order_id,Ebay_order_number,transacation_id, item_number ) VALUES (5,25-09983-08064,5,226-445,544-556);
INSERT INTO sold_inventory (order_id,Ebay_order_number,transacation_id, item_number ) VALUES (6,12-09481-40317,6,226-569,456-564);


--inventory


INSERT INTO inventory (inventory_id,category_id,item_number,item_name,amount_avaliable,seller_name)) VALUES (1,'Electronics',1,'MIMD 3-in-1 GC Controller Adapter for Nintendo Switch/Nintendo Wii U/PC',4, pineapple express );

INSERT INTO inventory (inventory_id,category_id,item_number,item_name,amount_avaliable,seller_name) VALUES (2,'Electronics',2,'3340 Battery for Dell V131 2nd generation ,Latitude 3340 451-BBJB 451-BBIZ',4, pineapple express );

INSERT INTO inventory (inventory_id,category_id,item_number,item_name,amount_avaliable,seller_name) VALUES (4,'Electronics',4,'Dell UltraSharp U2719D 27in IPS LED Widescreen Monitor - Black', 4 , pineapple express );
 
INSERT INTO inventory (inventory_id,category_id,item_number,item_name,amount_avaliable,seller_name)  VALUES (6,'Electronics', 6, 'NINTENDO ENTERTAINMENT SYSTEM: NES CLASSIC EDITION', 4, pineapple express );



-- inventory

 
INSERT INTO inventory (inventory_id,category_id,item_number,item_name,amount_avaliable,seller_name) VALUES (3,'Legos', 3, 'MLB Baseball 3D Logo Puzzle Construction Block Set - Miami Logo', 4 , nellis );



--inventory

INSERT INTO inventory (inventory_id,category_id,item_number,item_name,amount_avaliable,seller_name) VALUES (5,'Miscellaneous', 5, 'Seats stop Gap S-Line',4, nellis);
































