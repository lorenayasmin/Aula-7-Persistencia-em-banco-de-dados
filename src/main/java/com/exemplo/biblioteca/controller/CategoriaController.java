package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Categoria;
import com.exemplo.biblioteca.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodas() {
        List<Categoria> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria novaCategoria) {
        Categoria salva = repository.save(novaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
}
