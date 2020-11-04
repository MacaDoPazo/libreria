
use db;
insert into localidad (cp,nombre,precio) values
(1744,"Moreno",350),
(1234,"Springfield",500);
insert into autor (apellido,nombre,sexo)values
("King","Stephen","masculino"),
("Schweblin","Samanta","femenino");

insert into stock (cantidad) values
(5000),
(7000),
(350),
(4500);
 
insert into genero
(id,nombre) values(1,'Aventuras'),
(2,'Ciencia Ficción'),
(3,'Policial'),(4,'Terror'),(5,'Romantico'),(6,'Suspenso'),(7,'Humor'),(8,'Poesia');
 
insert into libro(megusta,nombre,paginas,precio,nombre_archivo,autor_id,stock_id,genero_id)values
(300,"Kentukis",400,950,"kentukis.jpg",2,1,5),
(505,"La Torre Oscura",600,800,"la_torre_oscura.jpg",1,2,6),
(500,"It",800,900,"it.jpg",1,3,4),
(650,"La niebla",600,550,"la_niebla.jpg",1,4,4); 

