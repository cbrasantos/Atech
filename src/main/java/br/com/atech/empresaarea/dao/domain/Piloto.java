package br.com.atech.empresaarea.dao.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PILOTO")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable =false)
    private Long id;

    @Column(name="CODIGO")
    private String codigo;
    @Column(name="NOME")
    private String nome;

    @OneToMany(mappedBy = "piloto", fetch = FetchType.LAZY)
    private List<Voo> voos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
