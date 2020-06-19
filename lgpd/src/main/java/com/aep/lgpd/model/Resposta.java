package com.aep.lgpd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pergunta")
public class Resposta implements Serializable {

    public Resposta() {
	}

	private static final long serialVersionUID = 300863813610417628L;

    @Id
    private Long id;

    private String descricao;

    private boolean respostaCorreta;

    private Pergunta pergunta;


}
