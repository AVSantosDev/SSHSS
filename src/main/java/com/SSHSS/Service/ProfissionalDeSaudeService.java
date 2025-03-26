package com.SSHSS.Service;


import com.SSHSS.Model.ProfissionalDeSaude;
import com.SSHSS.Repository.ProfissionalDeSaudeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalDeSaudeService {


    final ProfissionalDeSaudeRepository profissionalDeSaudeRepository;

    public ProfissionalDeSaudeService(ProfissionalDeSaudeRepository profissionalDeSaudeRepository){this.profissionalDeSaudeRepository = profissionalDeSaudeRepository;}

    @Transactional
    public ProfissionalDeSaude saveProfissional(ProfissionalDeSaude profissionalDeSaude){return profissionalDeSaudeRepository.save(profissionalDeSaude);}
    public List<ProfissionalDeSaude> listarProfissionais(){return profissionalDeSaudeRepository.findAll();}
    public Optional<ProfissionalDeSaude> listarProfissionalId(Long id){return profissionalDeSaudeRepository.findById(id);}
    public  void delete(ProfissionalDeSaude profissionalDeSaude){profissionalDeSaudeRepository.delete(profissionalDeSaude);}



}
