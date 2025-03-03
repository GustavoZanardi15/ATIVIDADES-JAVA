package com.example.campeonato.controller;

import com.example.campeonato.model.Time;
import com.example.campeonato.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<Time> listarTimes() {
        return timeService.listarTimes();
    }

    @PostMapping
    public Time criarTime(@RequestBody Time time) {
        return timeService.salvarTime(time);
    }

    @PutMapping("/{id}")
    public Time atualizarTime(@PathVariable Long id, @RequestBody Time time) {
        return timeService.atualizarTime(id, time);
    }

    @DeleteMapping("/{id}")
    public void deletarTime(@PathVariable Long id) {
        timeService.deletarTime(id);
    }
}
