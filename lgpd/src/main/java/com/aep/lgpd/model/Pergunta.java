package com.aep.lgpd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Entity
@Table(name = "pergunta")
@Data
@ToString
public class Pergunta implements Serializable {

    private static final long serialVersionUID = 3938638460999784207L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonProperty
    private Long id;

    @NonNull
    @JsonProperty
    private String descricao;

    @JsonProperty
    private String tiporesposta;
    
    private List<Resposta> respostas;

    public Pergunta(String descricao) {
        this.descricao = descricao;
    }

    public Pergunta() {
    }

	public List<Long> getRespostasCorretas() {
		return respostas.stream().filter(Resposta::isRespostaCorreta).map(Resposta::getId).collect(Collectors.toList());
	}

	public Long getRespostaCorreta() {
		return respostas.stream().filter(Resposta::isRespostaCorreta).findFirst().get().getId();
	}
}
