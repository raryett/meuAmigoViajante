package net.meuamigoviajante.meuAmigoViajante.service.implementation;

import lombok.AllArgsConstructor;
import net.meuamigoviajante.meuAmigoViajante.dto.UsuarioDto;
import net.meuamigoviajante.meuAmigoViajante.entity.Usuario;
import net.meuamigoviajante.meuAmigoViajante.exception.ResourceNotFoundException;
import net.meuamigoviajante.meuAmigoViajante.maper.UsuarioMapper;
import net.meuamigoviajante.meuAmigoViajante.repository.UsuarioRepository;
import net.meuamigoviajante.meuAmigoViajante.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UsuarioDto> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map((usuario) -> UsuarioMapper.mapToUsuarioDto(usuario))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto updateUsuario(Long usuarioId, UsuarioDto updatedUsuario) {

       Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                ()-> new ResourceNotFoundException("Nenhum usuario encontrado com esse id: " + usuarioId)
        );

       usuario.setFirstName(updatedUsuario.getFirstName());
       usuario.setLastName(updatedUsuario.getLastName());
       usuario.setEmail(updatedUsuario.getEmail());

       Usuario updateUsuarioObj =  usuarioRepository.save(usuario);

        return UsuarioMapper.mapToUsuarioDto(updateUsuarioObj) ;
    }

    @Override
    public void deleteUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                ()-> new ResourceNotFoundException("Nenhum usuario encontrado com esse id: " + usuarioId)
        );


    usuarioRepository.deleteById(usuarioId);
    }


}
