/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.professores.entidade;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author reisalvaro
 */
@Entity
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
                @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
                @NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.id = :id"),
                @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome"),
                @NamedQuery(name = "Professor.findByTitulacao", query = "SELECT p FROM Professor p WHERE p.titulacao = :titulacao") })
public class Professor implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "titulacao")
    private String titulacao;

    @JoinColumn(name = "id_instituto", referencedColumnName = "id")
    @ManyToOne
    private Instituto instituto;

    public Professor() {

    }

    public Professor(final Integer id) {

        this.id = id;
    }

    public Professor(final Integer id, final String nome, final String titulacao) {

        this.id = id;
        this.nome = nome;
        this.titulacao = titulacao;
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

    public String getTitulacao() {

        return this.titulacao;
    }

    public void setTitulacao(final String titulacao) {

        this.titulacao = titulacao;
    }

    public Instituto getInstituto() {

        return this.instituto;
    }

    public void setInstituto(final Instituto instituto) {

        this.instituto = instituto;
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
        if (!(object instanceof Professor)) {
            return false;
        }
        final Professor other = (Professor) object;
        if (((this.id == null) && (other.id != null)) || ((this.id != null) && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "br.ufpa.professores.entidade.Professor[ id=" + this.id + " ]";
    }

}
