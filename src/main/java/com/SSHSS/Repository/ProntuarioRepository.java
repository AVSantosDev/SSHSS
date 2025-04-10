package com.SSHSS.Repository;

import com.SSHSS.Model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

    @Query(value = "SELECT p.Id_Prontuario, pp.paciente_id, ppre.prescricao_id, pc.consulta_id, ppro.profissional_id, data_atualizacao, historico FROM prontuario AS p LEFT JOIN prontuario_paciente AS pp ON p.Id_Prontuario = pp.prontuario_id left join prontuario_consulta as pc on p.id_prontuario = pc.prontuario_id left join prontuario_prescricao as ppre on p.id_prontuario = ppre.prontuario_id left join prontuario_profissional as ppro on p.id_prontuario = ppro.prontuario_id",
            nativeQuery = true)
    List<Map<String, Object>> findAllWithAllData();
}
