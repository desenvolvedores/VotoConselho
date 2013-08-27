/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleitor;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jenny
 */
@Entity
@Table(name = "eleitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eleitor.findAll", query = "SELECT e FROM Eleitor e"),
    @NamedQuery(name = "Eleitor.findById", query = "SELECT e FROM Eleitor e WHERE e.id = :id"),
    @NamedQuery(name = "Eleitor.findBySala", query = "SELECT e FROM Eleitor e WHERE e.sala = :sala"),
    @NamedQuery(name = "Eleitor.findByNome", query = "SELECT e FROM Eleitor e WHERE e.nome = :nome"),
    @NamedQuery(name = "Eleitor.findByTitulo", query = "SELECT e FROM Eleitor e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "Eleitor.findByRg", query = "SELECT e FROM Eleitor e WHERE e.rg = :rg"),
    @NamedQuery(name = "Eleitor.findByCpf", query = "SELECT e FROM Eleitor e WHERE e.cpf = :cpf")})

public class Eleitor implements Serializable {
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sala")
    private String sala;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;

    public Eleitor() {
    }

    public Eleitor(Integer id) {
        this.id = id;
    }

    public Eleitor(Integer id, String sala, String nome, String titulo) {
        this.id = id;
        this.sala = sala;
        this.nome = nome;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleitor)) {
            return false;
        }
        Eleitor other = (Eleitor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Eleitor[ id=" + id + " ]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
