package com.SSHSS.Controller;


import com.SSHSS.Model.Consulta;
import com.SSHSS.Model.Paciente;
import com.SSHSS.Service.ConsultaService;
import com.SSHSS.Service.PacienteService;
import com.SSHSS.dtos.ConsultaRecord;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SSHSS")
public class ConsultaController {



    final ConsultaService consultaService;
    final PacienteService pacienteService;

    public ConsultaController(ConsultaService consultaService, PacienteService pacienteService) {this.consultaService = consultaService;this.pacienteService = pacienteService;}


    @GetMapping("/consulta")
    public ResponseEntity<List<Consulta>> listaConsulta(){
        List<Consulta> consultas = consultaService.findAllConsulta();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/consulta/{id}")
    public ResponseEntity<Object> buscaConsulta(@PathVariable(value = "id") Long id){
        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaOptional.get());
    }


//    @PostMapping("/consulta")
//    public ResponseEntity<Consulta> salvarConsulta(@RequestBody @Valid ConsultaRecord consultaRecord){
//        var consulta = new Consulta();
//        BeanUtils.copyProperties(consultaRecord, consulta);
//        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.saveConsulta(consulta));
//    }






    @PostMapping("/consulta")
    public ResponseEntity<Object> salvarConsulta(@RequestBody @Valid ConsultaRecord consultaRecord) {
        Consulta consulta = new Consulta();
        consulta.setDataHora(consultaRecord.dataHora());
        consulta.setStatus(consultaRecord.status());
        consulta.setTpConsulta(consultaRecord.tpConsulta());

        Optional<Paciente> pacienteOptional = pacienteService.findById(consultaRecord.id_paciente());
        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Paciente não encontrado");
        }
        consulta.setPaciente(pacienteOptional.get());

//        if(consultaRecord.profissional_id() != null) {
//            Optional<ProfissionalDeSaude> profissionalOptional = profissionalService.findById(consultaRecord.profissional_id());
//            if (profissionalOptional.isEmpty()) {
//                return ResponseEntity.badRequest().body("Profissional não encontrado");
//            }
//            consulta.setProfissional(profissionalOptional.get());
//        }

        Consulta novaConsulta = consultaService.saveConsulta(consulta);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
    }





    @PutMapping("/consulta/{id}/status")
    public ResponseEntity<Object> atualizarStatusConsulta(
            @PathVariable(value = "id") Long id,
            @RequestBody String novoStatus) {

        System.out.println("Iniciando atualização do status da consulta com ID: " + id);
        System.out.println("Novo status recebido: " + novoStatus);

        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()) {
            System.out.println("Consulta não encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada");
        }

        Consulta consulta = consultaOptional.get();
        System.out.println("Consulta recuperada do banco de dados: " + consulta);

        consulta.setStatus(novoStatus);
        System.out.println("Consulta com novo status: " + consulta);

        consultaService.saveConsulta(consulta);
        System.out.println("Consulta salva no banco de dados.");

        return ResponseEntity.status(HttpStatus.OK).body("Status da consulta atualizado com sucesso");
    }




//
//
//
//    @PutMapping("/consulta/{id}")
//    public ResponseEntity<Object> atualizarConsulta(@PathVariable(value ="id")Long id, @RequestBody @Valid Consulta consulta){
//        Optional<Consulta> consultaOptional = consultaService.findById(id);
//        if (consultaOptional.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada");
//        }
//        var consultas = consultaOptional.get();
//        BeanUtils.copyProperties(consulta, consulta);
//        return  ResponseEntity.status(HttpStatus.OK).body(consultaService.saveConsulta(consultas));
//    }

    @DeleteMapping("/consulta/{id}")
    public ResponseEntity<Object> removerConsulta(@PathVariable(value ="id")Long id){
        Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("consulta não encontrada");
        }
        consultaService.delete(consultaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Consulta removida com sucesso");
    }

}






