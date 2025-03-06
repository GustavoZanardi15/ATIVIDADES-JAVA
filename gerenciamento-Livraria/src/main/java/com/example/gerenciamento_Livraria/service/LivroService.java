package com.example.gerenciamento_Livraria.service;

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

    public List<Livro> ListarLivros() {
        return livroRepository.findAll();
    }

    public Livro BuscarLivroPorID(Long id) {
        return livroRepository.findById(id).get();
    }

    public Livro SalvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();
            livro.setTitulo(livroAtualizado.getTitulo());

            return livroRepository.save(livro);
        } else {
            return null;
        }
    }

    public void DeletarLivro(Long id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (optionalLivro.isPresent()) {
            livroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
    }

}

