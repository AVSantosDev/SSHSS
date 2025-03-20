package com.SSHSS.Controller;


import com.SSHSS.Model.Prescricao;
import com.SSHSS.Service.SshssServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prescricoes")
public class PrescricaoController {


    @Autowired
    private SshssServices sshssServices;

    @GetMapping
    public ResponseEntity<List<Prescricao>> listarPrescricoes() {
        List<Prescricao> prescricoes = sshssServices.listarPrescricoes();
        return ResponseEntity.ok(prescricoes);
    }

    @PostMapping
    public ResponseEntity<Prescricao> salvarPrescricao(@RequestBody Prescricao prescricao) {
        Prescricao prescricaoSalva = sshssServices.salvarPrescricao(prescricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(prescricaoSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescricao> atualizarPrescricao(@PathVariable int id, @RequestBody Prescricao prescricaoAtualizada) {
        Optional<Prescricao> prescricaoExistente = sshssServices.prescricaoRepository.findById(id);
        if (prescricaoExistente.isPresent()) {
            prescricaoAtualizada.setId(id);
            Prescricao prescricaoSalva = sshssServices.salvarPrescricao(prescricaoAtualizada);
            return ResponseEntity.ok(prescricaoSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPrescricao(@PathVariable int id) {
        if (sshssServices.prescricaoRepository.existsById(id)) {
            sshssServices.prescricaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
