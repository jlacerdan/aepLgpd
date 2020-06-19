package com.aep.lgpd.service;

import org.springframework.stereotype.Service;

import com.aep.lgpd.model.Pergunta;
import com.aep.lgpd.model.vo.PerguntaRespondidaVo;
import com.aep.lgpd.repository.PerguntaRepository;
import com.aep.lgpd.repository.RespostaRepository;

@Service
public class JogoService {

	private PerguntaRepository perguntaRepository;
	private RespostaRepository respostaRepository;

	public Boolean responderPergunta(PerguntaRespondidaVo vo) {
		Pergunta pergunta = perguntaRepository.getOne(vo.getIdPergunta());

		if (pergunta.getTiporesposta().equals("SIMPLES")) {
			return validarRespostaSimples(vo, pergunta);
		}

		if (pergunta.getTiporesposta().equals("MULTIPLA")) {
			return validarRespostasMultiplas(vo, pergunta);
		}

		throw new IllegalStateException("Pergunta inválida.");

	}

	private Boolean validarRespostasMultiplas(PerguntaRespondidaVo vo, Pergunta pergunta) {
		return pergunta.getRespostasCorretas().containsAll(vo.getRespostas()) && vo.getRespostas().size() == pergunta.getRespostasCorretas().size();
	}

	private Boolean validarRespostaSimples(PerguntaRespondidaVo vo, Pergunta pergunta) {
		return vo.getRespostas().get(0).equals(pergunta.getRespostaCorreta());
	}
}
