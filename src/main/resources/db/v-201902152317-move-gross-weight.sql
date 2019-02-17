ALTER TABLE `dgou_price` 
ADD COLUMN `prce_gross_weight` DECIMAL(5,2) NULL AFTER `prce_count`;

update dgou_price prce join dgou_product prod on prce.prce_prod_id=prod.prod_id
set prce.prce_gross_weight=prod.prod_gross_weight
;

ALTER TABLE `dgou_product` 
DROP COLUMN `prod_gross_weight`;

ALTER TABLE `dgou_guige` 
CHANGE COLUMN `guge_amount` `guge_amount` DECIMAL(7,2) NOT NULL ,
CHANGE COLUMN `guge_unit` `guge_unit` VARCHAR(10) NOT NULL ;
;