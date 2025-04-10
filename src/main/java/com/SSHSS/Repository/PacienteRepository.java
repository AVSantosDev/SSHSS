package com.SSHSS.Repository;

import com.SSHSS.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByName(String name);

    Paciente findByCpf(String cpf);

    @Query("SELECT p FROM Paciente p LEFT JOIN FETCH p.prontuario LEFT JOIN FETCH p.consultas LEFT JOIN FETCH p.listaPrescricao LEFT JOIN FETCH p.exame WHERE p.id = :id")
    Paciente findByIdWithAllData(@Param("id") Long id);

    @Query("SELECT p FROM Paciente p LEFT JOIN FETCH p.prontuario LEFT JOIN FETCH p.consultas LEFT JOIN FETCH p.listaPrescricao LEFT JOIN FETCH p.exame WHERE LOWER(p.name) LIKE %:name%")
    List<Paciente> findByNameWithAllData(@Param("name") String name);

    @Query("SELECT p FROM Paciente p LEFT JOIN FETCH p.prontuario LEFT JOIN FETCH p.consultas LEFT JOIN FETCH p.listaPrescricao LEFT JOIN FETCH p.exame WHERE p.cpf = :cpf")
    Paciente findByCpfWithAllData(@Param("cpf") String cpf);

}
