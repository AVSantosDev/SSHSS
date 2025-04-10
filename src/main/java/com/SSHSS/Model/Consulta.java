package com.SSHSS.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name="consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator ="uuid2")
    //@GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "idConsulta")
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    private String status;
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

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {this.status = status;}

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
    @JoinColumn(name = "id_paciente")
    @NotNull
    @JsonIgnore
    private Paciente paciente;


    @ManyToOne
    @JoinColumn(name = "id_profissional")
    @NotNull
    @JsonIgnore
    private ProfissionalDeSaude profissional;


    public void marcarConsulta(Consulta consulta) {

    }








}
