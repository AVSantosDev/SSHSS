package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prescricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String descricao;

    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ProfissionalDeSaude getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalDeSaude profissional) {
        this.profissional = profissional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDeSaude profissional;


    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public void emitir() {


    }
}
