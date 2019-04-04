/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.entidade.seguranca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import br.ufpa.professores.entidade.Usuario;
import br.ufpa.professores.entidade.tipo.TipoPerfilUsuario;
import br.ufpa.professores.rn.UsuarioRN;

/**
 *
 * @author Fabio
 */
public class LoginHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UsuarioRN RN = new UsuarioRN();

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication a)
                    throws IOException, ServletException {

        final String username = a.getName();
        final Usuario usuario = this.RN.obter(username);
        String pagina = "/index.xhtml";
        if (usuario.getPerfil() == 'P') {
            pagina = "/professor/professores.xhtml";
            this.setDefaultTargetUrl(pagina);
        } else if ((usuario.getPerfil() == 'A') || (usuario.getPerfil() == 'I')) {
            pagina = "/instituto/institutos.xhtml";
            this.setDefaultTargetUrl(pagina);
        }
        super.onAuthenticationSuccess(request, response, a);
    }

}
