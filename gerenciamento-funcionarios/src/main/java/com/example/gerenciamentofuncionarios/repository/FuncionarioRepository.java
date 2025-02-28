package com.example.gerenciamentofuncionarios.repository;

import com.example.gerenciamentofuncionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
