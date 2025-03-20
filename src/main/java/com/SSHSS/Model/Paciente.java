package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Paciente   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;



    @OneToOne(mappedBy = "paciente",cascade = CascadeType.ALL)
    private Prontuario prontuario;

    @OneToMany(mappedBy = "paciente")
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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




     return;
    }
}
