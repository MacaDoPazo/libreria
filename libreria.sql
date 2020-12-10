
use db;
insert into localidad (cp,nombre,precio,diasAEntregar) values
(1744,"Moreno",350,5),
(1234,"Springfield",500,8);
insert into autor (apellido,nombre,sexo)values
("King","Stephen","masculino"),
("Schweblin","Samanta","femenino"),
("Sacheri","Eduardo","masculino"),
("Bodoc","Liliana","femenino");

insert into stock (cantidad) values
(5000),
(7000),
(350),
(4500),
(50000),
(800),
(1000);
 
insert into genero
(id,nombre) values(1,'Aventuras'),
(2,'Ciencia Ficción'),
(3,'Policial'),(4,'Terror'),(5,'Romantico'),(6,'Suspenso'),(7,'Humor'),(8,'Poesia');
 
insert into libro(megusta,nombre,paginas,precio,nombre_archivo,autor_id,stock_id,genero_id)values
(300,"Kentukis",400,950,"kentukis.jpg",2,1,5),
(505,"La Torre Oscura",600,800,"la_torre_oscura.jpg",1,2,6),
(500,"It",800,900,"it.jpg",1,3,4),
(650,"La niebla",600,550,"la_niebla.jpg",1,4,4),
(900,"Papeles en el viento",800,500,"papeles_en_el_viento.jpg",3,5,7),
(550,"La pregunta de sus ojos",900,450,"la_pregunta.jpg",3,6,7),
(250,"Amigos por el viento",700,890,"amigos_por_el_viento.jpg",4,7,8); 



INSERT INTO usuario (DTYPE,id,apellido,email,fechaNac,nombre,password,rol,sexo) 
VALUES ('Usuario',1,'Pierotti','npierotti@alumno.unlam.edu.ar','1990-03-21','Nahuel','24b9c03e63a17b45300ada6411ec4b7d178b1c78052a1f9cacce1f75e530f784','Admin','m'),
('Usuario',2,'Do Pazo','maca@123.com','1998-02-15','Macarena','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','Admin','f'),
('Usuario',3,'Tries','ian_tries@hotmail.com','1994-05-14','Ian','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','Admin','m'),
('Usuario',4,'Milito','nahuelpierotti@gmail.com','1980-06-12','Diego Alberto','24b9c03e63a17b45300ada6411ec4b7d178b1c78052a1f9cacce1f75e530f784','Cliente','m'),
('Usuario','5', 'Lopez', 'npierotti@hotmail.com', '1982-12-17', 'Lisandro', '24b9c03e63a17b45300ada6411ec4b7d178b1c78052a1f9cacce1f75e530f784', 'Cliente', 'm');
                                                                               
INSERT INTO resenia(comentario,puntuacion,cliente_id,libro_id) VALUES
("El libro resultó muy interesante",5,3,3),
("El libro no fue lo que esperaba",1,2,3);                                                                                
