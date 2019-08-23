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
@Table(name = "ingenieros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingenieros.findAll", query = "SELECT i FROM Ingenieros i")
    , @NamedQuery(name = "Ingenieros.findByCedula", query = "SELECT i FROM Ingenieros i WHERE i.cedula = :cedula")
    , @NamedQuery(name = "Ingenieros.findByNombres", query = "SELECT i FROM Ingenieros i WHERE i.nombres = :nombres")
    , @NamedQuery(name = "Ingenieros.findByApellidos", query = "SELECT i FROM Ingenieros i WHERE i.apellidos = :apellidos")
    , @NamedQuery(name = "Ingenieros.findByEmail", query = "SELECT i FROM Ingenieros i WHERE i.email = :email")
    , @NamedQuery(name = "Ingenieros.findByTelefonoFijo", query = "SELECT i FROM Ingenieros i WHERE i.telefonoFijo = :telefonoFijo")
    , @NamedQuery(name = "Ingenieros.findByTelefonoMovil", query = "SELECT i FROM Ingenieros i WHERE i.telefonoMovil = :telefonoMovil")
    , @NamedQuery(name = "Ingenieros.findByDireccion", query = "SELECT i FROM Ingenieros i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Ingenieros.findByFechaNacimiento", query = "SELECT i FROM Ingenieros i WHERE i.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Ingenieros.findByEdad", query = "SELECT i FROM Ingenieros i WHERE i.edad = :edad")
    , @NamedQuery(name = "Ingenieros.findBySexo", query = "SELECT i FROM Ingenieros i WHERE i.sexo = :sexo")
    , @NamedQuery(name = "Ingenieros.findByFechaIngreso", query = "SELECT i FROM Ingenieros i WHERE i.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Ingenieros.findByClase", query = "SELECT i FROM Ingenieros i WHERE i.clase = :clase")})
public class Ingenieros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Size(max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Size(max = 45)
    @Column(name = "telefono_movil")
    private String telefonoMovil;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "clase")
    private Integer clase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenierosCedula")
    private List<IngenierosJefe> ingenierosJefeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenierosCedula")
    private List<GruposTrabajo> gruposTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenierosCedula")
    private List<SeminariosAsistidos> seminariosAsistidosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenierosCedula")
    private List<Conocimientos> conocimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenierosCedula")
    private List<TitulosAcademicos> titulosAcademicosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenierosCedula")
    private List<IngenierosJunior> ingenierosJuniorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenierosCedula")
    private List<IngenierosSenior> ingenierosSeniorList;

    public Ingenieros() {
    }

    public Ingenieros(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getClase() {
        return clase;
    }

    public void setClase(Integer clase) {
        this.clase = clase;
    }

    @XmlTransient
    public List<IngenierosJefe> getIngenierosJefeList() {
        return ingenierosJefeList;
    }

    public void setIngenierosJefeList(List<IngenierosJefe> ingenierosJefeList) {
        this.ingenierosJefeList = ingenierosJefeList;
    }

    @XmlTransient
    public List<GruposTrabajo> getGruposTrabajoList() {
        return gruposTrabajoList;
    }

    public void setGruposTrabajoList(List<GruposTrabajo> gruposTrabajoList) {
        this.gruposTrabajoList = gruposTrabajoList;
    }

    @XmlTransient
    public List<SeminariosAsistidos> getSeminariosAsistidosList() {
        return seminariosAsistidosList;
    }

    public void setSeminariosAsistidosList(List<SeminariosAsistidos> seminariosAsistidosList) {
        this.seminariosAsistidosList = seminariosAsistidosList;
    }

    @XmlTransient
    public List<Conocimientos> getConocimientosList() {
        return conocimientosList;
    }

    public void setConocimientosList(List<Conocimientos> conocimientosList) {
        this.conocimientosList = conocimientosList;
    }

    @XmlTransient
    public List<TitulosAcademicos> getTitulosAcademicosList() {
        return titulosAcademicosList;
    }

    public void setTitulosAcademicosList(List<TitulosAcademicos> titulosAcademicosList) {
        this.titulosAcademicosList = titulosAcademicosList;
    }

    @XmlTransient
    public List<IngenierosJunior> getIngenierosJuniorList() {
        return ingenierosJuniorList;
    }

    public void setIngenierosJuniorList(List<IngenierosJunior> ingenierosJuniorList) {
        this.ingenierosJuniorList = ingenierosJuniorList;
    }

    @XmlTransient
    public List<IngenierosSenior> getIngenierosSeniorList() {
        return ingenierosSeniorList;
    }

    public void setIngenierosSeniorList(List<IngenierosSenior> ingenierosSeniorList) {
        this.ingenierosSeniorList = ingenierosSeniorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingenieros)) {
            return false;
        }
        Ingenieros other = (Ingenieros) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingenieros[ cedula=" + cedula + " ]";
    }
    
}
