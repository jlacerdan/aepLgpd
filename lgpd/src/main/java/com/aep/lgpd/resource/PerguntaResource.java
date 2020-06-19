package com.aep.lgpd.resource;

import com.aep.lgpd.model.Pergunta;
import com.aep.lgpd.service.PerguntaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaResource {

    private final Logger log = LoggerFactory.getLogger(PerguntaResource.class);

    private PerguntaService perguntaService;

    public PerguntaResource(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping
    public ResponseEntity<List<Pergunta>> getPerguntas() {
        return ResponseEntity.ok(perguntaService.buscarTodasPerguntas());
    }

    @GetMapping("/pergunta/{id}")
    public ResponseEntity<Pergunta> getPergunta(@PathVariable Long id) {
        return ResponseEntity.ok(perguntaService.buscarPergunta(id));
    }

    @PostMapping("/pergunta")
    public ResponseEntity<Pergunta> createPergunta(@RequestBody Pergunta pergunta) {
        log.info("Request to create pergunta: {}", pergunta);
        Pergunta perguntaCriada = perguntaService.criarPergunta(pergunta);
        return ResponseEntity.ok(perguntaCriada);
    }

    @PutMapping("/pergunta")
    ResponseEntity<Pergunta> updatePergunta(@RequestBody Pergunta pergunta) {
        log.info("Request to update group: {}", pergunta);
        Pergunta resultado = perguntaService.editarPergunta(pergunta);
        return ResponseEntity.ok().body(resultado);
    }

    @DeleteMapping("/pergunta/remover/{id}")
    public ResponseEntity<?> deletePergunta(@PathVariable Long id) {
        perguntaService.deletarPergunta(id);
        return ResponseEntity.ok().build();
    }


}
