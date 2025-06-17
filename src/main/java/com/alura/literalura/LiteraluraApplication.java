package com.alura.literalura;

import com.alura.literalura.main.MainLiterAlura;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication {
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	public void run(String... args) throws Exception {
		MainLiterAlura main = new MainLiterAlura(libroRepository,autorRepository);
		main.mostrarMenu();
	}
}
