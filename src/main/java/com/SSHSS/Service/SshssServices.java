package com.SSHSS.Service;

import com.SSHSS.Model.*;
import com.SSHSS.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
