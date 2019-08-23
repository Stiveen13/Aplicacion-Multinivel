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
@Table(name = "ingenieros_junior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngenierosJunior.findAll", query = "SELECT i FROM IngenierosJunior i")
    , @NamedQuery(name = "IngenierosJunior.findById", query = "SELECT i FROM IngenierosJunior i WHERE i.id = :id")
    , @NamedQuery(name = "IngenierosJunior.findByHorasDia", query = "SELECT i FROM IngenierosJunior i WHERE i.horasDia = :horasDia")})
public class IngenierosJunior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "horas_dia")
    private Integer horasDia;
    @JoinColumn(name = "ingenieros_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Ingenieros ingenierosCedula;

    public IngenierosJunior() {
    }

    public IngenierosJunior(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(Integer horasDia) {
        this.horasDia = horasDia;
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
        if (!(object instanceof IngenierosJunior)) {
            return false;
        }
        IngenierosJunior other = (IngenierosJunior) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngenierosJunior[ id=" + id + " ]";
    }
    
}
