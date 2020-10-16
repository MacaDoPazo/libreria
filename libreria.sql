
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
 
insert into libro(megusta,nombre,paginas,precio,autor_id,stock_id)values
(300,"Kentukis",400,950,2,1),
(505,"La Torre Oscura",600,800,1,2),
(500,"It",800,900,1,3),
(650,"La niebla",600,550,1,4); 
