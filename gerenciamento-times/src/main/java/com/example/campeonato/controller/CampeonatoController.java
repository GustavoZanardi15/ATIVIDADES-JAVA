package com.example.campeonato.controller;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping
    public List<Campeonato> listarCampeonatos() {
        return campeonatoService.listarCampeonatos();
    }

    @PostMapping
    public Campeonato criarCampeonato(@RequestBody Campeonato campeonato) {
        return campeonatoService.salvarCampeonato(campeonato);
    }

    @PutMapping("/{id}")
    public Campeonato atualizarCampeonato(@PathVariable Long id, @RequestBody Campeonato campeonato) {
        return campeonatoService.atualizarCampeonato(id, campeonato);
    }

    @DeleteMapping("/{id}")
    public void deletarCampeonato(@PathVariable Long id) {
        campeonatoService.deletarCampeonato(id);
    }
}
