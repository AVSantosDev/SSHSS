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


    public void getDados(){




     return;
    }
}
