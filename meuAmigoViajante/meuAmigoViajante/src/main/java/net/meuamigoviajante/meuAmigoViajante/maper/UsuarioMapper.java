package net.meuamigoviajante.meuAmigoViajante.maper;

import net.meuamigoviajante.meuAmigoViajante.dto.UsuarioDto;
import net.meuamigoviajante.meuAmigoViajante.entity.Usuario;

public class UsuarioMapper {
    //aqui eu to fazendo um mapa pra n precisar ficar escrevendo tudo isso no usuarioDTO
    //entao eu vou setar as informacoes mapeando elas pra ficar mais limpo
    // aqui estou fazendo o get e
    public static UsuarioDto mapToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getFirstName(),
                usuario.getLastName(),
                usuario.getEmail()
        );
    }


    public static Usuario mapToUsuario(UsuarioDto usuarioDto) {
        return new Usuario(
                usuarioDto.getId(),
                usuarioDto.getFirstName(),
                usuarioDto.getLastName(),
                usuarioDto.getEmail()
        );
    }
}
