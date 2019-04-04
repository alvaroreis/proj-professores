/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author reisalvaro
 */
@Entity
@Table(name = "instituto")
@XmlRootElement
@NamedQueries({
                @NamedQuery(name = "Instituto.findAll", query = "SELECT i FROM Instituto i"),
                @NamedQuery(name = "Instituto.findById", query = "SELECT i FROM Instituto i WHERE i.id = :id"),
                @NamedQuery(name = "Instituto.findByNome", query = "SELECT i FROM Instituto i WHERE i.nome = :nome"),
                @NamedQuery(name = "Instituto.findBySigla", query = "SELECT i FROM Instituto i WHERE i.sigla = :sigla") })
public class Instituto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "sigla")
    private String sigla;

    @OneToMany(mappedBy = "instituto")
    private Collection<Professor> professorCollection;

    public Instituto() {

    }

    public Instituto(final Integer id) {

        this.id = id;
    }

    public Instituto(final Integer id, final String nome, final String sigla) {

        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getId() {

        return this.id;
    }

    public void setId(final Integer id) {

        this.id = id;
    }

    public String getNome() {

        return this.nome;
    }

    public void setNome(final String nome) {

        this.nome = nome;
    }

    public String getSigla() {

        return this.sigla;
    }

    public void setSigla(final String sigla) {

        this.sigla = sigla;
    }

    @XmlTransient
    public Collection<Professor> getProfessorCollection() {

        return this.professorCollection;
    }

    public void setProfessorCollection(final Collection<Professor> professorCollection) {

        this.professorCollection = professorCollection;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituto)) {
            return false;
        }
        final Instituto other = (Instituto) object;
        if (((this.id == null) && (other.id != null)) || ((this.id != null) && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "br.ufpa.professores.entidade.Instituto[ id=" + this.id + " ]";
    }

}
