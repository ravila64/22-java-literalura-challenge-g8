package com.alura.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="libros")
public class Libro {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true)
   private String titulo;

   @ManyToOne
   private Autor autor;
   private String idioma;

   public Libro() {}

   public Libro(DataLibro libroD, List<Autor> listaAutor) {
      this.titulo = libroD.titulo();
      this.idioma = libroD.idiomas().getFirst();   // libroD.idiomas().get(0);
      this.autor = listaAutor.getFirst();  // listaAutor.get(0)
   }
   // getters and setters

   public Autor getAutor() {
      return autor;
   }

   public void setAutor(Autor autor) {
      this.autor = autor;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getIdioma() {
      return idioma;
   }

   public void setIdioma(String idioma) {
      this.idioma = idioma;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   @Override
   public String toString() {
      return "Libro{" +
            "autor=" + autor +
            ", titulo='" + titulo + '\'' +
            ", idioma='" + idioma + '\'' +
            '}';
   }

}
