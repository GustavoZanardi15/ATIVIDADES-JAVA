package com.example.gerenciamentofuncionarios.service;

import com.example.gerenciamentofuncionarios.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gerenciamentofuncionarios.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario>listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorId(int id){
        return funcionarioRepository.findById(id).get();
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarSalario(int id, double novoSalario) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);

        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = optionalFuncionario.get();
            funcionario.setSalario(novoSalario);
            return funcionarioRepository.save(funcionario);
        } else {
            return null;
        }
    }


    public void deletar(int id){
        funcionarioRepository.deleteById(id);
    }
}
