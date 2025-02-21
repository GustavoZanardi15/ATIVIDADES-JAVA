package com.livraria.controller;

import com.livraria.model.Livro;
import com.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {


    @Autowired
    private LivroRepository  livroRepository;


    @PostMapping
    public String cadastrarLivro(@RequestBody Livro livro) {
        return "Livro cadastrado com sucesso!";
    }


    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }


//    @GetMapping("/{id}")
//    public Livro buscarLivro(@PathVariable Long id) {
//        Optional<Livro> livro = livros.stream().filter(l -> l.getId().equals(id)).findFirst();
//        return livro.orElse(null);
//    }
//
//
//    @PutMapping("/{id}")
//    public String atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
//        Optional<Livro> livro = livros.stream().filter(l -> l.getId().equals(id)).findFirst();
//
//        if (livro.isPresent()) {
//            Livro l = livro.get();
//            l.setTitulo(livroAtualizado.getTitulo());
//            l.setAutor(livroAtualizado.getAutor());
//            return "Livro atualizado com sucesso!";
//        } else {
//            return "Livro não encontrado!";
//        }
//    }
//
//
//    @DeleteMapping("/{id}")
//    public String excluirLivro(@PathVariable Long id) {
//        Optional<Livro> livro = livros.stream().filter(l -> l.getId().equals(id)).findFirst();
//
//        if (livro.isPresent()) {
//            livros.remove(livro.get());
//            return "Livro excluído com sucesso!";
//        } else {
//            return "Livro não encontrado!";
//        }
//    }
}
