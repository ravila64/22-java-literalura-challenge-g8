package com.alura.literalura.main;

import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumirAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class MainLiterAlura {
   private final String URL_BASE = "https://www.gutendex.com/Libros/";
   private final String URL_PAGE = "?page=";
   private final String URL_FIND = "?search=";
   private Scanner teclado = new Scanner(System.in);

   private ConsumirAPI consumoApi = new ConsumirAPI();
   private ConvierteDatos conversor = new ConvierteDatos();
   private LibroRepository libroRepository;
   private AutorRepository autorRepository;

   public MainLiterAlura(LibroRepository libroRepository, AutorRepository autorRepository) {
      this.libroRepository = libroRepository;
      this.autorRepository = autorRepository;
   }

   private int opcion = -1;

   public void mostrarMenu() {
      while (opcion != 0) {
         menu();
         

      }
   }

   public void menu(){
      var m= """
            1 - Buscar Libro y grabar libros en la BD
            2 - Buscar libros por titulo
            3 - Buscar libros registrados
            4 - Listar autores registrados
            5 - Listar autores vivos en determinado año
            6 - Listar libros x idiomaEnum
            
            0 - Salir
            
            """;
      System.out.println(m);
   }

}
