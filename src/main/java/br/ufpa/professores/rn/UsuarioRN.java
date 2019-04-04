package br.ufpa.professores.rn;

import br.ufpa.professores.dao.UsuarioDAO;
import br.ufpa.professores.entidade.Usuario;
import java.util.List;

public class UsuarioRN {

    private final UsuarioDAO DAO = new UsuarioDAO();

    public boolean salvar(Usuario usuario) {
        if (usuario == null) {
            return false;
        } else {
            if (usuario.getId() == null || usuario.getId() == 0) {
                return DAO.criar(usuario);
            } else {
                return DAO.alterar(usuario);
            }
        }
    }

    public List<Usuario> listar() {
        return DAO.obterTodos(Usuario.class);
    }

    public Usuario obter(Integer id) {
        return DAO.obter(Usuario.class, id);
    }

    public boolean excluir(Usuario usuario) {
        if (usuario == null) {
            return false;
        } else {
            return DAO.excluir(usuario);
        }
    }

    public Usuario login(String usuario, String senha) {
        return DAO.login(usuario, senha);
    }

    public Usuario obter(String emailOuCelular) {
        return DAO.obter(emailOuCelular);
    }
}
