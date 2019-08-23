/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juans
 */
@Entity
@Table(name = "seminarios_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeminariosCursos.findAll", query = "SELECT s FROM SeminariosCursos s")
    , @NamedQuery(name = "SeminariosCursos.findById", query = "SELECT s FROM SeminariosCursos s WHERE s.id = :id")
    , @NamedQuery(name = "SeminariosCursos.findByNombre", query = "SELECT s FROM SeminariosCursos s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SeminariosCursos.findByLugar", query = "SELECT s FROM SeminariosCursos s WHERE s.lugar = :lugar")
    , @NamedQuery(name = "SeminariosCursos.findByFechaInicio", query = "SELECT s FROM SeminariosCursos s WHERE s.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "SeminariosCursos.findByFechaFinalizacion", query = "SELECT s FROM SeminariosCursos s WHERE s.fechaFinalizacion = :fechaFinalizacion")})
public class SeminariosCursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seminariosCursosId")
    private List<SeminariosAsistidos> seminariosAsistidosList;

    public SeminariosCursos() {
    }

    public SeminariosCursos(Integer id) {
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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

    @XmlTransient
    public List<SeminariosAsistidos> getSeminariosAsistidosList() {
        return seminariosAsistidosList;
    }

    public void setSeminariosAsistidosList(List<SeminariosAsistidos> seminariosAsistidosList) {
        this.seminariosAsistidosList = seminariosAsistidosList;
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
        if (!(object instanceof SeminariosCursos)) {
            return false;
        }
        SeminariosCursos other = (SeminariosCursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeminariosCursos[ id=" + id + " ]";
    }
    
}
