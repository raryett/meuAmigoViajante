package net.meuamigoviajante.meuAmigoViajante.controller;

import lombok.AllArgsConstructor;
import net.meuamigoviajante.meuAmigoViajante.dto.UsuarioDto;
import net.meuamigoviajante.meuAmigoViajante.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

        private UsuarioService usuarioService;

        //Build ADD Employee REST API
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
//so pra ver

}
