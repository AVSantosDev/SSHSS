package com.SSHSS.dtos;

import java.util.Date;

public record ListarProntuario(Long id,
                               String historico,
                               Date dataAtualizacao,
                               Long id_paciente,
                               Long id_profissional,
                               Long id_prescricao,
                               Long id_consulta) {
}
