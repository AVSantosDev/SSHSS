package com.SSHSS.Model;


import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    private String Status;
    private boolean tpConsulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public boolean isTpConsulta() {
        return tpConsulta;
    }

    public void setTpConsulta(boolean tpConsulta) {
        this.tpConsulta = tpConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfissionalDeSaude getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalDeSaude profissional) {
        this.profissional = profissional;
    }

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDeSaude profissional;


    public void marcarConsulta(Consulta consulta) {

    }








}
