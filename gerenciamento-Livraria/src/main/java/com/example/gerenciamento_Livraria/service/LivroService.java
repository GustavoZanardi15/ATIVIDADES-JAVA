package com.example.gerenciamento_Livraria.service;

import com.example.gerenciamento_Livraria.enums.StatusLivro;
import com.example.gerenciamento_Livraria.model.Livro;
import com.example.gerenciamento_Livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setStatusLivro(livroAtualizado.getStatusLivro());
            return livroRepository.save(livro);
        }).orElse(null);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> buscarPorStatus(StatusLivro status) {
        return livroRepository.findByStatusLivro(status);
    }

    public Livro alterarStatus(Long id, StatusLivro novoStatus) {
        return livroRepository.findById(id).map(livro -> {
            livro.setStatusLivro(novoStatus);
            return livroRepository.save(livro);
        }).orElse(null);
    }
}
