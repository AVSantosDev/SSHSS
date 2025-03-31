package com.SSHSS.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProntuarioRedord(@NotBlank String historico,
                               @NotNull Date dataAtualizacao,
                               Long id_paciente,
                               Long id_profissional,
                               Long id_prescricao,
                               Long id_consulta) {

}

