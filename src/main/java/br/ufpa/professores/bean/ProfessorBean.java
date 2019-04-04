package br.ufpa.professores.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ufpa.professores.entidade.Professor;
import br.ufpa.professores.rn.ProfessorRN;

/**
 *
 * @author reisalvaro
 */

@ManagedBean
@ViewScoped
public class ProfessorBean implements Serializable {

    private static final long serialVersionUID = 2449219379955991470L;

    private List<Professor> professores;

    private Professor professor;

    private final ProfessorRN PROFESSOR_RN = new ProfessorRN();

    @PostConstruct
    public void inicializar() {

        this.professores = this.PROFESSOR_RN.listar();
    }

    public void preparar() {

        if (this.professor == null) {
            this.professor = new Professor();
        } else {
            this.professor = null;
        }
    }

    public void salvar() {

        final FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (this.PROFESSOR_RN.salvar(this.professor)) {
            final FacesMessage fm = new FacesMessage("Sucesso", "Professor salvo");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            this.professor = null;
            this.professores = this.PROFESSOR_RN.listar();
        } else {
            final FacesMessage fm = new FacesMessage("Erro", "Não foi possível salvar o Professor");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public void excluir() {

        final FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (this.PROFESSOR_RN.excluir(this.professor)) {
            final FacesMessage fm = new FacesMessage("Sucesso", "Professor excluído");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            this.professor = null;
            this.professores = this.PROFESSOR_RN.listar();
        } else {
            final FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir o Professor");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    /**
     * @return the professores
     */
    public List<Professor> getProfessores() {

        return this.professores;
    }

    /**
     * @param professores
     *            the professores to set
     */
    public void setProfessores(final List<Professor> professores) {

        this.professores = professores;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {

        return this.professor;
    }

    /**
     * @param professor
     *            the professor to set
     */
    public void setProfessor(final Professor professor) {

        this.professor = professor;
    }

}
