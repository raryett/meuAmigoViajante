package net.meuamigoviajante.meuAmigoViajante.service.implementation;

import lombok.AllArgsConstructor;
import net.meuamigoviajante.meuAmigoViajante.dto.UsuarioDto;
import net.meuamigoviajante.meuAmigoViajante.entity.Usuario;
import net.meuamigoviajante.meuAmigoViajante.exception.ResourceNotFoundException;
import net.meuamigoviajante.meuAmigoViajante.maper.UsuarioMapper;
import net.meuamigoviajante.meuAmigoViajante.repository.UsuarioRepository;
import net.meuamigoviajante.meuAmigoViajante.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = UsuarioMapper.mapToUsuario(usuarioDto);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDto(savedUsuario);

    }

    @Override
    public UsuarioDto getUsuarioById(Long usuarioId) {
    Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Usuario não encontrado com esse id: " + usuarioId));

        return UsuarioMapper.mapToUsuarioDto(usuario);
    }

    //preciso ver se esta conectado
}
