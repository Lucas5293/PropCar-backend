package br.gov.sp.fatec.web.controller;

import br.gov.sp.fatec.modelo.LoginJson;
import br.gov.sp.fatec.modelo.Usuario;
import br.gov.sp.fatec.service.security.JwtUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(exposedHeaders = "Token")
public class LoginRestController {

    @Autowired
    private AuthenticationManager auth;
    @Autowired
    private UserDetailsService segurancaService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<Usuario> login(@RequestBody LoginJson login, HttpServletResponse response)
            throws JsonProcessingException {
        Authentication credentials = new UsernamePasswordAuthenticationToken(login.getUsername(),  login.getPassword());
        Usuario usuario = (Usuario) auth.authenticate(credentials).getPrincipal();
        response.setHeader("Token", JwtUtils.generateToken(usuario));
        //usuario.setPassword(null);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

}
