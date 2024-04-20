package net.meuamigoviajante.meuAmigoViajante.service;

import net.meuamigoviajante.meuAmigoViajante.dto.UsuarioDto;

public interface UsuarioService {
    UsuarioDto createUsuario(UsuarioDto usuarioDto);

    UsuarioDto getUsuarioById(Long usuarioId);

}
