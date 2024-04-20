package net.meuamigoviajante.meuAmigoViajante.repository;

import net.meuamigoviajante.meuAmigoViajante.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
