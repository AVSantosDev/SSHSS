package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="profissional_de_saude")
public class ProfissionalDeSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProfissional")
    private Long id;
    private String name;
    private String especialidade;
    private String crmCoren;
    private String cargoProf;

    public String getCargoProf() {
        return cargoProf;
    }

    public void setCargoProf(String cargoProf) {
        this.cargoProf = cargoProf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
