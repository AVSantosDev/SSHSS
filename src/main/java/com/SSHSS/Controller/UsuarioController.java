package com.SSHSS.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
//
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @GetMapping
//    public ResponseEntity<List<Usuario>> listarUsuarios() {
//        List<Usuario> usuarios = usuarioRepository.findAll();
//        return ResponseEntity.ok(usuarios);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
//        Usuario usuarioSalvo = usuarioRepository.save(usuario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
//        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
//        if (usuarioExistente.isPresent()) {
//            usuarioAtualizado.setId(id);
//            Usuario usuarioSalvo = usuarioRepository.save(usuarioAtualizado);
//            return ResponseEntity.ok(usuarioSalvo);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
//        if (usuarioRepository.existsById(id)) {
//            usuarioRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
