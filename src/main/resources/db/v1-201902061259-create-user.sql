CREATE TABLE `dgou_user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_login_id` VARCHAR(100) NOT NULL,
  `user_login_password` VARCHAR(32) NOT NULL,
  `user_is_admin` CHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_login_id_UNIQUE` (`user_login_id` ASC));

CREATE TABLE `dgou_session` (
  `sesn_id` BIGINT NOT NULL AUTO_INCREMENT,
  `sesn_token` VARCHAR(50) NOT NULL,
  `sesn_last_updated` DATETIME NOT NULL,
  `sesn_payload` TEXT NULL,
  PRIMARY KEY (`sesn_id`));

INSERT INTO `dgou_user` (`user_login_id`, `user_login_password`, `user_is_admin`) VALUES ('norriszhang@outlook.com', 'c8837b23ff8aaa8a2dde915473ce0991', 'Y');