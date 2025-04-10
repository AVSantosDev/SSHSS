package com.SSHSS.Controller;

import com.SSHSS.Model.ProfissionalDeSaude;
import com.SSHSS.Service.ProfissionalDeSaudeService;
import com.SSHSS.dtos.ProfissionalDeSaudeRecord;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SSHSS")
public class ProfissionalDeSaudeController {

    final ProfissionalDeSaudeService profissionalDeSaudeService;

    public ProfissionalDeSaudeController(ProfissionalDeSaudeService profissionalDeSaudeService) {this.profissionalDeSaudeService = profissionalDeSaudeService;}

    @GetMapping("/profissional_de_saude")
    public ResponseEntity<List<ProfissionalDeSaude>> listarProfissionais() {
        List<ProfissionalDeSaude> profissionais = profissionalDeSaudeService.listarProfissionais();
        return ResponseEntity.ok(profissionais);

    }

    @GetMapping("/profissional_de_saude/{id}")
    public ResponseEntity<Object> listarProfissionalId(@PathVariable(value = "id") Long id) {
       Optional<ProfissionalDeSaude> profissionalDeSaudeOptional = profissionalDeSaudeService.listarProfissionalId(id);
       if (profissionalDeSaudeOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissional não encontrado");
       }
        return ResponseEntity.status(HttpStatus.OK).body(profissionalDeSaudeOptional.get());
    }


    @PostMapping("/profissional_de_saude")
    public ResponseEntity<Object> salvarPaciente(@RequestBody @Valid ProfissionalDeSaudeRecord profissionalDeSaudeRecord) {
        var novoProfissional = new ProfissionalDeSaude();
        BeanUtils.copyProperties(profissionalDeSaudeRecord, novoProfissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalDeSaudeService.saveProfissional(novoProfissional));

    }


    @PutMapping("/profissional_de_saude/{id}")
    public ResponseEntity<Object> atualizarProfissional(@PathVariable(value = "id") Long id,@RequestBody @Valid ProfissionalDeSaudeRecord profissionalDeSaudeRecord) {

        Optional<ProfissionalDeSaude> profissionalDeSaudeOptional = profissionalDeSaudeService.listarProfissionalId(id);
        if (profissionalDeSaudeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissional não encontrado");
        }
        var profissional = profissionalDeSaudeOptional.get();
        BeanUtils.copyProperties(profissionalDeSaudeRecord, profissional);
        return ResponseEntity.status(HttpStatus.OK).body(profissionalDeSaudeService.saveProfissional(profissional));
    }




    @DeleteMapping("/profissional_de_saude/{id}")
    public ResponseEntity<Object> deletarProfissional(@PathVariable(value = "id")Long id){
        Optional<ProfissionalDeSaude> profissionalDeSaudeOptional = profissionalDeSaudeService.listarProfissionalId(id);
        if (profissionalDeSaudeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissional não encontrado");
        }
        profissionalDeSaudeService.delete(profissionalDeSaudeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Profissional deletado com sucesso");

    }

}



