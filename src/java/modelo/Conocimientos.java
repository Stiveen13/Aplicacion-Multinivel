/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juans
 */
@Entity
@Table(name = "conocimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conocimientos.findAll", query = "SELECT c FROM Conocimientos c")
    , @NamedQuery(name = "Conocimientos.findById", query = "SELECT c FROM Conocimientos c WHERE c.id = :id")})
public class Conocimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "herramientas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Herramientas herramientasId;
    @JoinColumn(name = "ingenieros_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Ingenieros ingenierosCedula;

    public Conocimientos() {
    }

    public Conocimientos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Herramientas getHerramientasId() {
        return herramientasId;
    }

    public void setHerramientasId(Herramientas herramientasId) {
        this.herramientasId = herramientasId;
    }

    public Ingenieros getIngenierosCedula() {
        return ingenierosCedula;
    }

    public void setIngenierosCedula(Ingenieros ingenierosCedula) {
        this.ingenierosCedula = ingenierosCedula;
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
        if (!(object instanceof Conocimientos)) {
            return false;
        }
        Conocimientos other = (Conocimientos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Conocimientos[ id=" + id + " ]";
    }
    
}
