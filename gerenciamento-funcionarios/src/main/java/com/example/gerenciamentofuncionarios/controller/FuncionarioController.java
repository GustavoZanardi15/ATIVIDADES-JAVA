package com.example.gerenciamentofuncionarios.controller;


import com.example.gerenciamentofuncionarios.dto.SalarioDTO;
import com.example.gerenciamentofuncionarios.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gerenciamentofuncionarios.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable int id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        Funcionario savedFuncionario = funcionarioService.salvar(funcionario);
        return ResponseEntity.status(201).body(savedFuncionario);
    }

     @PutMapping("/{id}/salario")
    public ResponseEntity<Funcionario> atualizarSalario(@PathVariable int id, @RequestBody SalarioDTO salarioDTO) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizarSalario(id, salarioDTO.getNovoSalario());

        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok(funcionarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

