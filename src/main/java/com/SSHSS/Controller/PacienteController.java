package com.SSHSS.Controller;

import com.SSHSS.Model.Paciente;
import com.SSHSS.Service.SshssServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private SshssServices sshssServices;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPaciente() {
        List<Paciente> pacientes = sshssServices.pacienteRepository.findAll();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) {
        Optional<Paciente> paciente = sshssServices.pacienteRepository.findById(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteSalvo = sshssServices.pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        Optional<Paciente> pacienteExistente = sshssServices.buscaPaciente(id);
        if(pacienteExistente.isPresent()) {
            pacienteAtualizado.setId(id);
            Paciente pacienteSalvo = sshssServices.pacienteRepository.save(pacienteAtualizado);
            return ResponseEntity.ok(pacienteSalvo);
        }else{
        return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> deletarPaciente(@PathVariable Long id) {
        if (sshssServices.pacienteRepository.existsById(id)) {
            sshssServices.pacienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
