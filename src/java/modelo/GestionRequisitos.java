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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juans
 */
@Entity
@Table(name = "gestion_requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionRequisitos.findAll", query = "SELECT g FROM GestionRequisitos g")
    , @NamedQuery(name = "GestionRequisitos.findByNumeroSolicitud", query = "SELECT g FROM GestionRequisitos g WHERE g.numeroSolicitud = :numeroSolicitud")
    , @NamedQuery(name = "GestionRequisitos.findByTipoSolicitud", query = "SELECT g FROM GestionRequisitos g WHERE g.tipoSolicitud = :tipoSolicitud")
    , @NamedQuery(name = "GestionRequisitos.findByTitulo", query = "SELECT g FROM GestionRequisitos g WHERE g.titulo = :titulo")
    , @NamedQuery(name = "GestionRequisitos.findByFecha", query = "SELECT g FROM GestionRequisitos g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "GestionRequisitos.findBySolicitante", query = "SELECT g FROM GestionRequisitos g WHERE g.solicitante = :solicitante")
    , @NamedQuery(name = "GestionRequisitos.findByOrigen", query = "SELECT g FROM GestionRequisitos g WHERE g.origen = :origen")
    , @NamedQuery(name = "GestionRequisitos.findByEstado", query = "SELECT g FROM GestionRequisitos g WHERE g.estado = :estado")
    , @NamedQuery(name = "GestionRequisitos.findByProridadSolicitante", query = "SELECT g FROM GestionRequisitos g WHERE g.proridadSolicitante = :proridadSolicitante")
    , @NamedQuery(name = "GestionRequisitos.findByPrioridadRealizacion", query = "SELECT g FROM GestionRequisitos g WHERE g.prioridadRealizacion = :prioridadRealizacion")
    , @NamedQuery(name = "GestionRequisitos.findByVerificador", query = "SELECT g FROM GestionRequisitos g WHERE g.verificador = :verificador")
    , @NamedQuery(name = "GestionRequisitos.findByFechaUltimaActualizacion", query = "SELECT g FROM GestionRequisitos g WHERE g.fechaUltimaActualizacion = :fechaUltimaActualizacion")
    , @NamedQuery(name = "GestionRequisitos.findByRelease", query = "SELECT g FROM GestionRequisitos g WHERE g.release = :release")})
public class GestionRequisitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_solicitud")
    private Integer numeroSolicitud;
    @Size(max = 45)
    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "solicitante")
    private String solicitante;
    @Size(max = 45)
    @Column(name = "origen")
    private String origen;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "proridad_solicitante")
    private String proridadSolicitante;
    @Size(max = 45)
    @Column(name = "prioridad_realizacion")
    private String prioridadRealizacion;
    @Size(max = 45)
    @Column(name = "verificador")
    private String verificador;
    @Column(name = "fecha_ultima_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaActualizacion;
    @Size(max = 45)
    @Column(name = "release")
    private String release;
    @Lob
    @Size(max = 65535)
    @Column(name = "esfuerzo")
    private String esfuerzo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Size(max = 65535)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "requisitos_proyecto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequisitosProyecto requisitosProyectoId;

    public GestionRequisitos() {
    }

    public GestionRequisitos(Integer numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public Integer getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(Integer numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProridadSolicitante() {
        return proridadSolicitante;
    }

    public void setProridadSolicitante(String proridadSolicitante) {
        this.proridadSolicitante = proridadSolicitante;
    }

    public String getPrioridadRealizacion() {
        return prioridadRealizacion;
    }

    public void setPrioridadRealizacion(String prioridadRealizacion) {
        this.prioridadRealizacion = prioridadRealizacion;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getEsfuerzo() {
        return esfuerzo;
    }

    public void setEsfuerzo(String esfuerzo) {
        this.esfuerzo = esfuerzo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public RequisitosProyecto getRequisitosProyectoId() {
        return requisitosProyectoId;
    }

    public void setRequisitosProyectoId(RequisitosProyecto requisitosProyectoId) {
        this.requisitosProyectoId = requisitosProyectoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroSolicitud != null ? numeroSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionRequisitos)) {
            return false;
        }
        GestionRequisitos other = (GestionRequisitos) object;
        if ((this.numeroSolicitud == null && other.numeroSolicitud != null) || (this.numeroSolicitud != null && !this.numeroSolicitud.equals(other.numeroSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GestionRequisitos[ numeroSolicitud=" + numeroSolicitud + " ]";
    }
    
}
