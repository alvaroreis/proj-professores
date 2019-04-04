/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.rn;

import br.ufpa.professores.dao.GenericDAO;
import br.ufpa.professores.entidade.Professor;
import java.util.List;

/**
 *
 * @author reisalvaro
 */
public class ProfessorRN {

    private final GenericDAO<Professor> PROFESSOR_DAO = new GenericDAO<>();

    public boolean salvar(Professor entidade) {
        if (entidade == null
                || entidade.getNome().isEmpty() || entidade.getTitulacao().isEmpty() || entidade.getInstituto() == null) {
            return false;
        } else {
            if (entidade.getId() == null || entidade.getId() == 0) {
                return PROFESSOR_DAO.criar(entidade);
            } else {
                return PROFESSOR_DAO.alterar(entidade);
            }
        }
    }

    public List<Professor> listar() {
        return PROFESSOR_DAO.obterTodos(Professor.class);
    }

    public Professor obter(Integer id) {
        return PROFESSOR_DAO.obter(Professor.class, id);
    }

    public boolean excluir(Professor entidade) {
        if (entidade == null) {
            return false;
        } else {
            return PROFESSOR_DAO.excluir(entidade);
        }
    }

}
