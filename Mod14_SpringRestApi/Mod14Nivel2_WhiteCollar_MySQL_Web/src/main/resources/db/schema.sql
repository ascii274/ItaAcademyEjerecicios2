DROP TABLE IF EXISTS quadres;

CREATE TABLE quadres(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(50),
	fecha_entrada DATETIME,
	botiga_id INTEGER	
	);

DROP TABLE IF EXISTS botigues;

CREATE TABLE botigues(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(50),
	capacitat_productes INTEGER);





ALTER TABLE quadres
ADD FOREIGN KEY (botiga_id) REFERENCES botigues(id);
	