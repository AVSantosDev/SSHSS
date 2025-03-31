package com.SSHSS.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PrescricaoRedord(@NotBlank String descricao,
                               @NotNull Date data,
                               @NotNull Long id_paciente,
                               @NotNull Long id_profissional) {
}
