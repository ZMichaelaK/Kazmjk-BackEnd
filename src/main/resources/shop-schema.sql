DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart`(
	`id` INT PRIMARY KEY AUTO_INCREMENT
	);

CREATE TABLE `item`(
	`item_id` INT PRIMARY KEY AUTO_INCREMENT,
	`quantity` INT,
	`image_url` VARCHAR(255),
	`item_description` VARCHAR(255),
	`item_name` VARCHAR(255),	
	`price` VARCHAR(255),
	`cart_id` INT,
	FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
	);
