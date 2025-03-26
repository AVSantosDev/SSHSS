package com.SSHSS.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfissionalDeSaudeRecord(@NotBlank String name,
                                        @NotBlank String especialidade,
                                        @NotBlank String crmCoren) {
}



