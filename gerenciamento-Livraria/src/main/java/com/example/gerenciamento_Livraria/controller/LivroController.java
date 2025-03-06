package com.example.gerenciamento_Livraria.controller;

import com.example.gerenciamento_Livraria.model.Livro;
import com.example.gerenciamento_Livraria.repository.LivroRepository;
import com.example.gerenciamento_Livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> ListarLivros() {
        return livroRepository.findAll();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Livro> BuscarLivroPorId(@PathVariable Long Id) {
        Livro livro = LivroService.BuscarLivroPorId(Id);
        return livro != null ? ResponseEntity.ok(livro) :; ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.SalvarLivro(livro);
        return ResponseEntity.ok(novoLivro);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Livro livro = livroService.atualizarLivro(id, livroAtualizado);
        return livro != null ? ResponseEntity.ok(livro) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.DeletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
}


