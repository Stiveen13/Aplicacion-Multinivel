/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juans
 */
@Entity
@Table(name = "herramientas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Herramientas.findAll", query = "SELECT h FROM Herramientas h")
    , @NamedQuery(name = "Herramientas.findById", query = "SELECT h FROM Herramientas h WHERE h.id = :id")
    , @NamedQuery(name = "Herramientas.findByNombre", query = "SELECT h FROM Herramientas h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Herramientas.findByTipo", query = "SELECT h FROM Herramientas h WHERE h.tipo = :tipo")})
public class Herramientas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private Integer tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "herramientasId")
    private List<CompatibilidadProyecto> compatibilidadProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "herramientasId")
    private List<Conocimientos> conocimientosList;

    public Herramientas() {
    }

    public Herramientas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<CompatibilidadProyecto> getCompatibilidadProyectoList() {
        return compatibilidadProyectoList;
    }

    public void setCompatibilidadProyectoList(List<CompatibilidadProyecto> compatibilidadProyectoList) {
        this.compatibilidadProyectoList = compatibilidadProyectoList;
    }

    @XmlTransient
    public List<Conocimientos> getConocimientosList() {
        return conocimientosList;
    }

    public void setConocimientosList(List<Conocimientos> conocimientosList) {
        this.conocimientosList = conocimientosList;
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
        if (!(object instanceof Herramientas)) {
            return false;
        }
        Herramientas other = (Herramientas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Herramientas[ id=" + id + " ]";
    }
    
}
