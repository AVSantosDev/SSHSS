package com.SSHSS.Service;

import com.SSHSS.Model.Prontuario;
import com.SSHSS.Repository.ProntuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {
    final ProntuarioRepository prontuarioRepository;
    public ProntuarioService(ProntuarioRepository prontuarioRepository) {this.prontuarioRepository = prontuarioRepository;}

    @Transactional

    public Prontuario saveProntuario(Prontuario prontuario) {return prontuarioRepository.save(prontuario);}
    public List<Prontuario> listarProntuario(){return prontuarioRepository.findAll();}
    public Optional<Prontuario> bucarProntuario(Long id){return prontuarioRepository.findById(id);}
    public void deletarprontuario(Prontuario prontuario){prontuarioRepository.delete(prontuario);}
}
