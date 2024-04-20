package net.meuamigoviajante.meuAmigoViajante.controller;

import lombok.AllArgsConstructor;
import net.meuamigoviajante.meuAmigoViajante.dto.UsuarioDto;
import net.meuamigoviajante.meuAmigoViajante.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

        private UsuarioService usuarioService;

        //Build ADD Usuario REST API
    @PostMapping
        public ResponseEntity<UsuarioDto> createUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto savedUsuario = usuarioService.createUsuario(usuarioDto);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
        }

        //buil get Usuario Rest API
    @GetMapping("{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable("id") Long usuarioId) {
         UsuarioDto usuarioDto = usuarioService.getUsuarioById(usuarioId);
         return ResponseEntity.ok(usuarioDto);
    }

    //BUIL GET ALL USUARIOS REST API
    @GetMapping
    public  ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
       List<UsuarioDto> usuarios =  usuarioService.getAllUsuarios();
       return ResponseEntity.ok(usuarios);
    }


    //BUIL UPDATE USUARIO API
    @PutMapping("{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable ("id")Long usuarioId,
                                                    @RequestBody UsuarioDto updatedUsuario) {
        UsuarioDto usarioDto = usuarioService.updateUsuario(usuarioId,updatedUsuario);
        return ResponseEntity.ok(usarioDto);

    }

    /// BUIL DELETE USUARIO REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long usuarioId) {
        usuarioService.deleteUsuario(usuarioId);
        return ResponseEntity.ok("Usario deletado com sucesso!");

    }
}
