package com.example.campeonato.service;

import com.example.campeonato.model.Participacao;
import com.example.campeonato.repository.ParticipacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipacaoService {

    @Autowired
    private ParticipacaoRepository participacaoRepository;

    public List<Participacao> listarParticipacoes() {
        return participacaoRepository.findAll();
    }

    public Participacao salvarParticipacao(Participacao participacao) {
        return participacaoRepository.save(participacao);
    }
}
