package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class ProfissionalDeSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String especialidade;
    private String crmCoren;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrmCoren() {
        return crmCoren;
    }

    public void setCrmCoren(String crmCoren) {
        this.crmCoren = crmCoren;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    @OneToMany(mappedBy = "profissional")
    private List<Consulta> consultas;


    @OneToMany(mappedBy = "profissional")
    private List<Prescricao> prescricoes;

    @OneToMany(mappedBy = "profissional")
    private List<Exame> exames;

    public void gerenciarConsultaExames(){

    }






}
