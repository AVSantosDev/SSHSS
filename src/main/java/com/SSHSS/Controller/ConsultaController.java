package com.SSHSS.Controller;


import com.SSHSS.Model.Consulta;
import com.SSHSS.Service.SshssServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {


    @Autowired
    private SshssServices sshssServices;



    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsulta() {
        List<Consulta> consultas = sshssServices.listaConsultas();
        return ResponseEntity.ok(consultas);
    }

    @PostMapping
    public ResponseEntity<Consulta> salvarConsulta(@RequestBody Consulta consulta) {
        Consulta consultaSalva = sshssServices.salvarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaSalva);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Consulta> AtualizarConsulta(@PathVariable Long id, @RequestBody Consulta consultaAtualizada) {
        Optional<Consulta> consultaExistente = sshssServices.consultaRepository.findById(id);
        if (consultaExistente.isPresent()) {
            consultaAtualizada.setId(id);
            Consulta consultaSalva = sshssServices.salvarConsulta(consultaAtualizada);
            return ResponseEntity.ok(consultaSalva);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Consulta> DeletarConsulta(@PathVariable Long id) {
        if (sshssServices.consultaRepository.existsById(id)) {
            sshssServices.consultaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}




