package com.alura.literalura.main;

import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class MainLiterAlura {
   private final String URL_BASE = "https://www.gutendex.com/Libros/";
   private final String URL_PAGE = "?page=";
   private final String URL_FIND = "?search=";
   private Scanner teclado = new Scanner(System.in);

   private ConsumoAPI consumoApi = new ConsumoAPI();
   //private ConsumoRespuesta consumoRespuesta = new ConsumoRespuesta();
   private ConvierteDatos conversor = new ConvierteDatos();
   //   private List<DatosLibro> datosLibros = new ArrayList<>();
   private LibroRepository repositorioLib;
   private AutorRepository repositorioAut;



}
