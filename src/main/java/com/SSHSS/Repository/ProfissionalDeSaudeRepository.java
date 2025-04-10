package com.SSHSS.Repository;

import com.SSHSS.Model.Paciente;
import com.SSHSS.Model.ProfissionalDeSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfissionalDeSaudeRepository extends JpaRepository<ProfissionalDeSaude, Long> {

    List<ProfissionalDeSaude> findByNameContainingIgnoreCase(String name);


    @Query("SELECT p FROM ProfissionalDeSaude p WHERE p.name = :name")
    List<ProfissionalDeSaude> findByNameWithAllData(@Param("name") String name);


}
