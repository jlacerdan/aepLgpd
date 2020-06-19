package com.aep.lgpd;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aep.lgpd.model.Pergunta;
import com.aep.lgpd.repository.PerguntaRepository;

@Component
class Initializer implements CommandLineRunner {

    private final PerguntaRepository repository;

    public Initializer(PerguntaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Teste", "Teste2",
                "Teste4").forEach(pergunta ->
                repository.save(new Pergunta(pergunta))
        );
        
        List<Pergunta> teste = repository.findAll(); 
        repository.findAll().forEach(System.out::println);
    }
}