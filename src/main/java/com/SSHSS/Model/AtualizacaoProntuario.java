package com.SSHSS.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class AtualizacaoProntuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDeSaude profissional;

    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;

    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
}
