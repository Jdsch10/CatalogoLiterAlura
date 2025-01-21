# CatalogoLiterAlura

## Descripción del Proyecto

Este proyecto tiene como objetivo crear una aplicación de consola que permita consultar y almacenar libros y autores desde la API de Gutenberg. Los usuarios pueden realizar búsquedas de libros por título, ver información sobre autores, y consultar estadísticas relacionadas con libros y autores almacenados en una base de datos PostgreSQL.

La aplicación utiliza Spring Boot, Spring Data JPA, PostgreSQL y una API externa para obtener los datos.

## Características

- **Consultar libros por título**: Realiza búsquedas de libros por su título y guarda la información relevante, como el autor, idioma y número de descargas.
- **Listar libros por idioma**: Permite consultar y obtener estadísticas sobre la cantidad de libros por idioma almacenados en la base de datos.
- **Consultar autores**: Muestra los autores relacionados con los libros obtenidos, incluyendo su nombre, año de nacimiento y año de fallecimiento.
- **Persistencia en base de datos**: Utiliza PostgreSQL para almacenar libros y autores, manteniendo la relación entre ellos mediante claves foráneas.
- **Consultar autores vivos en un determinado año**: Permite consultar qué autores estaban vivos en un año específico.

## Tecnologías Usadas

- **Spring Boot**: Framework para desarrollar la aplicación.
- **Spring Data JPA**: Para la interacción con la base de datos.
- **PostgreSQL**: Base de datos relacional para almacenar los datos de libros y autores.
- **RestTemplate**: Para hacer peticiones HTTP a la API de Gutenberg.
- **Maven**: Para la gestión de dependencias.

## Requisitos

- JDK 17 o superior
- PostgreSQL instalado
- Maven 3.x o superior

## Instalación

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/tu_usuario/CatalogoLiterAlura.git
   cd CatalogoLiterAlura

2. **Configurar la base de datos PostgreSQL:**

Crear una base de datos llamada catalogo_literatura (o modificar la configuración para usar otra base de datos).
Crear un usuario con acceso a la base de datos.

CREATE DATABASE catalogo_literatura;
CREATE USER tu_usuario WITH ENCRYPTED PASSWORD 'tu_contraseña';
GRANT ALL PRIVILEGES ON DATABASE catalogo_literatura TO tu_usuario;

3. **Configurar la conexión a la base de datos en el archivo application.properties:**

Edita el archivo src/main/resources/application.properties con los datos correctos para tu base de datos.

spring.datasource.url=jdbc:postgresql://localhost:5432/catalogo_literatura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

4. **Instalar dependencias:**

Ejecuta el siguiente comando para instalar las dependencias con Maven:

mvn clean install

## Uso de la Aplicación

1. **Ejecutar la aplicación:**

Una vez que hayas configurado todo, puedes ejecutar la aplicación con el siguiente comando:

mvn spring-boot:run

2. **Interacción con la aplicación:**

La aplicación se ejecuta en la consola y te muestra un menú con las siguientes opciones:

Consultar libro por título: Permite buscar un libro por su título en la API de Gutenberg y almacenar la información en la base de datos.
Ver listado de libros: Muestra todos los libros almacenados en la base de datos.
Consultar libros por idioma: Muestra el número de libros por idioma en la base de datos.
Consultar autores: Muestra la lista de autores de los libros almacenados.
Consultar autores vivos en un año: Permite consultar qué autores estaban vivos en un año específico.
Puedes interactuar con la aplicación ingresando el número correspondiente a cada opción. El sistema recibirá la entrada del usuario, consultará la base de datos y te devolverá los resultados en la consola.

## Archivos de Configuración

application.properties
Configura la conexión con la base de datos PostgreSQL. Asegúrate de tener los datos correctos para tu base de datos:

spring.datasource.url=jdbc:postgresql://localhost:5432/catalogo_literatura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

data.sql
Este archivo contiene los scripts de inicialización para cargar datos de ejemplo en la base de datos al arrancar la aplicación. Si deseas agregar datos adicionales, puedes modificarlos aquí.

INSERT INTO autor (nombre, fecha_nacimiento, fecha_fallecimiento) VALUES ('Miguel de Cervantes', 1547, 1616);

CatalogoLiterAluraApplication.java
Este archivo contiene la clase principal de la aplicación, que inicia Spring Boot y maneja las interacciones del usuario a través de la interfaz CommandLineRunner.

@SpringBootApplication
public class CatalogoLiterAluraApplication implements CommandLineRunner {

    @Autowired
    private ApiGutenbergClient apiGutenbergClient;

    public static void main(String[] args) {
        SpringApplication.run(CatalogoLiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        apiGutenbergClient.consultarLibroPorTitulo("Don Quijote");
    }
}

## Espero disfruten de la app.