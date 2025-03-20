package com.SSHSS.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String historico;


    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToMany(mappedBy = "prontuario")
    private List<AtualizacaoProntuario> Atualizacoes;


    public void atualizar() {


    }

}
