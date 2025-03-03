package com.example.campeonato.service;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public List<Campeonato> listarCampeonatos() {
        return campeonatoRepository.findAll();
    }

    public Campeonato salvarCampeonato(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public Campeonato atualizarCampeonato(Long id, Campeonato campeonato) {
        Optional<Campeonato> campeonatoExistente = campeonatoRepository.findById(id);
        if (campeonatoExistente.isPresent()) {
            campeonato.setId(id);
            return campeonatoRepository.save(campeonato);
        } else {
            throw new RuntimeException("Campeonato não encontrado");
        }
    }

    public void deletarCampeonato(Long id) {
        campeonatoRepository.deleteById(id);
    }
}
