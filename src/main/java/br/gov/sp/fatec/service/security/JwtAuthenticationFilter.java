package br.gov.sp.fatec.service.security;

import br.gov.sp.fatec.modelo.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {

    private String tokenHeader = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        try {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String authorization = servletRequest.getHeader(tokenHeader);
            if (authorization != null) {
                Usuario usuario = JwtUtils.parseToken(authorization.replaceAll("Bearer ", ""));
                Authentication credentials =
                        new UsernamePasswordAuthenticationToken(usuario.getUsername(),
                                usuario.getPassword(), usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(credentials);
            }
            chain.doFilter(request, response);
        }
        catch(Throwable t) {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, t.getMessage());
        }
    }

}