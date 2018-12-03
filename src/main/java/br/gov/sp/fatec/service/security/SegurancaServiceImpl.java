package br.gov.sp.fatec.service.security;

import br.gov.sp.fatec.modelo.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class SegurancaServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario user = this.repository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found: "+s);
        }
        return user;
    }
}
