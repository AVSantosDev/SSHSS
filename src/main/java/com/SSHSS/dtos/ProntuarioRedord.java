package com.SSHSS.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.Set;

public record ProntuarioRedord(@NotNull Date dataAtualizacao,
                               //@NotNull Set<Long> id_paciente, //Alternativa se for saltar em outro metodo do service.

                               Long id_paciente,
                               Long id_profissional,
                               Long id_prescricao,
                               Long id_consulta) {

}

