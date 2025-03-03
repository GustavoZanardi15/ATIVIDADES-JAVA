package com.example.campeonato.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("time")
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

    public Set<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(Set<Participacao> participacoes) {
        this.participacoes = participacoes;
    }
}