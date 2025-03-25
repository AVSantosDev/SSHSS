package com.SSHSS.dtos;

import javax.swing.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record PacienteRecord(@NotBlank String name,
                             @NotBlank String cpf,
                             @NotBlank String telefone,
                             @NotBlank @Email String email) {

}


