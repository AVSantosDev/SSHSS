package com.SSHSS.Controller;

import com.SSHSS.Model.Paciente;
import com.SSHSS.Model.ProfissionalDeSaude;
import com.SSHSS.Service.SshssServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profissional")
public class ProfissionalDeSaudeController {

    @Autowired
    private SshssServices sshssServices;

    @GetMapping
    public ResponseEntity<List<ProfissionalDeSaude>> listarProfissionais() {
        List<ProfissionalDeSaude> profissionais = sshssServices.listarProfissionais();
        return ResponseEntity.ok(profissionais);
    }

    @PostMapping
    public ResponseEntity<ProfissionalDeSaude> SalvarPaciente(@RequestBody ProfissionalDeSaude profissionalDeSaude) {
        ProfissionalDeSaude profissionalDeSaudeSalvo = sshssServices.salvarProfissional(profissionalDeSaude);
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalDeSaudeSalvo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDeSaude> atualizarProfissional(@PathVariable int id, @RequestBody ProfissionalDeSaude profissionalAtualizado) {
        Optional<ProfissionalDeSaude> profissionalDeSaudeExistente = sshssServices.profissionalDeSaudeRepository.findById(id);
        if(profissionalDeSaudeExistente.isPresent()) {
            profissionalAtualizado.setId(id);
            ProfissionalDeSaude profissionalSalvo = sshssServices.salvarProfissional(profissionalAtualizado);
            return ResponseEntity.ok(profissionalSalvo);
        }else{
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<ProfissionalDeSaude> deletarProfissional(@PathVariable int id) {
        if (sshssServices.profissionalDeSaudeRepository.existsById(id)) {
            sshssServices.profissionalDeSaudeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}



