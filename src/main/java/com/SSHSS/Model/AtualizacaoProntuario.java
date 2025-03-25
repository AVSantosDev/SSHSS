package com.SSHSS.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class AtualizacaoProntuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDeSaude profissional;

    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;

    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
}
