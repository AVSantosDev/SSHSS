package com.SSHSS.Controller;

import com.SSHSS.Model.Paciente;
import com.SSHSS.Service.PacienteService;
import com.SSHSS.dtos.PacienteRecord;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SSHSS")
public class PacienteController {


    final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/paciente")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Object> buscarPaciente(@PathVariable(value = "id") Long id) {
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não existe");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteOptional.get());
    }


    @PostMapping("/paciente")
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody @Valid PacienteRecord pacienteRecord) {
        var paciente = new Paciente();
        BeanUtils.copyProperties(pacienteRecord, paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));

    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<Object> atualizarPaciente(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid PacienteRecord pacienteRecord) {
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado. ");
        }
        var paciente = pacienteOptional.get();
        BeanUtils.copyProperties(pacienteRecord, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(paciente));
    }


    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Object> deletarPaciente(@PathVariable(value = "id") Long id) {
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado. ");
        }
        pacienteService.delete(pacienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso!");
    }
}
