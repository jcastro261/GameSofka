# GameSofka

### Herramientas utilizadas
Este proyecto se desarrolló utilizando las siguientes herramientas
* [Java JDK 11](https://www.oracle.com/co/java/technologies/javase-jdk11-downloads.html) - Lenguaje de programación
* [GitHub](https://github.com/) - Repositorio de código fuente
* [Spring Tool Suite 4](https://spring.io/tools) - IDE de desarrollo
* [MySQL](https://www.mysql.com/) - Motor de base de datos relacional

### frameworks y librerias
Este proyecto utiliza los siguientes frameworks y librerias relevantes
* [Spring](https://spring.io/) - Framework de desarrollo Spring
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Persistencia

_descargar el proyecto desde GitHub_
```
https://github.com/jcastro261/GameSofka.git
```
Se recomienda utilizar un IDE para importar el proyecto. Para el caso de Spring Tool Suite

### Ejecucion
El proyecto requiere una base de datos MySQL 

## Jugar
* al iniciar el juego se desplega una ventana de JOpane (java) en la cual salen las opciones requeridas para la creacion de las preguntas por el usuario, dichas preguntas
con su respectivas respuestas seran almacenadas por medio de un metodo en la basa de datos, las respuesta con la ayuda de la interface JOpane nos pregunta cual es la respuesta
correcta de dicha pregunta.
* Cada pregunta sera almacenada por el nivel que indique el usuario
*Cuando ya se realizo el guardado de las preguntas, tenemos la opcion jugar, en la cual te registras con tu nombre y te empieza a salir la ronda de preguntas por cada nivel,
