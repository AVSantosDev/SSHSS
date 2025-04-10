package com.SSHSS.Service;

import com.SSHSS.Model.Consulta;
import com.SSHSS.Model.Exame;
import com.SSHSS.Model.Prescricao;
import com.SSHSS.Repository.ConsultaRepository;
import com.SSHSS.Repository.ExameRepository;
import com.SSHSS.Repository.PrescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SshssServices {


    @Autowired
    public ConsultaRepository consultaRepository;

    @Autowired
    public ExameRepository exameRepository;



    @Autowired
    public PrescricaoRepository prescricaoRepository;
//
//    @Autowired
//    public ProfissionalDeSaudeRepository profissionalDeSaudeRepository;



    public Consulta salvarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);

    }

    public List<Consulta> listaConsultas() {
        return consultaRepository.findAll();

    }

//    public Optional<Paciente> buscaPaciente(long id){
//        return pacienteRepository.findById(id);
//
//    }

    public Exame salvarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    public List<Exame> listarExames() {
        return exameRepository.findAll();
    }

    public Prescricao salvarPrescricao(Prescricao prescricao) {
        return prescricaoRepository.save(prescricao);
    }


    public List<Prescricao> listarPrescricoes() {
        return prescricaoRepository.findAll();
    }
//
//    public ProfissionalDeSaude salvarProfissional(ProfissionalDeSaude profissionalDeSaude) {
//        return profissionalDeSaudeRepository.save(profissionalDeSaude);
//
//    }
//
//    public List<ProfissionalDeSaude> listarProfissionais() {
//        return profissionalDeSaudeRepository.findAll();
//    }
//


}
