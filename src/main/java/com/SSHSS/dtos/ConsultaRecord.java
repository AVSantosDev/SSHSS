package com.SSHSS.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ConsultaRecord(@NotNull Date dataHora,
                             @NotBlank String status,
                             @NotNull boolean tpConsulta,
                             @NotNull Long id_paciente,
                             @NotNull Long id_profissional) {
}
