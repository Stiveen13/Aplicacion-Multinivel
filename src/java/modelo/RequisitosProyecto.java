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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "requisitos_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitosProyecto.findAll", query = "SELECT r FROM RequisitosProyecto r")
    , @NamedQuery(name = "RequisitosProyecto.findById", query = "SELECT r FROM RequisitosProyecto r WHERE r.id = :id")
    , @NamedQuery(name = "RequisitosProyecto.findByTipo", query = "SELECT r FROM RequisitosProyecto r WHERE r.tipo = :tipo")
    , @NamedQuery(name = "RequisitosProyecto.findByDescripcion", query = "SELECT r FROM RequisitosProyecto r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "RequisitosProyecto.findByEstado", query = "SELECT r FROM RequisitosProyecto r WHERE r.estado = :estado")})
public class RequisitosProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitosProyectoId")
    private List<GestionRequisitos> gestionRequisitosList;
    @JoinColumn(name = "proyectos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proyectos proyectosId;

    public RequisitosProyecto() {
    }

    public RequisitosProyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<GestionRequisitos> getGestionRequisitosList() {
        return gestionRequisitosList;
    }

    public void setGestionRequisitosList(List<GestionRequisitos> gestionRequisitosList) {
        this.gestionRequisitosList = gestionRequisitosList;
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
        if (!(object instanceof RequisitosProyecto)) {
            return false;
        }
        RequisitosProyecto other = (RequisitosProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RequisitosProyecto[ id=" + id + " ]";
    }
    
}
