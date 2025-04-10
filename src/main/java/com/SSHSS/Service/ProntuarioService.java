package com.SSHSS.Service;

import com.SSHSS.Model.Consulta;
import com.SSHSS.Model.Paciente;
import com.SSHSS.Model.ProfissionalDeSaude;
import com.SSHSS.Model.Prontuario;
import com.SSHSS.Repository.PacienteRepository;
import com.SSHSS.Repository.ProfissionalDeSaudeRepository;
import com.SSHSS.Repository.ProntuarioRepository;
import com.SSHSS.dtos.ProntuarioRedord;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProntuarioService {
    final ProntuarioRepository prontuarioRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfissionalDeSaudeRepository profissionalDeSaudeRepository;

    public ProntuarioService(ProntuarioRepository prontuarioRepository,PacienteRepository pacienteRepository,
                             ProfissionalDeSaudeRepository profissionalDeSaudeRepository) {
        this.prontuarioRepository = prontuarioRepository;
        this.pacienteRepository = pacienteRepository;
        this.profissionalDeSaudeRepository = profissionalDeSaudeRepository;
    }


    @Transactional

    public Prontuario saveProntuario(Prontuario prontuario) {return prontuarioRepository.save(prontuario);}
//    public List<Prontuario> listarProntuario() {return prontuarioRepository.findAll();}
//    public List<Prontuario> listarProntuario() {return prontuarioRepository.findAllWithAllData();}

    public List<Map<String, Object>> listarProntuario() {return prontuarioRepository.findAllWithAllData();}

    public Optional<Prontuario> bucarProntuario(Long id) {return prontuarioRepository.findById(id);}
    public void deletarprontuario(Prontuario prontuario) {prontuarioRepository.delete(prontuario);}



    //Metodo criado para tentar salvar dentro da tabela prontuario todos os dados porem sem sucesso ao tentar tratar a relação do paciente com o prontuario, está solicitando que seja varios Ids ou espera varios pacientes em uma lista.
//    public Prontuario salvarProntuarioCompleto(ProntuarioRedord prontuarioRedord) {
//        Prontuario prontuario = new Prontuario();
//        prontuario.setDataAtualizacao(prontuarioRedord.dataAtualizacao());
//
//        Set<Paciente> pacientes = new HashSet<>();
//        for (Long pacienteId : prontuarioRedord.id_paciente()){
//            Paciente paciente = pacienteRepository.findById(pacienteId)
//                .orElseThrow(()-> new RuntimeException("Paciente não encontrado com ID: " + pacienteId));
//            pacientes.add(paciente);}
//
//        prontuario.setPacientes(pacientes);
//
//        ProfissionalDeSaude profissional = profissionalDeSaudeRepository.findById(prontuarioRedord.id_profissional())
//                .orElseThrow(() -> new RuntimeException("Profissional de saúde não encontrado com ID: " + prontuarioRedord.id_profissional()));
//        Set<ProfissionalDeSaude> profissionais = new HashSet<>();
//        profissionais.add(profissional);
//        prontuario.setProfissionais(profissionais);
//
//        prontuario.setPrescricoes(new HashSet<>());
//        prontuario.setConsultas(new HashSet<>());
//
//
//
//        return prontuarioRepository.save(prontuario);
//    }
}
