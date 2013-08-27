/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Candidato;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jenny
 */
@Entity
@Table(name = "candidatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidatos.findAll", query = "SELECT c FROM Candidatos c"),
    @NamedQuery(name = "Candidatos.findById", query = "SELECT c FROM Candidatos c WHERE c.id = :id"),
    @NamedQuery(name = "Candidatos.findByNome", query = "SELECT c FROM Candidatos c WHERE c.nome = :nome"),
    @NamedQuery(name = "Candidatos.findByApelido", query = "SELECT c FROM Candidatos c WHERE c.apelido = :apelido")})
public class Candidatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "apelido")
    private String apelido;

    public Candidatos() {
    }

    public Candidatos(Integer id) {
        this.id = id;
    }

    public Candidatos(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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
        if (!(object instanceof Candidatos)) {
            return false;
        }
        Candidatos other = (Candidatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Candidatos[ id=" + id + " ]";
    }
    
}
