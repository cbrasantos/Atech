package br.com.atech.empresaarea.dao.domain;

import br.com.atech.empresaarea.dao.enums.StatusVooValue;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "VOO")
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable =false)
    private Long id;

    @Column(name="NUMERO")
    private Long numero;
    @Column(name="DATA_PARTIDA")
    private String codigo;
    @Column(name="HORA_SAIDA")
    private Date horaSaida;
    @Column(name="HORA_CHEGADA")
    private Date horaChegada;
    @Enumerated(EnumType.STRING)
    private StatusVooValue status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PILOTO_ID", referencedColumnName = "ID")
    private Piloto piloto;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CIDADE_ID", referencedColumnName = "ID")
    private Cidade cidadeOrigem;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CIDADE_ID", referencedColumnName = "ID")
    private Cidade cidadeDestino;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "AVIAO_ID", referencedColumnName = "ID")
    private Aviao aviao;


}
