INSERT INTO orders (id, order_status, price) VALUES
(1, 'CONFIRMED', 250.00),
(2, 'INPROGRESS', 780.50),
(3, 'COMPLETE', 1299.99),
(4, 'PENDING', 99.99),
(5, 'CANCELLED', 550.00),
(6, 'COMPLETE', 349.90),
(7, 'CONFIRMED', 1200.00),
(8, 'PENDING', 220.40),
(9, 'INPROGRESS', 640.00),
(10, 'COMPLETE', 875.75);


INSERT INTO orderitems (id, product_id, quantity, order_id) VALUES
(1, 2, 1, 1),
(2, 4, 2, 1),
(3, 3, 1, 2),
(4, 1, 4, 2),
(5, 6, 1, 3),
(6, 7, 2, 3),
(7, 2, 1, 4),
(8, 5, 3, 5),
(9, 8, 2, 6),
(10, 9, 1, 7),
(11, 10, 2, 7),
(12, 1, 3, 8),
(13, 4, 2, 9),
(14, 3, 1, 10),
(15, 6, 1, 10);


INSERT INTO orders_order_items (orders_entity_id, order_items_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(5, 8),
(6, 9),
(7, 10),
(7, 11),
(8, 12),
(9, 13),
(10, 14),
(10, 15);
