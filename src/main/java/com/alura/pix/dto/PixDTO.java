package com.alura.pix.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PixDTO {
    private Integer id;
    private String identifier;

    @JsonProperty("chave_origem")
    private String chaveOrigem;

    @JsonProperty("chave_destino")
    private String chaveDestino;
    private Double valor;

    @JsonProperty("data_transferencia")
    private LocalDateTime dataTransferencia;
    private PixStatus status;
}
