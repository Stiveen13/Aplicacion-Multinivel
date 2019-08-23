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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juans
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findById", query = "SELECT p FROM Proyectos p WHERE p.id = :id")
    , @NamedQuery(name = "Proyectos.findByNombre", query = "SELECT p FROM Proyectos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyectos.findByAreaAplicacion", query = "SELECT p FROM Proyectos p WHERE p.areaAplicacion = :areaAplicacion")
    , @NamedQuery(name = "Proyectos.findByFechaIngreso", query = "SELECT p FROM Proyectos p WHERE p.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Proyectos.findByFechaAsignacion", query = "SELECT p FROM Proyectos p WHERE p.fechaAsignacion = :fechaAsignacion")
    , @NamedQuery(name = "Proyectos.findByFechaPrevistaLiberacion", query = "SELECT p FROM Proyectos p WHERE p.fechaPrevistaLiberacion = :fechaPrevistaLiberacion")
    , @NamedQuery(name = "Proyectos.findByFaseProyecto", query = "SELECT p FROM Proyectos p WHERE p.faseProyecto = :faseProyecto")
    , @NamedQuery(name = "Proyectos.findByFechaInicioAnalisis", query = "SELECT p FROM Proyectos p WHERE p.fechaInicioAnalisis = :fechaInicioAnalisis")
    , @NamedQuery(name = "Proyectos.findByFechaInicioDise\u00f1o", query = "SELECT p FROM Proyectos p WHERE p.fechaInicioDise\u00f1o = :fechaInicioDise\u00f1o")
    , @NamedQuery(name = "Proyectos.findByFechaInicioCodificacion", query = "SELECT p FROM Proyectos p WHERE p.fechaInicioCodificacion = :fechaInicioCodificacion")
    , @NamedQuery(name = "Proyectos.findByFechaInicioPruebas", query = "SELECT p FROM Proyectos p WHERE p.fechaInicioPruebas = :fechaInicioPruebas")
    , @NamedQuery(name = "Proyectos.findByVersionPrograma", query = "SELECT p FROM Proyectos p WHERE p.versionPrograma = :versionPrograma")
    , @NamedQuery(name = "Proyectos.findByCostoTotal", query = "SELECT p FROM Proyectos p WHERE p.costoTotal = :costoTotal")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "area_aplicacion")
    private String areaAplicacion;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Column(name = "fecha_prevista_liberacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPrevistaLiberacion;
    @Size(max = 45)
    @Column(name = "fase_proyecto")
    private String faseProyecto;
    @Column(name = "fecha_inicio_analisis")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioAnalisis;
    @Column(name = "fecha_inicio_dise\u00f1o")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioDiseño;
    @Column(name = "fecha_inicio_codificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioCodificacion;
    @Column(name = "fecha_inicio_pruebas")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioPruebas;
    @Size(max = 45)
    @Column(name = "version_programa")
    private String versionPrograma;
    @Column(name = "costo_total")
    private Integer costoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectosId")
    private List<CompatibilidadProyecto> compatibilidadProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectosId")
    private List<GruposTrabajo> gruposTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectosId")
    private List<RequisitosProyecto> requisitosProyectoList;

    public Proyectos() {
    }

    public Proyectos(Integer id) {
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

    public String getAreaAplicacion() {
        return areaAplicacion;
    }

    public void setAreaAplicacion(String areaAplicacion) {
        this.areaAplicacion = areaAplicacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaPrevistaLiberacion() {
        return fechaPrevistaLiberacion;
    }

    public void setFechaPrevistaLiberacion(Date fechaPrevistaLiberacion) {
        this.fechaPrevistaLiberacion = fechaPrevistaLiberacion;
    }

    public String getFaseProyecto() {
        return faseProyecto;
    }

    public void setFaseProyecto(String faseProyecto) {
        this.faseProyecto = faseProyecto;
    }

    public Date getFechaInicioAnalisis() {
        return fechaInicioAnalisis;
    }

    public void setFechaInicioAnalisis(Date fechaInicioAnalisis) {
        this.fechaInicioAnalisis = fechaInicioAnalisis;
    }

    public Date getFechaInicioDiseño() {
        return fechaInicioDiseño;
    }

    public void setFechaInicioDiseño(Date fechaInicioDiseño) {
        this.fechaInicioDiseño = fechaInicioDiseño;
    }

    public Date getFechaInicioCodificacion() {
        return fechaInicioCodificacion;
    }

    public void setFechaInicioCodificacion(Date fechaInicioCodificacion) {
        this.fechaInicioCodificacion = fechaInicioCodificacion;
    }

    public Date getFechaInicioPruebas() {
        return fechaInicioPruebas;
    }

    public void setFechaInicioPruebas(Date fechaInicioPruebas) {
        this.fechaInicioPruebas = fechaInicioPruebas;
    }

    public String getVersionPrograma() {
        return versionPrograma;
    }

    public void setVersionPrograma(String versionPrograma) {
        this.versionPrograma = versionPrograma;
    }

    public Integer getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Integer costoTotal) {
        this.costoTotal = costoTotal;
    }

    @XmlTransient
    public List<CompatibilidadProyecto> getCompatibilidadProyectoList() {
        return compatibilidadProyectoList;
    }

    public void setCompatibilidadProyectoList(List<CompatibilidadProyecto> compatibilidadProyectoList) {
        this.compatibilidadProyectoList = compatibilidadProyectoList;
    }

    @XmlTransient
    public List<GruposTrabajo> getGruposTrabajoList() {
        return gruposTrabajoList;
    }

    public void setGruposTrabajoList(List<GruposTrabajo> gruposTrabajoList) {
        this.gruposTrabajoList = gruposTrabajoList;
    }

    @XmlTransient
    public List<RequisitosProyecto> getRequisitosProyectoList() {
        return requisitosProyectoList;
    }

    public void setRequisitosProyectoList(List<RequisitosProyecto> requisitosProyectoList) {
        this.requisitosProyectoList = requisitosProyectoList;
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
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectos[ id=" + id + " ]";
    }
    
}
