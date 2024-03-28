-- ================================================================================================================
-- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
-- Заполнить таблицы данными о животных, их командах и датами рождения.
-- ================================================================================================================


CREATE SCHEMA IF NOT EXISTS `Human_Friends`;
USE `Human_Friends`;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Cats;
DROP TABLE IF EXISTS Dogs;
DROP TABLE IF EXISTS Hamsters;
DROP TABLE IF EXISTS Horses;
DROP TABLE IF EXISTS Camels;
DROP TABLE IF EXISTS Donkeys;
DROP TABLE IF EXISTS Commands;
DROP TABLE IF EXISTS Cats_Commands;
DROP TABLE IF EXISTS Dogs_Commands;
DROP TABLE IF EXISTS Hamsters_Commands;
DROP TABLE IF EXISTS Horses_Commands;
DROP TABLE IF EXISTS Camels_Commands;
DROP TABLE IF EXISTS Donkeys_Commands;
SET foreign_key_checks = 1;

CREATE TABLE Cats  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    BirthDate DATE
);

CREATE TABLE Dogs  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    BirthDate DATE
);

CREATE TABLE Hamsters  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    BirthDate DATE
);

INSERT INTO Cats (Name, BirthDate) VALUES 
	('Whiskers', '2019-05-15'),
    ('Smudge', '2020-02-20'),
	('Oliver', '2023-06-30');

INSERT INTO Dogs (Name, BirthDate) VALUES 
	('Fido', '2020-01-01'),
	('Buddy','2023-12-10'),
	('Bella', '2019-11-11');

INSERT INTO Hamsters (Name, BirthDate) VALUES 
	('Hammy', '2023-03-10'),
	('Peanut', '2023-09-01');

CREATE TABLE Horses  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    BirthDate DATE
);

CREATE TABLE Camels  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    BirthDate DATE
);

CREATE TABLE Donkeys  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    BirthDate DATE
);

INSERT INTO Horses (Name, BirthDate) VALUES 
	('Thunder', '2021-07-05'),
	('Storm', '2019-05-12'),
	('Blaze', '2018-02-25');

INSERT INTO Camels (Name, BirthDate) VALUES
	('Sandy', '2020-11-03'),
	('Dune', '2023-12-12'),
	('Sahara', '2015-08-14');
    
INSERT INTO Donkeys (Name, BirthDate) VALUES
	('Eeyore', '2023-09-18'),
	('Burro', '2022-01-23');


CREATE TABLE Commands  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Command VARCHAR(30)
);

INSERT INTO Commands (Command) VALUES 
    ('Sit'), -- 1
    ('Stay'), -- 2
    ('Fetch'),  -- 3
    ('Pounce'), -- 4
    ('Roll'), -- 5
    ('Hide'), -- 6
    ('Paw'), -- 6
    ('Bark'), -- 8
    ('Scratch'), -- 9
    ('Spin'), -- 10
    ('Trot'),  -- 11
    ('Canter'), --  12
    ('Gallop'),  -- 13
    ('Carry Load'), -- 14
    ('Walk'),  -- 15
    ('Bray'),  -- 16
    ('Kick'),  -- 17
    ('Jump'),  -- 18
    ('Run'), -- 19
    ('Meow');

CREATE TABLE Cats_Commands (    -- вспомогательная таблица для связи животных и команд
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Cat INT,
    ID_Command INT,
    CONSTRAINT Cats_fk
    FOREIGN KEY (ID_Cat)  REFERENCES Cats (ID),
    CONSTRAINT Cats_Commands_fk
    FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);

CREATE TABLE Dogs_Commands (    -- вспомогательная таблица для связи животных и команд
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Dog INT,
    ID_Command INT,
    CONSTRAINT Dogs_fk
    FOREIGN KEY (ID_Dog)  REFERENCES Dogs (ID),
    CONSTRAINT Dogs_Commands_fk
    FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);

CREATE TABLE Hamsters_Commands (    -- вспомогательная таблица для связи животных и команд
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Hamster INT,
    ID_Command INT,
    CONSTRAINT Hamsters_fk
    FOREIGN KEY (ID_Hamster)  REFERENCES Hamsters (ID),
    CONSTRAINT Hamsters_Commands_fk
    FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);
    


INSERT INTO Cats_Commands (ID_Cat, ID_Command) VALUES
    (1, 1), (1, 4),
    (2, 1), (2, 6), (2, 9),
    (3, 20), (3, 9), (3, 18);

INSERT INTO Dogs_Commands (ID_Dog, ID_Command) VALUES
    (1, 11), (1, 12), (1, 13),
    (2, 11), (2, 12),
    (3, 11), (3, 18), (3, 13);

INSERT INTO Hamsters_Commands (ID_Hamster, ID_Command) VALUES
    (1, 15), (1, 14), (1, 16),
    (2, 15), (2, 16), (2, 17);


CREATE TABLE Horses_Commands (    -- вспомогательная таблица для связи животных и команд
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Horse INT,
    ID_Command INT,
    CONSTRAINT Horses_fk
    FOREIGN KEY (ID_Horse)  REFERENCES Horses (ID),
    CONSTRAINT Horses_Commands_fk
    FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);

CREATE TABLE Camels_Commands (    -- вспомогательная таблица для связи животных и команд
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Camel INT,
    ID_Command INT,
    CONSTRAINT Camels_fk
    FOREIGN KEY (ID_Camel)  REFERENCES Camels (ID),
    CONSTRAINT Camels_Commands_fk
    FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);

CREATE TABLE Donkeys_Commands (    -- вспомогательная таблица для связи животных и команд
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Donkey INT,
    ID_Command INT,
    CONSTRAINT Donkeys_fk
    FOREIGN KEY (ID_Donkey)  REFERENCES Donkeys (ID),
    CONSTRAINT Donkeys_Commands_fk
    FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);

INSERT INTO Horses_Commands (ID_Horse, ID_Command) VALUES
    (1, 11), (1, 12), (1, 13),
    (2, 11), (2, 12),
    (3, 11), (2, 18), (3, 13);

INSERT INTO Donkeys_Commands (ID_Donkey, ID_Command) VALUES
    (1, 15), (1, 14), (1, 16),
    (2, 15), (2, 16), (2, 17);
    
INSERT INTO Camels_Commands (ID_Camel, ID_Command) VALUES
    (1, 15), (1, 14),
    (2, 15), (2, 1),
    (3, 15), (3, 19);





-- ================================================================================================================
 -- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
-- ================================================================================================================
SET foreign_key_checks = 0;
-- TRUNCATE TABLE Camels;   -- закомментировано  что бы в следующих таблицах были  верблюды
SET foreign_key_checks = 1;
SELECT * FROM Camels;

SELECT *, "Horse" AS "Type" FROM Horses 
    JOIN Horses_Commands ON Horses_Commands.ID_Horse = Horses.ID
    JOIN Commands ON Horses_Commands.ID = Commands.ID
UNION
SELECT *, "Donkey" AS "Type" FROM Donkeys
    JOIN Donkeys_Commands ON Donkeys_Commands.ID_Donkey = Donkeys.ID
    JOIN Commands ON Donkeys_Commands.ID = Commands.ID;




-- ================================================================================================================
-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
-- ================================================================================================================

SET @cur_date := CURDATE();
DROP FUNCTION IF EXISTS convet_date_to_age;
DELIMITER //
CREATE FUNCTION convet_date_to_age (data_animal DATE) RETURNS varchar(100)
    DETERMINISTIC
    BEGIN
		DECLARE cur_date Date;
        DECLARE year_age_animal INT;
        DECLARE month_age_animal INT;
        DECLARE days INT;
		SET cur_date = CURDATE();
        SET days = DATEDIFF(cur_date, data_animal) ;
        
        IF (days  <= 0) THEN
			RETURN "data wrong";
        END IF;

        SET year_age_animal = days DIV 365;
        SET month_age_animal  =  ROUND((days / 365 - year_age_animal) * 12);
        RETURN concat(year_age_animal, " years ",  month_age_animal, ' month');
    END //
DELIMITER ;



SELECT *, convet_date_to_age(BirthDate) AS 'Age', "Horse" AS "Type" FROM Horses 
	JOIN Horses_Commands ON Horses_Commands.ID_Horse = Horses.ID
	JOIN Commands ON Horses_Commands.ID = Commands.ID
	WHERE DATEDIFF(@cur_date, BirthDate)/365 < 3  AND DATEDIFF(@cur_date, BirthDate)/365 > 1
UNION
SELECT *, convet_date_to_age(BirthDate) AS 'Age', "Donkey" AS "Type" FROM Donkeys 
	JOIN Donkeys_Commands ON Donkeys_Commands.ID_Donkey = Donkeys.ID
	JOIN Commands ON Donkeys_Commands.ID = Commands.ID
	WHERE DATEDIFF(@cur_date, BirthDate)/365 < 3  AND DATEDIFF(@cur_date, BirthDate)/365 > 1
UNION
SELECT *, convet_date_to_age(BirthDate) AS 'Age', "Cat" AS "Type" FROM Cats 
	JOIN Cats_Commands ON Cats_Commands.ID_Cat  = Cats.ID
	JOIN Commands ON Cats_Commands.ID = Commands.ID
	WHERE DATEDIFF(@cur_date, BirthDate)/365 < 3  AND DATEDIFF(@cur_date, BirthDate)/365 > 1
UNION
SELECT *, convet_date_to_age(BirthDate) AS 'Age',  "Dog" AS "Type" FROM Dogs 
	JOIN Dogs_Commands ON Dogs_Commands.ID_Dog  = Dogs.ID
	JOIN Commands ON Dogs_Commands.ID = Commands.ID
	WHERE DATEDIFF(@cur_date, BirthDate)/365 < 3  AND DATEDIFF(@cur_date, BirthDate)/365 > 1
UNION
SELECT *, convet_date_to_age(BirthDate) AS 'Age', "Hamster" AS "Type" FROM Hamsters 
	JOIN Hamsters_Commands ON Hamsters_Commands.ID_Hamster  = Hamsters.ID
	JOIN Commands ON Hamsters_Commands.ID = Commands.ID
	WHERE DATEDIFF(@cur_date, BirthDate)/365 < 3  AND DATEDIFF(@cur_date, BirthDate)/365 > 1
UNION
SELECT *, convet_date_to_age(BirthDate) AS 'Age', "Camel" AS "Type" FROM Camels 
	JOIN Camels_Commands ON Camels_Commands.ID_Camel  = Camels.ID
	JOIN Commands ON Camels_Commands.ID = Commands.ID
	WHERE DATEDIFF(@cur_date, BirthDate)/365 < 3  AND DATEDIFF(@cur_date, BirthDate)/365 > 1;


-- ================================================================================================================
-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
-- ================================================================================================================

SELECT *, "Horse" AS "Type" FROM Horses 
	JOIN Horses_Commands ON Horses_Commands.ID_Horse = Horses.ID
	JOIN Commands ON Horses_Commands.ID = Commands.ID
UNION
SELECT *, "Donkey" AS "Type" FROM Donkeys 
	JOIN Donkeys_Commands ON Donkeys_Commands.ID_Donkey = Donkeys.ID
	JOIN Commands ON Donkeys_Commands.ID = Commands.ID
UNION
SELECT *, "Cat" AS "Type" FROM Cats 
	JOIN Cats_Commands ON Cats_Commands.ID_Cat  = Cats.ID
	JOIN Commands ON Cats_Commands.ID = Commands.ID
UNION
SELECT *,  "Dog" AS "Type" FROM Dogs 
	JOIN Dogs_Commands ON Dogs_Commands.ID_Dog  = Dogs.ID
	JOIN Commands ON Dogs_Commands.ID = Commands.ID
UNION
SELECT *, "Hamster" AS "Type" FROM Hamsters 
	JOIN Hamsters_Commands ON Hamsters_Commands.ID_Hamster  = Hamsters.ID
	JOIN Commands ON Hamsters_Commands.ID = Commands.ID
UNION
SELECT *, "Camel" AS "Type" FROM Camels 
	JOIN Camels_Commands ON Camels_Commands.ID_Camel  = Camels.ID
	JOIN Commands ON Camels_Commands.ID = Commands.ID;


