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
@Table(name = "titulos_academicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TitulosAcademicos.findAll", query = "SELECT t FROM TitulosAcademicos t")
    , @NamedQuery(name = "TitulosAcademicos.findByIdTitulo", query = "SELECT t FROM TitulosAcademicos t WHERE t.idTitulo = :idTitulo")
    , @NamedQuery(name = "TitulosAcademicos.findByTituloObtenido", query = "SELECT t FROM TitulosAcademicos t WHERE t.tituloObtenido = :tituloObtenido")
    , @NamedQuery(name = "TitulosAcademicos.findByInstitucion", query = "SELECT t FROM TitulosAcademicos t WHERE t.institucion = :institucion")
    , @NamedQuery(name = "TitulosAcademicos.findByFechaObtencion", query = "SELECT t FROM TitulosAcademicos t WHERE t.fechaObtencion = :fechaObtencion")})
public class TitulosAcademicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_titulo")
    private Integer idTitulo;
    @Size(max = 45)
    @Column(name = "titulo_obtenido")
    private String tituloObtenido;
    @Size(max = 45)
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "fecha_obtencion")
    @Temporal(TemporalType.DATE)
    private Date fechaObtencion;
    @JoinColumn(name = "ingenieros_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Ingenieros ingenierosCedula;

    public TitulosAcademicos() {
    }

    public TitulosAcademicos(Integer idTitulo) {
        this.idTitulo = idTitulo;
    }

    public Integer getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(Integer idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(Date fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
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
        hash += (idTitulo != null ? idTitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TitulosAcademicos)) {
            return false;
        }
        TitulosAcademicos other = (TitulosAcademicos) object;
        if ((this.idTitulo == null && other.idTitulo != null) || (this.idTitulo != null && !this.idTitulo.equals(other.idTitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TitulosAcademicos[ idTitulo=" + idTitulo + " ]";
    }
    
}
