08/02/2024 
Доработка и оформление по ТЗ


В подключенном MySQL репозитории создать базу данных “Друзья человека”
______________________________________________________________________


CREATE SCHEMA `Human_frends` ;

_____________________________________________________________________

Создать таблицы с иерархией  в БД
_____________________________________________________________________
CREATE TABLE `Human_frends`.`animals_class` (
`id` INT NOT NULL AUTO_INCREMENT,
`class_name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO `Human_frends`.`animals_class` (`class_name`)
VALUES ('домашние');
INSERT INTO `Human_frends`.`animals_class` (`class_name`)
VALUES ('вьючные');


CREATE TABLE `Human_frends`.`packed_animals` (
`id_packed_animals` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_packed_animals`),
INDEX `id_class_idx` (`id_class` ASC) VISIBLE,
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`animals_class` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);


INSERT INTO `Human_frends`.`packed_animals` (`name`, `id_class`)
VALUES ('Лошади', '2');
INSERT INTO `Human_frends`.`packed_animals` (`name`, `id_class`) 
VALUES ('Ослы', '2');
INSERT INTO `Human_frends`.`packed_animals` (`name`,`id_class`)
VALUES ('Верблюды','2'');


CREATE TABLE `Human_frends`.`home_animals` (
`id_home_animals` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_home_animals`),
INDEX `id_class_idx` (`id_class` ASC) VISIBLE,
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`animals_class` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

INSERT INTO `Human_frends`.`home_animals` (`name`, `id_class`)
VALUES ('Кошки', '1');
INSERT INTO `Human_frends`.`home_animals` (`name`, `id_class`) 
VALUES ('Собаки', '1');
INSERT INTO `Human_frends`.`home_animals` (`name`, `id_class`)
VALUES ('Хомяки', '1');
______________________________________________________________________________________


Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют 
и датами рождения

_____________________________________________________________________________________

CREATE TABLE `Human_frends`.`cats` (
`id_cats` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birthday` DATETIME NULL,
`command` VARCHAR(45) NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_cats`),
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`home_animals` (`id_home_animals`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);


INSERT INTO `Human_frends`.`cats` (`name`, `birthday`, `command`, `id_class`)
VALUES ('Mimi', '2023-5-9', 'тыгыдык', '1');
INSERT INTO `Human_frends`.`cats` (`name`, `birthday`, `command`, `id_class`)
VALUES ('Мурз', '2011-01-01', 'кыш', '1');


CREATE TABLE `Human_frends`.`dogs` (
`id_dogs` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birthday` DATETIME NULL,
`command` VARCHAR(45) NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_dogs`),
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`home_animals` (`id_home_animals`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

INSERT INTO `Human_frends`.`dogs` (`name`, `birthday`, `command`, `id_class`) 
VALUES ('Граф', '2022-01-01', 'голос', '2');
INSERT INTO `Human_frends`.`dogs` (`name`, `birthday`, `command`, `id_class`)
VALUES ('Шарик', '2021-02-02', 'искать', '2');


CREATE TABLE `Human_frends`.`hamsters` (
`id_hamsters` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birthday` DATETIME NULL,
`command` VARCHAR(45) NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_hamsters`),
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`home_animals` (`id_home_animals`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

INSERT INTO `Human_frends`.`hamsters` (`name`, `birthday`, `command`, `id_class`) 
VALUES ('пузырь', '2024-01-01', 'бегать', '3');
INSERT INTO `Human_frends`.`hamsters` (`name`, `birthday`, `command`, `id_class`)
VALUES ('топатун', '2023-12-1', 'притворится мертвым', '3');


CREATE TABLE `Human_frends`.`horses` (
`id_horses` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birthday` DATETIME NULL,
`command` VARCHAR(45) NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_horses`),
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`packed_animals` (`id_packed_animals`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

INSERT INTO `Human_frends`.`horses` (`name`, `birthday`, `command`, `id_class`)
VALUES ('Черныш', '2022-01-01', 'вперед', '1');
INSERT INTO `Human_frends`.`horses` (`name`, `birthday`, `command`, `id_class`) 
VALUES ('Пуля', '2021-12-01', 'галопом', '1');


CREATE TABLE `Human_frends`.`donkey` (
`id_donkey` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birthday` DATETIME NULL,
`command` VARCHAR(45) NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_donkey`),
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`packed_animals` (`id_packed_animals`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

INSERT INTO `Human_frends`.`donkey` (`name`, `birthday`, `command`, `id_class`) 
VALUES ('Иа', '2009-06-01', 'тяни', '2');


CREATE TABLE `Human_frends`.`camels` (
`id_camels` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`birthday` DATETIME NULL,
`command` VARCHAR(45) NULL,
`id_class` INT NULL,
PRIMARY KEY (`id_camels`),
FOREIGN KEY (`id_class`)
REFERENCES `Human_frends`.`packed_animals` (`id_packed_animals`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

INSERT INTO `Human_frends`.`camels` (`name`, `birthday`, `id_class`) 
VALUES ('горбатый', '2019-01-01', '3');
________________________________________________________________________________________
________________________________________________________________________________________

Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
Объединить таблицы лошади, и ослы в одну таблицу.
________________________________________________________________________________________

DROP TABLE `Human_frends`.`camels`;


SELECT Name, Birthday, Command FROM horses
UNION SELECT  Name, Birthday, Command FROM donkey;
________________________________________________________________________________________
________________________________________________________________________________________

Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и 
в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
________________________________________________________________________________________

CREATE TEMPORARY TABLE animals AS
SELECT *, 'Лошади' as genus FROM horses
UNION SELECT *, 'Ослы' AS genus FROM donkey
UNION SELECT *, 'Собаки' AS genus FROM dogs
UNION SELECT *, 'Кошки' AS genus FROM cats
UNION SELECT *, 'Хомяки' AS genus FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

________________________________________________________________________________________

________________________________________________________________________________________
Объединить все таблицы в одну, при этом сохраняя поля, 
указывающие на прошлую принадлежность к старым таблицам.
________________________________________________________________________________________
SELECT h.Name, h.Birthday, h.Command, pa.name, ya.Age_in_month
FROM horses h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN packed_animals pa ON pa.id_packed_animals  = h.id_class
UNION
SELECT d.Name, d.Birthday, d.Command, pa.name, ya.Age_in_month
FROM donkey d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN packed_animals pa ON pa.id_packed_animals  = d.id_class
UNION
SELECT c.Name, c.Birthday, c.Command, ha.name, ya.Age_in_month
FROM cats c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN home_animals ha ON ha.id_home_animals = c.id_class
UNION
SELECT d.Name, d.Birthday, d.Command, ha.name, ya.Age_in_month
FROM dogs d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN home_animals ha ON ha.id_home_animals = d.id_class
UNION
SELECT hm.Name, hm.Birthday, hm.Command, ha.name, ya.Age_in_month
FROM hamsters hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN home_animals ha ON ha.id_home_animals = hm.id_class;

