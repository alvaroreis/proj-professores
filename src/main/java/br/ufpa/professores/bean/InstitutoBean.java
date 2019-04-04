package br.ufpa.professores.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ufpa.professores.entidade.Instituto;
import br.ufpa.professores.rn.InstitutoRN;

/**
 *
 * @author reisalvaro
 */
@ManagedBean
@ViewScoped
public class InstitutoBean implements Serializable {

    private static final long serialVersionUID = 2478752972799702083L;

    private List<Instituto> institutos;

    private Instituto instituto;

    private final InstitutoRN INSTITUTO_RN = new InstitutoRN();

    @PostConstruct
    public void inicializar() {

        this.institutos = this.INSTITUTO_RN.listar();
    }

    public void preparar() {

        if (this.instituto == null) {
            this.instituto = new Instituto();
        } else {
            this.instituto = null;
        }
    }

    public void salvar() {

        final FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (this.INSTITUTO_RN.salvar(this.instituto)) {
            final FacesMessage fm = new FacesMessage("Sucesso", "Instituto salvo");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            this.instituto = null;
            this.institutos = this.INSTITUTO_RN.listar();
        } else {
            final FacesMessage fm = new FacesMessage("Erro", "Não foi possível salvar o Instituto");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public void excluir() {

        final FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (this.INSTITUTO_RN.excluir(this.instituto)) {
            final FacesMessage fm = new FacesMessage("Sucesso", "Instituto excluído");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            this.instituto = null;
            this.institutos = this.INSTITUTO_RN.listar();
        } else {
            final FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir o Instituto");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public List<Instituto> getInstitutos() {

        return this.institutos;
    }

    public void setInstitutos(final List<Instituto> institutos) {

        this.institutos = institutos;
    }

    public Instituto getInstituto() {

        return this.instituto;
    }

    public void setInstituto(final Instituto instituto) {

        this.instituto = instituto;
    }

}
