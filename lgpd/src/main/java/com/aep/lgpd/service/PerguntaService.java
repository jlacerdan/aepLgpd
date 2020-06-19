package com.aep.lgpd.service;

import com.aep.lgpd.model.Pergunta;
import com.aep.lgpd.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {

    private PerguntaRepository perguntaRepository;

    @Autowired
    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public List<Pergunta> buscarTodasPerguntas() {
        return perguntaRepository.findAll();
    }

    public Pergunta criarPergunta(Pergunta pergunta) {
    	return perguntaRepository.save(pergunta);
    }

    public Pergunta buscarPergunta(Long id) {
        return perguntaRepository.getOne(id);
    }

    public void deletarPergunta(Long id) {
        Pergunta perguntaDeletar = perguntaRepository.getOne(id);
        perguntaRepository.delete(perguntaDeletar);
    }

	public Pergunta editarPergunta(Pergunta pergunta) {
		return perguntaRepository.save(pergunta);
	}
}
