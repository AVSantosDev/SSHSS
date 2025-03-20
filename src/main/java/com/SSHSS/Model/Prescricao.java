package com.SSHSS.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prescricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String descricao;

    private Date data;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDeSaude profissional;


    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public void emitir() {


    }
}
