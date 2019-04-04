/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.entidade.seguranca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import br.ufpa.professores.entidade.Usuario;
import br.ufpa.professores.rn.UsuarioRN;

/**
 *
 * @author Fabio
 */
public class AuthenticationHandler implements AuthenticationProvider {

    @Override
    public Authentication authenticate(final Authentication a) throws AuthenticationException {

        final String login = a.getName();
        final String senha = a.getCredentials().toString();
        final ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
        final String senhaCripto = sha.encodePassword(senha, null);
        final UsuarioRN RN = new UsuarioRN();
        final Usuario user = RN.login(login, senhaCripto);
        if (user != null) {
            final GrantedAuthorityImpl ga = new GrantedAuthorityImpl("ROLE_" + user.getPerfil());
            final List<GrantedAuthority> auts = new ArrayList<>();
            auts.add(ga);
            return new UsernamePasswordAuthenticationToken(login, senha, auts);
        } else {
            throw new BadCredentialsException("Email, celular ou senha inválidos");
        }
    }

    @Override
    public boolean supports(final Class<? extends Object> type) {

        return true;
    }

}
