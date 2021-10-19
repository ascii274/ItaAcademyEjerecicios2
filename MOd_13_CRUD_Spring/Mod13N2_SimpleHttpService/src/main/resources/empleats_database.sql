CREATE TABLE `empleats_database`.`empleats` ( `id` INT(5) NOT NULL AUTO_INCREMENT , 
`nom` VARCHAR(50) NOT NULL , 
`faena` VARCHAR(50) NOT NULL , 
PRIMARY KEY (`id`)) ENGINE = InnoDB; 



INSERT INTO `empleats` (`nom`, `faena`) VALUES 
	('Pedro', 'Cloud_System_Engineer'), 
	('Eva', 'Data_Scientist'), 
	('Oscar', 'Database_Administrator'), 
	('Laura', 'IT_Director'), 
	('Juan', 'IT_Technician'), 
	('Alex', 'QA_Tester'), 
	('Rubén', 'Software_Engineer'), 
	('Vanesa', 'Support_Specialist'), 
	('Marta', 'UX_Designer'), 
	('Carlos', 'Web_Administrator'), 
	('Ana', 'Web_Developer'); 
	

	
CREATE TABLE `empleats_database`.`usuarios` 
( `id` INT NOT NULL AUTO_INCREMENT , `usuario` VARCHAR(30) NOT NULL , `password` VARCHAR(30) NOT NULL , 
PRIMARY KEY (`id`)) ENGINE = InnoDB; 


INSERT INTO `usuarios` (`id`, `usuario`, `password`) VALUES
 ('1', 'admin', '123'), 
 ('2', 'user', '123') ;