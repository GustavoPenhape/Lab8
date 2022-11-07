-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`heroes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`heroes` (
  `idheroes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(10) NOT NULL,
  `edad` INT NOT NULL,
  `genero` VARCHAR(1) NOT NULL,
  `clase` VARCHAR(50) NOT NULL,
  `puntos_de_experiencia_iniciales` INT NOT NULL,
  `ataque` INT NOT NULL,
  `nivel inicial` INT NOT NULL,
  `pareja_id` INT NULL,
  `experiencia` VARCHAR(45) NULL,
  PRIMARY KEY (`idheroes`),
  INDEX `fk_heroes_heroes1_idx` (`pareja_id` ASC) VISIBLE,
  CONSTRAINT `fk_heroes_heroes1`
    FOREIGN KEY (`pareja_id`)
    REFERENCES `mydb`.`heroes` (`idheroes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`inventario_objetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inventario_objetos` (
  `idinventario_objetos` INT NOT NULL AUTO_INCREMENT,
  `heroes_idheroes` INT NOT NULL,
  PRIMARY KEY (`idinventario_objetos`),
  INDEX `fk_inventario_objetos_heroes1_idx` (`heroes_idheroes` ASC) VISIBLE,
  CONSTRAINT `fk_inventario_objetos_heroes1`
    FOREIGN KEY (`heroes_idheroes`)
    REFERENCES `mydb`.`heroes` (`idheroes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`catalogo_objetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`catalogo_objetos` (
  `idobjeto` INT NOT NULL AUTO_INCREMENT,
  `nombre_objeto` VARCHAR(45) NOT NULL,
  `efecto/uso` VARCHAR(45) NOT NULL,
  `peso` FLOAT NOT NULL,
  PRIMARY KEY (`idobjeto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`inventario_objetos_has_objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inventario_objetos_has_objeto` (
  `inventario_objetos_idinventario_objetos` INT NOT NULL,
  `objeto_idobjeto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  INDEX `fk_inventario_objetos_has_objeto_objeto1_idx` (`objeto_idobjeto` ASC) VISIBLE,
  INDEX `fk_inventario_objetos_has_objeto_inventario_objetos1_idx` (`inventario_objetos_idinventario_objetos` ASC) VISIBLE,
  CONSTRAINT `fk_inventario_objetos_has_objeto_inventario_objetos1`
    FOREIGN KEY (`inventario_objetos_idinventario_objetos`)
    REFERENCES `mydb`.`inventario_objetos` (`idinventario_objetos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventario_objetos_has_objeto_objeto1`
    FOREIGN KEY (`objeto_idobjeto`)
    REFERENCES `mydb`.`catalogo_objetos` (`idobjeto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`submenu_clases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`submenu_clases` (
  `clase_idclase` INT NOT NULL,
  `nombre_clase` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`clase_idclase`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`enemigos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`enemigos` (
  `idenemigos` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `ataque` INT NOT NULL,
  `experiencia_entregada` INT NOT NULL,
  `probabilidad_tirara_objeto` FLOAT NOT NULL,
  `genero` VARCHAR(1) NULL,
  `clase_id` INT NOT NULL,
  `objeto_id` INT NOT NULL,
  PRIMARY KEY (`idenemigos`),
  INDEX `fk_enemigos_submenu_clases1_idx` (`clase_id` ASC) VISIBLE,
  INDEX `fk_enemigos_catalogo_objetos1_idx` (`objeto_id` ASC) VISIBLE,
  CONSTRAINT `fk_enemigos_submenu_clases1`
    FOREIGN KEY (`clase_id`)
    REFERENCES `mydb`.`submenu_clases` (`clase_idclase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_enemigos_catalogo_objetos1`
    FOREIGN KEY (`objeto_id`)
    REFERENCES `mydb`.`catalogo_objetos` (`idobjeto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`elementos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`elementos` (
  `idelementos` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idelementos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`hechizos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`hechizos` (
  `idhechizos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `potencia` FLOAT NOT NULL,
  `precision` FLOAT NOT NULL,
  `nivel_aprendizaje` INT NULL,
  `hechizos_base` INT NULL,
  `elementos_idelementos` INT NOT NULL,
  PRIMARY KEY (`idhechizos`),
  INDEX `fk_hechizos_hechizos1_idx` (`hechizos_base` ASC) VISIBLE,
  INDEX `fk_hechizos_elementos1_idx` (`elementos_idelementos` ASC) VISIBLE,
  CONSTRAINT `fk_hechizos_hechizos1`
    FOREIGN KEY (`hechizos_base`)
    REFERENCES `mydb`.`hechizos` (`idhechizos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hechizos_elementos1`
    FOREIGN KEY (`elementos_idelementos`)
    REFERENCES `mydb`.`elementos` (`idelementos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`debilidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`debilidades` (
  `iddebilidades` INT NOT NULL,
  PRIMARY KEY (`iddebilidades`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fortalezas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fortalezas` (
  `idfortalezas` INT NOT NULL,
  PRIMARY KEY (`idfortalezas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`submenu_has_elementos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`submenu_has_elementos` (
  `submenu_clase_idclase` INT NOT NULL,
  `elementos_idelementos` INT NOT NULL,
  `porcentaje_danio_recibido` FLOAT NOT NULL,
  INDEX `fk_submenu_has_elementos_elementos1_idx` (`elementos_idelementos` ASC) VISIBLE,
  INDEX `fk_submenu_has_elementos_submenu1_idx` (`submenu_clase_idclase` ASC) VISIBLE,
  CONSTRAINT `fk_submenu_has_elementos_submenu1`
    FOREIGN KEY (`submenu_clase_idclase`)
    REFERENCES `mydb`.`submenu_clases` (`clase_idclase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_submenu_has_elementos_elementos1`
    FOREIGN KEY (`elementos_idelementos`)
    REFERENCES `mydb`.`elementos` (`idelementos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
