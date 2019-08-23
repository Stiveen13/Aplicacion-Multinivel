/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juans
 */
@Entity
@Table(name = "grupos_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruposTrabajo.findAll", query = "SELECT g FROM GruposTrabajo g")
    , @NamedQuery(name = "GruposTrabajo.findById", query = "SELECT g FROM GruposTrabajo g WHERE g.id = :id")
    , @NamedQuery(name = "GruposTrabajo.findByFechaInicio", query = "SELECT g FROM GruposTrabajo g WHERE g.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "GruposTrabajo.findByFechaFinalizacion", query = "SELECT g FROM GruposTrabajo g WHERE g.fechaFinalizacion = :fechaFinalizacion")})
public class GruposTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @JoinColumn(name = "ingenieros_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Ingenieros ingenierosCedula;
    @JoinColumn(name = "proyectos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proyectos proyectosId;

    public GruposTrabajo() {
    }

    public GruposTrabajo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Ingenieros getIngenierosCedula() {
        return ingenierosCedula;
    }

    public void setIngenierosCedula(Ingenieros ingenierosCedula) {
        this.ingenierosCedula = ingenierosCedula;
    }

    public Proyectos getProyectosId() {
        return proyectosId;
    }

    public void setProyectosId(Proyectos proyectosId) {
        this.proyectosId = proyectosId;
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
        if (!(object instanceof GruposTrabajo)) {
            return false;
        }
        GruposTrabajo other = (GruposTrabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GruposTrabajo[ id=" + id + " ]";
    }
    
}
