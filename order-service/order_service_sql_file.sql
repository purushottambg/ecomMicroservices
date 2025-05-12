use ms_orderservice;
select * from ms_orderservice.orderitems;
select * from ms_orderservice.orders;

alter table orders drop column version;

delete from ms_orderservice.orders where id>11; 
 
-- Enable them back
SET FOREIGN_KEY_CHECKS = 1;

 

INSERT INTO `orders` (`id`, `order_status`, `price`) VALUES
(1, 'CONFIRMED', 250.75),
(2, 'PENDING', 180.00),
(3, 'COMPLETE', 450.20),
(4, 'INPROGRESS', 330.00),
(5, 'CANCELLED', 100.00),
(6, 'COMPLETE', 299.99),
(7, 'CONFIRMED', 520.00),
(8, 'INPROGRESS', 410.50),
(9, 'PENDING', 150.25),
(10, 'COMPLETE', 375.00);


INSERT INTO `orderitems` (`id`, `product_id`, `quantity`, `order_id`) VALUES
(1, 1, 2, 1),
(2, 3, 1, 1),

(3, 2, 4, 2),

(4, 4, 2, 3),
(5, 5, 1, 3),

(6, 1, 3, 4),

(7, 3, 1, 5),

(8, 5, 2, 6),
(9, 2, 1, 6),

(10, 4, 2, 7),
(11, 1, 1, 7),

(12, 3, 3, 8),

(13, 2, 1, 9),

(14, 5, 2, 10),
(15, 4, 1, 10);

INSERT INTO `orderitems` (`id`, `product_id`, `quantity`, `order_id`) VALUES
(16, 1, 2, 11);

show tables;

commit;