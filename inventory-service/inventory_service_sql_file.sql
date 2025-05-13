use ms_inventoryservice; 

show tables;

select * from products;

ALTER TABLE products MODIFY COLUMN product_id BIGINT NOT NULL AUTO_INCREMENT;

commit;