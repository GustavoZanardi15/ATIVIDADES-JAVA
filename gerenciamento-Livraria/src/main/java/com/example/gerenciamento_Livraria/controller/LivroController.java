package com.example.gerenciamento_Livraria.controller;

import com.example.gerenciamento_Livraria.model.Livro;
import com.example.gerenciamento_Livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarLivroPorId(id);
        return livro != null ? ResponseEntity.ok(livro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvarLivro(livro);
        return ResponseEntity.ok(novoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Livro livro = livroService.atualizarLivro(id, livroAtualizado);
        return livro != null ? ResponseEntity.ok(livro) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
