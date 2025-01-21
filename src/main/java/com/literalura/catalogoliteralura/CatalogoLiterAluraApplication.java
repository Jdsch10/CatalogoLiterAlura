package com.literalura.catalogoliteralura;

import com.literalura.catalogoliteralura.models.Libro;
import com.literalura.catalogoliteralura.models.Autor;
import com.literalura.catalogoliteralura.services.LibroService;
import com.literalura.catalogoliteralura.services.AutorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class CatalogoLiterAluraApplication implements CommandLineRunner {

    private final LibroService libroService;
    private final AutorService autorService;

    public CatalogoLiterAluraApplication(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CatalogoLiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores vivos en un año");
            System.out.println("0. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String title = scanner.nextLine();
                    libroService.buscarLibroPorTitulo(title);
                    break;
                case 2:
                    libroService.listarLibros();
                    break;
                case 3:
                    autorService.listarAutores();
                    break;
                case 4:
                    System.out.println("Ingrese el año:");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    autorService.listarAutoresVivos(year);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
        scanner.close();
    }

    @Bean
    public CommandLineRunner demo(LibroService libroService, AutorService autorService) {
        return (args) -> {
            // Inicializar datos de ejemplo para probar
            Autor autor1 = new Autor("Jane Austen", 1775, 1817);
            Autor autor2 = new Autor("Charles Dickens", 1812, 1870);

            autorService.guardarAutor(autor1);
            autorService.guardarAutor(autor2);

            Libro libro1 = new Libro("Pride and Prejudice", autor1, "Inglés", 1000000);
            Libro libro2 = new Libro("Oliver Twist", autor2, "Inglés", 500000);

            libroService.guardarLibro(libro1);
            libroService.guardarLibro(libro2);

            System.out.println("Datos inicializados: ");
            libroService.listarLibros();
            autorService.listarAutores();
        };
    }
}