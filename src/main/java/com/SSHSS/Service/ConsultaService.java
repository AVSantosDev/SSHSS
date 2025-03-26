package com.SSHSS.Service;


import com.SSHSS.Model.Consulta;
import com.SSHSS.Repository.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConsultaService {

    final ConsultaRepository consultaRepository;

    public ConsultaService (ConsultaRepository consultaRepository){this.consultaRepository = consultaRepository;}

    @Transactional
    public Consulta saveConsulta (Consulta consulta){return consultaRepository.save(consulta);} //Salva consulta no banco de dados
    public List<Consulta> findAllConsulta(){return consultaRepository.findAll();} //retorna lista de consultas
    public Optional<Consulta> findById(Long id){return consultaRepository.findById(id); } // retornar uma consulta pelo id
    public void  delete(Consulta consulta){consultaRepository.delete(consulta);} //deleta uma consulta
}
