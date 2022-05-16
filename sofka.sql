use sofka;
create table nivel
(
id_nivel int auto_increment primary key,
nivel int,
premio int
);

create table pregunta
(
id_pregunta int auto_increment primary key,
pregunta varchar (50),
 id_nivel int not null, foreign key(id_nivel) references nivel (id_nivel)
);

create table respuesta
(
id_respuesta int auto_increment primary key,
respuesta varchar (50),
estado int,
id_pregunta int not null, foreign key(id_pregunta) references pregunta(id_pregunta)
);

create table historico_juego
(
id_historico int auto_increment primary key,
respuestas_correctas int,
premio_obtenido int,
usuario varchar(50)
);