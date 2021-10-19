CREATE TABLE `empleats_database`.`empleats` ( `id` INT(5) NOT NULL AUTO_INCREMENT , 
`nom` VARCHAR(50) NOT NULL , 
`faena` VARCHAR(50) NOT NULL ,
`salari` INT(10) NOT NULL, 
PRIMARY KEY (`id`)) ENGINE = InnoDB; 



INSERT INTO `empleats` (`nom`, `faena`,`salari`) VALUES 
	('Pedro', 'Cloud_System_Engineer',55000), 
	('Eva', 'Data_Scientist',47000), 
	('Oscar', 'Database_Administrator',40000), 
	('Laura', 'IT_Director',67000), 
	('Juan', 'IT_Technician',36000), 
	('Alex', 'QA_Tester',30000), 
	('Rubén', 'Software_Engineer',45000), 
	('Vanesa', 'Support_Specialist',35000), 
	('Marta', 'UX_Designer',31000), 
	('Carlos', 'Web_Administrator',32000), 
	('Ana', 'Web_Developer',55000); 
	

	
CREATE TABLE `empleats_database`.`usuarios` 
( `id` INT NOT NULL AUTO_INCREMENT , `usuario` VARCHAR(30) NOT NULL , `password` VARCHAR(30) NOT NULL , 
PRIMARY KEY (`id`)) ENGINE = InnoDB; 


INSERT INTO `usuarios` (`id`, `usuario`, `password`) VALUES
 ('1', 'admin', '123'), 
 ('2', 'user', '123') ;