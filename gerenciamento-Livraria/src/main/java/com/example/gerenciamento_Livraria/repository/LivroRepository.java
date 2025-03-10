package com.example.gerenciamento_Livraria.repository;

import com.example.gerenciamento_Livraria.enums.StatusLivro;
import com.example.gerenciamento_Livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByStatusLivro(StatusLivro statusLivro);
}
