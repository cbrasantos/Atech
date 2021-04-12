package br.com.atech.empresaarea.dao.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CIDADE")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable =false)
    private Long id;

    @Column(name="CODIGO")
    private String codigo;
    @Column(name="NOME")
    private String nome;
    @Column(name="UF")
    private String uf;


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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    private List<Voo> voos;


    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
