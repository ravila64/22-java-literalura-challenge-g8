package com.alura.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="autores")
public class Autor {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private Integer year_born;
   private Integer year_dead;
   @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Libro> libros;

   public Autor() {}

   public Autor(DataAutor autorD) {
      this.nombre = autorD.nombre();
      this.year_born = autorD.year_born();
      this.year_dead = autorD.year_dead();
   }
   // getters and setters


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setLibros(List<Libro> libros) {
      this.libros = libros;
   }

   public String getNombre_autor() {
      return nombre;
   }

   public void setNombre_autor(String nombre_autor) {
      this.nombre = nombre;
   }

   public Integer getYear_born() {
      return year_born;
   }

   public void setYear_born(Integer year_born) {
      this.year_born = year_born;
   }

   public Integer getYear_dead() {
      return year_dead;
   }

   public void setYear_dead(Integer year_dead) {
      this.year_dead = year_dead;
   }

   public List<Libro> getLibros() {
      return libros;
   }

   public void setBooks(List<Libro> books) {
      this.libros = libros;
   }

   @Override
   public String toString() {
      return "Autor{" +
            ", nombre='" + nombre + '\'' +
            ", yearBorn=" + year_born +
            ", yearDead=" + year_dead +
            ", libros=" + libros +
            '}';
   }
}
