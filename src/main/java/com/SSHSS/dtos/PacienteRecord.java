package com.SSHSS.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record PacienteRecord(@NotBlank String name,
                             @NotBlank String cpf,
                             @NotBlank String telefone,
                             @NotBlank @Email String email,
                             @NotNull Date DtNascimento,
                             @NotBlank String nomeDaMae) {

}


