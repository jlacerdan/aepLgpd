package com.aep.lgpd.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.aep.lgpd.model.Pergunta;
import com.aep.lgpd.model.Resposta;
import com.aep.lgpd.model.vo.PerguntaRespondidaVo;
import com.aep.lgpd.repository.PerguntaRepository;


public class JogoServiceTest {
	
	@InjectMocks
	private JogoService jogoService;
	
	@Mock
	private PerguntaRepository perguntaRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testarResponderCorretamente() {
		Mockito.when(perguntaRepository.getOne(Mockito.anyLong())).thenReturn(getPerguntaSimples());
		
		Assert.assertThat(jogoService.responderPergunta(getResponderPerguntaSimplesCorretaVo()), Matchers.is(true));
	}
	
	@Test
	public void testarResponderPerguntaSimplesErrado() {
		Mockito.when(perguntaRepository.getOne(Mockito.anyLong())).thenReturn(getPerguntaSimples());
		
		Assert.assertThat(jogoService.responderPergunta(getResponderPerguntaSimplesErradaVo()), Matchers.is(false));
	}
	
	@Test
	public void testarResponderPerguntaMultiplaCorreta() {
		Mockito.when(perguntaRepository.getOne(Mockito.anyLong())).thenReturn(getPerguntaMultipla());
		
		Assert.assertThat(jogoService.responderPergunta(getResponderPerguntaMultiplaCorretaVo()), Matchers.is(true));
	}
	
	@Test
	public void testarResponderPerguntaMultiplaErrada() {
		Mockito.when(perguntaRepository.getOne(Mockito.anyLong())).thenReturn(getPerguntaMultipla());
		
		Assert.assertThat(jogoService.responderPergunta(getResponderPerguntaMultiplaErradaVo()), Matchers.is(false));
	}
	
	@Test
	public void testarResponderPerguntaMultiplaComAlternativasCorretasErrada() {
		Mockito.when(perguntaRepository.getOne(Mockito.anyLong())).thenReturn(getPerguntaMultipla());
		
		Assert.assertThat(jogoService.responderPergunta(getResponderPerguntaMultiplaTodasOpcoesVo()), Matchers.is(false));
	}
	

	private PerguntaRespondidaVo getResponderPerguntaSimplesCorretaVo() {
		PerguntaRespondidaVo vo = new PerguntaRespondidaVo();
		vo.setIdPergunta(1L);
		vo.setRespostas(Lists.list(3L));
		return vo;
	}
	
	private PerguntaRespondidaVo getResponderPerguntaSimplesErradaVo() {
		PerguntaRespondidaVo vo = new PerguntaRespondidaVo();
		vo.setIdPergunta(1L);
		vo.setRespostas(Lists.list(1L));
		return vo;
	}
	
	private PerguntaRespondidaVo getResponderPerguntaMultiplaCorretaVo() {
		PerguntaRespondidaVo vo = new PerguntaRespondidaVo();
		vo.setIdPergunta(1L);
		vo.setRespostas(Lists.list(2L, 3L));
		return vo;
	}
	
	private PerguntaRespondidaVo getResponderPerguntaMultiplaErradaVo() {
		PerguntaRespondidaVo vo = new PerguntaRespondidaVo();
		vo.setIdPergunta(1L);
		vo.setRespostas(Lists.list(1L, 3L));
		return vo;
	}
	
	private PerguntaRespondidaVo getResponderPerguntaMultiplaTodasOpcoesVo() {
		PerguntaRespondidaVo vo = new PerguntaRespondidaVo();
		vo.setIdPergunta(1L);
		vo.setRespostas(Lists.list(1L, 2L, 3L));
		return vo;
	}

	private Pergunta getPerguntaSimples() {
		Pergunta pergunta = new Pergunta();
		pergunta.setId(1L);
		pergunta.setDescricao("Teste");
		pergunta.setTiporesposta("SIMPLES");
		pergunta.setRespostas(getRespostasPerguntaSimples());
		return pergunta;
	}
	
	private Pergunta getPerguntaMultipla() {
		Pergunta pergunta = new Pergunta();
		pergunta.setId(2L);
		pergunta.setDescricao("Teste");
		pergunta.setTiporesposta("MULTIPLA");
		pergunta.setRespostas(getRespostasPerguntaMultipla());
		return pergunta;
	}

	private List<Resposta> getRespostasPerguntaSimples() {
		List<Resposta> lista = new ArrayList<Resposta>();
		Resposta resposta1 = new Resposta();
		resposta1.setId(1L);
		resposta1.setDescricao("Errado");
		resposta1.setRespostaCorreta(false);
		lista.add(resposta1);
		Resposta resposta2 = new Resposta();
		resposta2.setId(2L);
		resposta2.setDescricao("Errado");
		resposta2.setRespostaCorreta(false);
		lista.add(resposta2);
		Resposta resposta3 = new Resposta();
		resposta3.setId(3L);
		resposta3.setDescricao("Correta");
		resposta3.setRespostaCorreta(true);
		lista.add(resposta3);
		return lista;
	}
	
	private List<Resposta> getRespostasPerguntaMultipla() {
		List<Resposta> lista = new ArrayList<Resposta>();
		Resposta resposta1 = new Resposta();
		resposta1.setId(1L);
		resposta1.setDescricao("Errado");
		resposta1.setRespostaCorreta(false);
		lista.add(resposta1);
		Resposta resposta2 = new Resposta();
		resposta2.setId(2L);
		resposta2.setDescricao("Correta");
		resposta2.setRespostaCorreta(true);
		lista.add(resposta2);
		Resposta resposta3 = new Resposta();
		resposta3.setId(3L);
		resposta3.setDescricao("Correta");
		resposta3.setRespostaCorreta(true);
		lista.add(resposta3);
		return lista;
	}
}
