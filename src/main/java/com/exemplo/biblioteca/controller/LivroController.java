package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> buscarTodos() {
        List<Livro> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro novoLivro) {
        Livro salvo = repository.save(novoLivro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
