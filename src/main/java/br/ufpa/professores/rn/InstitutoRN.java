/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.rn;

import br.ufpa.professores.dao.GenericDAO;
import br.ufpa.professores.entidade.Instituto;
import java.util.List;

/**
 *
 * @author reisalvaro
 */
public class InstitutoRN {

    private final GenericDAO<Instituto> INSTITUTO_DAO = new GenericDAO<>();

      public boolean salvar(Instituto instituto) {
        if (instituto == null
                || instituto.getNome().isEmpty() || instituto.getSigla().isEmpty()) {
            return false;
        } else {
            if (instituto.getId() == null || instituto.getId() == 0) {
                return INSTITUTO_DAO.criar(instituto);
            } else {
                return INSTITUTO_DAO.alterar(instituto);
            }
        }
    }

    public List<Instituto> listar() {
        return INSTITUTO_DAO.obterTodos(Instituto.class);
    }

    public Instituto obter(Integer id) {
        return INSTITUTO_DAO.obter(Instituto.class, id);
    }

    public boolean excluir(Instituto instituto) {
        if (instituto == null) {
            return false;
        } else {
            return INSTITUTO_DAO.excluir(instituto);
        }
    }
}
