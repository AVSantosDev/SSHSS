package com.SSHSS.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exames")
public class ExameController {

//    @Autowired
//    private SshssServices sshssServices;
//
//
//    @GetMapping
//    public ResponseEntity<List<Exame>> listarExames() {
//        List<Exame> exames = sshssServices.listarExames();
//        return ResponseEntity.ok(exames);
//    }
//
//    @PostMapping
//    public ResponseEntity<Exame> salvarExame(@RequestBody Exame exame) {
//        Exame exameSalvo = sshssServices.salvarExame(exame);
//        return ResponseEntity.status(HttpStatus.CREATED).body(exameSalvo);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Exame> atualizarExame(@PathVariable int id, @RequestBody Exame exameAtualizado) {
//        Optional<Exame> exameExistente = sshssServices.exameRepository.findById(id);
//        if (exameExistente.isPresent()) {
//            exameAtualizado.setId(id);
//            Exame exameSalvo = sshssServices.salvarExame(exameAtualizado);
//            return ResponseEntity.ok(exameSalvo);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletarExame(@PathVariable int id) {
//        if (sshssServices.exameRepository.existsById(id)) {
//            sshssServices.exameRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//


}
