package com.aep.lgpd.resource;

import com.aep.lgpd.model.vo.PerguntaRespondidaVo;
import com.aep.lgpd.service.JogoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogo")
public class JogoResource {
    private final Logger log = LoggerFactory.getLogger(PerguntaResource.class);

    private JogoService jogoService;

    @Autowired
    public JogoResource(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping("/resposta")
    public ResponseEntity<Boolean> responderPergunta(PerguntaRespondidaVo vo) {
        return ResponseEntity.ok(jogoService.responderPergunta(vo));
    }
}
