DROP TABLE IF EXISTS botigues;

CREATE TABLE botigues(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(50),
	capacitat_productes INTEGER);


DROP TABLE IF EXISTS quadres;

CREATE TABLE quadres(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(50),
	fecha DATETIME);
	