package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
   List<Autor> findByNombreContainsIgnoreCase(String nombreAutor);

   @Query(value = "SELECT a FROM Autor a WHERE a.yearBorn >= :year AND a.yearDead <= :year")
   List<Autor> filtraAutoresSegunFechas(int year);

}
