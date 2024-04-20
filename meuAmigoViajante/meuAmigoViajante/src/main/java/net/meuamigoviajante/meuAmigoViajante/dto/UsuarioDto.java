package net.meuamigoviajante.meuAmigoViajante.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

        private Long id;
        private String FirstName;
        private String LastName;
        private String Email;

}
