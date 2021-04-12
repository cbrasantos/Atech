package br.com.atech.empresaarea.dao.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "AVIAO")
public class Aviao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable =false)
    private Long id;


    @Column(name="CODIGO")
    private String codigo;
    @Column(name="DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "aviao", fetch = FetchType.LAZY)
    private List<Voo> voos;



}
