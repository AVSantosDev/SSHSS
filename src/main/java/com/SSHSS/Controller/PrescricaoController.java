package com.SSHSS.Controller;


import com.SSHSS.Model.Exame;
import com.SSHSS.Model.Paciente;
import com.SSHSS.Model.Prescricao;
import com.SSHSS.Model.ProfissionalDeSaude;
import com.SSHSS.Service.PacienteService;
import com.SSHSS.Service.PrescricaoService;
import com.SSHSS.Service.ProfissionalDeSaudeService;
import com.SSHSS.dtos.PrescricaoRedord;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SSHSS")
public class PrescricaoController {

    final PrescricaoService prescricaoService;
    final PacienteService pacienteService;
    final ProfissionalDeSaudeService profissionalDeSaudeService;


    public PrescricaoController(PrescricaoService prescricaoService,
                                PacienteService pacienteService,
                                ProfissionalDeSaudeService ProfissionalDeSaudeService) {
        this.prescricaoService = prescricaoService;
        this.pacienteService = pacienteService;
        this.profissionalDeSaudeService = ProfissionalDeSaudeService;
    }


    @GetMapping("/prescricao")
    public ResponseEntity<List<Prescricao>> listarPrescricao() {
        List<Prescricao> listaPrescricao = prescricaoService.listarPrescricao();
        return ResponseEntity.ok(listaPrescricao);
    }

    @GetMapping("/precricao/{id}")
    public ResponseEntity<Object> buscarPrescricao(@PathVariable Long id, Exame prescricao) {
        Optional<Prescricao> prescricaoOptional = prescricaoService.buscarPrescricao(id);
        if (prescricaoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prescrição não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(prescricaoOptional.get());
    }



    @PostMapping("/prescricao")
    public ResponseEntity<Prescricao> inserirPrescricao(@RequestBody @Valid PrescricaoRedord prescricaoRedord) {
        Prescricao prescricao = new Prescricao();
        prescricao.setData(prescricaoRedord.data());
        prescricao.setDescricao(prescricaoRedord.descricao());

        Optional<Paciente> pacienteOptional = pacienteService.findById(prescricaoRedord.id_paciente());
        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(prescricaoService.savePrescricao(prescricao));
        }
        prescricao.setPaciente(pacienteOptional.get());

        Optional<ProfissionalDeSaude> profissionalDeSaudeOptional = profissionalDeSaudeService.listarProfissionalId(prescricaoRedord.id_profissional());
        if (profissionalDeSaudeOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(prescricaoService.savePrescricao(prescricao));
        }
        prescricao.setProfissional(profissionalDeSaudeOptional.get());

        Prescricao novaPrescricao = prescricaoService.savePrescricao(prescricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPrescricao);
    }


    @PutMapping("/precricao/{id}")
    public ResponseEntity<Object> atualizarPrescicao(@PathVariable(value = "id")Long id, @RequestBody @Valid Prescricao prescricao) {
        Optional<Prescricao> prescricaoOptional = prescricaoService.buscarPrescricao(id);
        if (prescricaoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(prescricaoService.savePrescricao(prescricao));
        }
        var atuaPrescricao = prescricaoOptional.get();
        BeanUtils.copyProperties(prescricao, prescricao);
        return ResponseEntity.status(HttpStatus.OK).body(prescricaoService.savePrescricao(atuaPrescricao));
    }

    @DeleteMapping("/precricao/{id}")
    public ResponseEntity<Object> deletarPrescricao(@PathVariable(value = "id")Long id){
        Optional<Prescricao> prescricaoOptional = prescricaoService.buscarPrescricao(id);
        if (prescricaoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Precrição não encontrada");
        }
        prescricaoService.delelaPrescicao(prescricaoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Prescricao removida com sucesso!");
    }


}
