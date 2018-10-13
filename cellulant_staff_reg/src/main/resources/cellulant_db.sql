-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cellulant_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cellulant_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cellulant_db` ;
USE `cellulant_db` ;

-- -----------------------------------------------------
-- Table `cellulant_db`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellulant_db`.`department` ;

CREATE TABLE IF NOT EXISTS `cellulant_db`.`department` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `date_modified` VARCHAR(45) NULL,
  `date_created` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cellulant_db`.`staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cellulant_db`.`staff` ;

CREATE TABLE IF NOT EXISTS `cellulant_db`.`staff` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email_address` VARCHAR(45) NULL,
  `date_modified` VARCHAR(45) NULL,
  `date_created` VARCHAR(45) NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_staff_department_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_staff_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `cellulant_db`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
