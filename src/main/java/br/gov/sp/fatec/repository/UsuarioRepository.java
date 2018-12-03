package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
