package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String tipo;
    private String resultado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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

    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDeSaude profissional;


    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public void solicitar(){


    }







}
