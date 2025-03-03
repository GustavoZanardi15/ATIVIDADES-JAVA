package com.example.campeonato.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("campeonato")
    private Set<Participacao> participacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Set<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(Set<Participacao> participacoes) {
        this.participacoes = participacoes;
    }
}
