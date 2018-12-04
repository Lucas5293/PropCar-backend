package br.gov.sp.fatec.modelo;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="OBJ_AUTORIZACAO")
public class Autorizacao implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AT_ID")
    private Long id;

    @Column(name = "AT_NOME")
    private String nome;

    // Desserialization bug
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return this.getNome();
    }
}
