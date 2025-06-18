package com.alura.literalura.main;

import com.alura.literalura.dto.Datos;
import com.alura.literalura.model.DataLibro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumirAPI;
import com.alura.literalura.service.ConvierteDatos;
//import com.google.gson.JsonArray;
//import javax.xml.crypto.Data;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainLiterAlura {
   private final String URL_BASE = "https://www.gutendex.com/Libros/";
   private final String URL_PAGE = "?page=";
   private final String URL_FIND = "?search=";
   private Scanner teclado = new Scanner(System.in);

   private ConsumirAPI consumirApi = new ConsumirAPI();
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
         switch (opcion) {
            case 1:
               //buscarYGrabarLibroXTitulo();
               break;
            case 2:
               //buscarLibrosPorTitulo();
               break;
            case 3:
               //mostrarLibrosBuscadas();
               break;
            case 4:
               //buscarLibrosPorTitulo();
               break;
            case 5:
               //autoresVivosSegunFechas();
               break;
            case 6:
               listarLibrosPorIdiomas();
               break;
            case 7:
               listadoMasPopulares();
               break;
            case 0:
               System.out.println("Cerrando la aplicación...");
               break;
            default:
               System.out.println("Opción inválida");
         } // end sw

      }
   }

   public void menu(){
      var m= """
            1 - Buscar Libro y grabar libros en la BD
            2 - Buscar libros por titulo
            3 - Buscar libros registrados
            4 - Listar autores registrados
            5 - Listar autores vivos en determinado año
            6 - Listar libros x idioma
            7 - Libros mas populares
            
            0 - Salir
            
            """;
      System.out.println(m);
   }

   public List<DataLibro> getPopularDataLibro() {
      // la API por default trae lo más populares; sin embargo añadimos la query..
      String json = consumirApi.obtenerDatos(URL_BASE + "?sort=popular");
      return (List<DataLibro>) conversor.obtenerDatos(json, Datos.class).results();
   }
   
   public Optional<DataLibro> getDataLibro(String tituloLibro) {
      String json = consumirApi.obtenerDatos(URL_BASE + URL_FIND + tituloLibro.toLowerCase().replace(" ", "+"));
      List<DataLibro> libros = conversor.obtenerDatos(json, Datos.class).results();
      Optional<DataLibro> libro;
      libro = libros.stream()
            .filter(l -> l.titulo().toLowerCase().contains(tituloLibro.toLowerCase()))
            .findFirst();
      return libro;
   }

   // opcion 6
   private void listarLibrosPorIdiomas() {
      System.out.println("Listar libros x idiomas");
   }

   // ocpion 7
   private void listadoMasPopulares() {
      List<DataLibro> listado = getPopularDataLibro();
      listado.forEach(System.out::println);
   }
}
