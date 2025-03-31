package com.SSHSS.Service;


import com.SSHSS.Model.Prescricao;
import com.SSHSS.Repository.PrescricaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescricaoService {
    final PrescricaoRepository prescricaoRepository;

    public PrescricaoService(PrescricaoRepository prescricaoRepository) {this.prescricaoRepository = prescricaoRepository;}

    @Transactional
    public Prescricao savePrescricao(Prescricao prescricao) {return prescricaoRepository.save(prescricao);}
    public List<Prescricao> listarPrescricao(){return prescricaoRepository.findAll();}
    public Optional<Prescricao> buscarPrescricao(Long id) {return prescricaoRepository.findById(id);}
    public void delelaPrescicao(Prescricao prescricao) {prescricaoRepository.delete(prescricao);}
}
