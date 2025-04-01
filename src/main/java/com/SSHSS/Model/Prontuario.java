package com.SSHSS.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProntuario")
    private Long id;
    private Date dataAtualizacao;

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Set<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(Set<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }

    public Set<ProfissionalDeSaude> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(Set<ProfissionalDeSaude> profissionais) {
        this.profissionais = profissionais;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

//    public Date getDataAtualizacao() {
//        return dataAtualizacao;
//    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany
    @JoinTable(
            name = "prontuario_paciente",
            joinColumns = @JoinColumn(name = "prontuario_id"),
            inverseJoinColumns = @JoinColumn(name = "paciente_id")
    )
    @JsonIgnore
    private Set<Paciente> pacientes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "prontuario_profissional",
            joinColumns = @JoinColumn(name = "prontuario_id"),
            inverseJoinColumns = @JoinColumn(name = "profissional_id")
    )
    @JsonIgnore
    private Set<ProfissionalDeSaude> profissionais = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "prontuario_prescricao",
            joinColumns = @JoinColumn(name = "prontuario_id"),
            inverseJoinColumns = @JoinColumn(name = "prescricao_id")
    )
    @JsonIgnore
    private Set<Prescricao> prescricoes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "prontuario_consulta",
            joinColumns = @JoinColumn(name = "prontuario_id"),
            inverseJoinColumns = @JoinColumn(name = "consulta_id")
    )
    @JsonIgnore
    private Set<Consulta> consultas = new HashSet<>();


}