package com.SSHSS.Repository;

import com.SSHSS.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
