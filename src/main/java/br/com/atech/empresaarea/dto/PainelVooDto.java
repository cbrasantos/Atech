package br.com.atech.empresaarea.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PainelVooDto {


    @JsonProperty("nome-piloto")
    private String nomePiloto;
    @JsonProperty("status-voo")
    private String status;
    @JsonProperty("cidade-origem")
    private String cidadeOrigem;
    @JsonProperty("cidade-destino")
    private String cidadeDestino;
    @JsonProperty("data-partida")
    private String dataPartida;
    @JsonProperty("data-chegada")
    private String dataChegada;
    @JsonProperty("descricao-aviao")
    private String descricaoAviao;

}
