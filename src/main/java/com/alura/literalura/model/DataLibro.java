package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataLibro(
      @JsonAlias("title") String titulo,
      @JsonAlias("authors") List<Autor> autores,
      @JsonAlias("languages") List<String> idiomas
) {
}
