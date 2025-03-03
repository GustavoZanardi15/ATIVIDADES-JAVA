package com.example.campeonato.service;

import com.example.campeonato.model.Time;
import com.example.campeonato.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<Time> listarTimes() {
        return timeRepository.findAll();
    }

    public Time salvarTime(Time time) {
        return timeRepository.save(time);
    }

    public Time atualizarTime(Long id, Time time) {
        Optional<Time> timeExistente = timeRepository.findById(id);
        if (timeExistente.isPresent()) {
            time.setId(id);
            return timeRepository.save(time);
        } else {
            throw new RuntimeException("Time não encontrado");
        }
    }

    public void deletarTime(Long id) {
        timeRepository.deleteById(id);
    }
}
