package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProfissionalDeSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String especialidade;
    private String crmCoren;


    @OneToMany(mappedBy = "profissional")
    private List<Consulta> consultas;


    @OneToMany(mappedBy = "profissional")
    private List<Prescricao> prescricoes;

    @OneToMany(mappedBy = "profissional")
    private List<Exame> exames;

    public void gerenciarConsultaExames(){

    }






}
