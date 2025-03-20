package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String tipo;
    private String resultado;


    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDeSaude profissional;


    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public void solicitar(){


    }







}
