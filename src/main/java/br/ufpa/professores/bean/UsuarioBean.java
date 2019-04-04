/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.ufpa.professores.entidade.Usuario;
import br.ufpa.professores.entidade.tipo.TipoPerfilUsuario;
import br.ufpa.professores.rn.UsuarioRN;
import br.ufpa.professores.util.UtilBean;

/**
 *
 * @author Fabio
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

	private List<Usuario> usuarios;

	private Usuario usuario = new Usuario();

	private final UsuarioRN USUARIO_RN = new UsuarioRN();

	/**
	 * Creates a new instance of UsuarioBean
	 */
	public UsuarioBean() {

	}

	@PostConstruct
	public void init() {

		this.usuarios = null;
	}

	public List<Usuario> getUsuarios() {

		return this.usuarios;
	}

	public void setUsuarios(final List<Usuario> usuarios) {

		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {

		return this.usuario;
	}

	public void setUsuario(final Usuario animal) {

		this.usuario = animal;
	}

	public Usuario getUsuarioLogado() {

		return UtilBean.obterUsuarioLogado();
	}

	public void logout() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
//        UtilBean.encerrarSessao();
	}

	public boolean isAdministrador() {

		final Usuario u = this.getUsuarioLogado();
		if (u != null) {
			final TipoPerfilUsuario perfil = TipoPerfilUsuario.obter(u.getPerfil());
			return perfil.isAdministrador();
		} else {
			return false;
		}
	}

	public boolean isProfessor() {

		final Usuario u = this.getUsuarioLogado();
		if (u != null) {
			final TipoPerfilUsuario perfil = TipoPerfilUsuario.obter(u.getPerfil());
			return perfil.isProfessor();
		} else {
			return false;
		}
	}

	public boolean isInstituto() {

		final Usuario u = this.getUsuarioLogado();
		if (u != null) {
			final TipoPerfilUsuario perfil = TipoPerfilUsuario.obter(u.getPerfil());
			return perfil.isInstituto();
		} else {
			return false;
		}
	}

	public String getPerfilDoUsuarioLogado() {

		final Usuario u = this.getUsuarioLogado();
		if (u != null) {
			final TipoPerfilUsuario Perfil = TipoPerfilUsuario.obter(u.getPerfil());
			return Perfil.getDescricao();
		}
		return null;
	}

	public void excluir() {

		if (this.USUARIO_RN.excluir(this.usuario)) {
			UtilBean.criarMensagemDeInformacao("Usuario excluído");
			this.usuarios = this.USUARIO_RN.listar();
		} else {
			UtilBean.criarMensagemDeErro("Não foi possível excluir o usuario");
		}
	}

	public void salvar() {

		if (this.USUARIO_RN.salvar(this.usuario)) {
			UtilBean.criarMensagemDeInformacao("Usuario salvo");
		} else {
			UtilBean.criarMensagemDeErro("Não foi possível salvar o usuario");
		}
	}

}
