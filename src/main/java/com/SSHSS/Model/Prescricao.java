package com.SSHSS.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "prescricao")
public class Prescricao {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrescricao")
    private Long id;
    private String descricao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    @JoinColumn(name = "id_profissional")
    @JsonIgnore
    private ProfissionalDeSaude profissional;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;


    @ManyToOne
    @JoinColumn(name = "id_prontuario")
    @JsonIgnore
    private Prontuario prontuario;

    public void emitir() {


    }

    public void setProntuario(Prontuario novoProntuario) {
    }

}
