package com.SSHSS.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProntuario")
    private Long id;
    private String historico;
    private Date dataAtualizacao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfissionalDeSaude getProfissionalDeSaude() {
        return profissionalDeSaude;
    }

    public void setProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude) {
        this.profissionalDeSaude = profissionalDeSaude;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<AtualizacaoProntuario> getAtualizacoes() {
        return Atualizacoes;
    }

    public void setAtualizacoes(List<AtualizacaoProntuario> atualizacoes) {
        Atualizacoes = atualizacoes;
    }

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    @JsonIgnore
    private ProfissionalDeSaude profissionalDeSaude;

    @ManyToOne
    @JoinColumn(name = "id_prescicao")
    @JsonIgnore
    private Prescricao prescricao;

    @ManyToOne
    @JoinColumn(name = "id_consulta")
    @JsonIgnore
    private Consulta consulta;

    @OneToMany(mappedBy = "prontuario")
    @JsonIgnore
    private List<AtualizacaoProntuario> Atualizacoes;



    public void atualizar() {


    }

}
