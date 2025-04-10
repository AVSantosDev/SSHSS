package com.SSHSS.Controller;


import com.SSHSS.Model.Prontuario;
import com.SSHSS.Service.*;
import com.SSHSS.dtos.ProntuarioRedord;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/SSHSS")
public class ProntuarioController {

    final ProntuarioService prontuarioService;
    final PacienteService pacienteService;
    final ProfissionalDeSaudeService profissionalDeSaudeService;
    final PrescricaoService prescricaoService;
    final ConsultaService consultaService;


    public ProntuarioController(ProntuarioService prontuarioService,
                                PacienteService pacienteService,
                                ProfissionalDeSaudeService profissionalDeSaudeService,
                                PrescricaoService prescricaoService,
                                ConsultaService consultaService) {
        this.prontuarioService = prontuarioService;
        this.pacienteService = pacienteService;
        this.profissionalDeSaudeService = profissionalDeSaudeService;
        this.prescricaoService = prescricaoService;
        this.consultaService = consultaService;
    }

//    @GetMapping("/Prontuario")
//    public ResponseEntity<List<ListarProntuario>> listarProntuario() {
//        List<Prontuario> listaProntuario = prontuarioService.listarProntuario();
//        List<ListarProntuario> listaDTO = listaProntuario.stream()
//                .map(prontuario -> new ListarProntuario(
//                        prontuario.getId(),
//                        prontuario.getHistorico(),
//                        prontuario.getDataAtualizacao(),
////                        prontuario.getPaciente() != null ? prontuario.getPaciente().getId() : null,
//                        prontuario.getPaciente().stream().findFirst().map(Paciente::getId).orElse(null),
//                        prontuario.getProfissionalDeSaude() != null ? prontuario.getProfissionalDeSaude().getId() : null,
//                        prontuario.getConsulta() != null ? prontuario.getConsulta().getId() : null,
//                        prontuario.getPrescricao()!= null ? prontuario.getPrescricao().getId() : null
////
//                ))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(listaDTO);
//    }




 //   @GetMapping("/Prontuario/{id}")


//    @PostMapping("/Prontuario")
//    public ResponseEntity<Prontuario> inserirProntuario(@RequestBody @Valid ProntuarioRedord prontuarioRedord){
//        Prontuario prontuario = new Prontuario();
//        prontuario.setHistorico(prontuarioRedord.historico());
//        prontuario.setDataAtualizacao(prontuarioRedord.dataAtualizacao());
//
//        Optional<Paciente> pacienteOptional = pacienteService.findById(prontuarioRedord.id_paciente());
//        if (pacienteOptional.isEmpty()) {
//            return ResponseEntity.badRequest().body(prontuarioService.saveProntuario(prontuario));
//        }
//        prontuario.setPaciente(pacienteOptional.get());
//
//        Optional<ProfissionalDeSaude> profissionalDeSaudeOptional = profissionalDeSaudeService.listarProfissionalId(prontuarioRedord.id_profissional());
//        if (profissionalDeSaudeOptional .isEmpty()) {
//            return ResponseEntity.badRequest().body(prontuarioService.saveProntuario(prontuario));
//        }
//        prontuario.setProfissionalDeSaude(profissionalDeSaudeOptional.get());
//
//
//        Optional<Prescricao> prescricaoOptional = prescricaoService.buscarPrescricao(prontuarioRedord.id_prescricao());
//        if (prescricaoOptional.isEmpty()) {
//            return ResponseEntity.badRequest().body(prontuarioService.saveProntuario(prontuario));
//        }
//        prontuario.setPrescricao(prescricaoOptional.get());
//
//
//        Optional<Consulta> consultaOptional = consultaService.findById(prontuarioRedord.id_consulta());
//        if (consultaOptional.isEmpty()) {
//            return ResponseEntity.badRequest().body(prontuarioService.saveProntuario(prontuario));
//        }
//        prontuario.setConsulta(consultaOptional.get());
//
//        Prontuario novoProntuario = prontuarioService.saveProntuario(prontuario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novoProntuario);
//    }



    @PostMapping("/Prontuario")
    public ResponseEntity<Prontuario> inserirProntuario(@RequestBody @Valid ProntuarioRedord  prontuarioRedord) {
        Prontuario prontuario = new Prontuario();
        prontuario.setDataAtualizacao(prontuarioRedord.dataAtualizacao());

        Optional.ofNullable(prontuarioRedord.id_paciente())
                .flatMap(pacienteService::findById)
                .ifPresent(p -> prontuario.getPacientes().add(p));

        Optional.ofNullable(prontuarioRedord.id_profissional())
                .flatMap(profissionalDeSaudeService::listarProfissionalId)
                .ifPresent(prof ->prontuario.getProfissionais().add(prof));

        Optional.ofNullable(prontuarioRedord.id_consulta())
                .flatMap(prescricaoService::buscarPrescricao)
                .ifPresent(presc -> prontuario.getPrescricoes().add(presc));

        Optional.ofNullable(prontuarioRedord.id_consulta())
                .flatMap(consultaService::findById)
                .ifPresent(consulta -> prontuario.getConsultas().add(consulta));

        Prontuario novoProntuario = prontuarioService.saveProntuario(prontuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProntuario);


    }





//@PostMapping("/Prontuario")
//public ResponseEntity<Prontuario> CriarProntuario(@RequestBody ProntuarioRedord prontuarioRedord) {
//    Prontuario prontruario1 = prontuarioService.salvarProntuarioCompleto(prontuarioRedord);
//    return ResponseEntity.status(HttpStatus.CREATED).body(prontruario1);
//}
//
// alternativa testada para salvar dentro da tabela prontuario todos os dados



    @PutMapping("/Prontuario/{id}")
    public ResponseEntity<Object> atualizarProntuario(@PathVariable(value = "id")Long id, @RequestBody @Valid Prontuario prontuario) {
        Optional<Prontuario> prontuarioOptional = prontuarioService.bucarProntuario(id);
        if (prontuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(prontuarioService.saveProntuario(prontuario));
        }
        var atuaProntuario = prontuarioOptional.get();
        BeanUtils.copyProperties(prontuario, prontuario);
        return ResponseEntity.status(HttpStatus.OK).body(prontuarioService.saveProntuario(prontuario));
    }





    @DeleteMapping("/Prontuario/{id}")
    public ResponseEntity<Object> deletarProntuario(@PathVariable(value = "id")Long id){
        Optional<Prontuario> prontuarioOptional = prontuarioService.bucarProntuario(id);
        if (prontuarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prontuario não encontrada");
        }
        prontuarioService.deletarprontuario(prontuarioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Prontuario removido com sucesso!");
    }




}