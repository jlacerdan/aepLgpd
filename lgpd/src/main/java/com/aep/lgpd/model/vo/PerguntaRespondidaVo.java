package com.aep.lgpd.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class PerguntaRespondidaVo {
    private Long idPergunta;
    private List<Long> respostas;
}
