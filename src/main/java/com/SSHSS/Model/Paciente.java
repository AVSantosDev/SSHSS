package com.SSHSS.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "paciente")
public class Paciente   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    //private UUID id;
    @Column(name="idPaciente")
    private Long id;
    private String name;
    private String cpf;
    private String telefone;
    private String email;
    private Date DtNascimento;
    private String nomeDaMae;

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public Date getDtNascimento() {
        return DtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        DtNascimento = dtNascimento;
    }

    @OneToOne(mappedBy = "paciente",cascade = CascadeType.ALL)
    private Prontuario prontuario;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente")
    private List<Prescricao> listaPrescricao;

    @OneToMany(mappedBy = "paciente")
    private List<Exame> exame;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Prescricao> getListaPrescricao() {
        return listaPrescricao;
    }

    public void setListaPrescricao(List<Prescricao> listaPrescricao) {
        this.listaPrescricao = listaPrescricao;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }

    public void getDados(){

    }
}
