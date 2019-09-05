/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Date;
import javax.ejb.EJB;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.HerramientasLogicaLocal;
import logica.SeminariosCursosLogicaLocal;
import modelo.Herramientas;
import modelo.SeminariosCursos;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Juans
 */
@Named(value = "personalConfiguracionVista")
@RequestScoped
public class PersonalConfiguracionVista {

    /**
     * Creates a new instance of PersonalConfiguracionVista
     */
    public PersonalConfiguracionVista() {
    }

    @EJB
    private SeminariosCursosLogicaLocal seminariosCursosLogica;

    @EJB
    private HerramientasLogicaLocal herramientasLogica;

    /**
     * Variables para gestionar los datos de la tabla seminarios y cursos
     */
    private List<SeminariosCursos> listaSeminariosCursos;
    private SeminariosCursos seminariosCursosSelect;
    /**
     * Variables Prime para obtener los datos digitados por el usuario
     */
    private InputText txtNombreSeminario;
    private InputText txtLugar;
    private Calendar fechaIngreso;
    private Calendar fechaFinalizacion;

    /** ================================================================= */
    
    /**
     * Variables para gestionar los datos de la tabla herramientas
     */
    private List<Herramientas> listaHerramientas; //Almacena todas las tuplas de la tabla herramientas
    private Herramientas herramientaSelect; // permite obtener la tupla que el usuario a seleccionado en la tabla
    /**
     * Variables Prime para obtener los datos digitados por el usuario
     */
    private InputText txtNombre;
    private SelectOneMenu cmbTipo;

    /**
     * ============== Funciones para el manejo de herramientas =============
     * @return 
     */
    /* @return*/
    public List<Herramientas> getListaHerramientas() {
        listaHerramientas = herramientasLogica.listaHerramientas();
        return listaHerramientas;
    }

    public void setListaHerramientas(List<Herramientas> listaHerramientas) {
        this.listaHerramientas = listaHerramientas;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public SelectOneMenu getCmbTipo() {
        return cmbTipo;
    }

    public void setCmbTipo(SelectOneMenu cmbTipo) {
        this.cmbTipo = cmbTipo;
    }

    public Herramientas getHerramientaSelect() {
        return herramientaSelect;
    }

    public void setHerramientaSelect(Herramientas herramientaSelect) {
        this.herramientaSelect = herramientaSelect;
    }

    public void limpiarCamposHerramientas() {
        txtNombre.setValue("");
        cmbTipo.setValue("");
    }

    /**
     * Cuando el usuario seleccionada una fila de la tabla se actualiza la
     * variable herramientasSelect, de esta forma podemos saber cual elemento
     * desea actualizar o eliminar
     */
    public void seleccionarHerramienta(SelectEvent e) {
        herramientaSelect = (Herramientas) e.getObject();

        txtNombre.setValue(herramientaSelect.getNombre());
        cmbTipo.setValue(herramientaSelect.getTipo());
    }

    /**
     * Se toman los datos de los campos del formulario herramientas y se crea un
     * objeto con esta informacion
     */
    public void registrarHerramienta() {
        try {
            Herramientas nuevaHerramienta = new Herramientas();

            nuevaHerramienta.setNombre(txtNombre.getValue().toString());
            nuevaHerramienta.setTipo(Integer.parseInt(cmbTipo.getValue().toString()));

            herramientasLogica.registrarHerramienta(nuevaHerramienta);
            limpiarCamposHerramientas();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "La Herramienta ha sido registrada"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    /**
     * Se toman los datos de los campos del formulario herramientas y se
     * actualiza el objeto que previamente fue almacenado en la variable
     * herramientaSelect
     */
    public void editarHerramienta() {
        try {
            Herramientas editarHerramienta = herramientaSelect;

            editarHerramienta.setNombre(txtNombre.getValue().toString());
            editarHerramienta.setTipo(Integer.parseInt(cmbTipo.getValue().toString()));

            herramientasLogica.editarHerramienta(editarHerramienta);
            limpiarCamposHerramientas();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "La Herramienta ha sido editada"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    public void eliminarHerramienta() {
        herramientasLogica.eliminarHerramienta(herramientaSelect);
    }

    /**
     * =====================================================================
     *
     * @return
     */
    public List<SeminariosCursos> getListaSeminariosCursos() {
        listaSeminariosCursos = seminariosCursosLogica.listaSeminariosCursos();
        return listaSeminariosCursos;
    }

    public void setListaSeminariosCursos(List<SeminariosCursos> listaSeminariosCursos) {
        this.listaSeminariosCursos = listaSeminariosCursos;
    }

    public SeminariosCursos getSeminariosCursosSelect() {
        return seminariosCursosSelect;
    }

    public void setSeminariosCursosSelect(SeminariosCursos seminariosCursosSelect) {
        this.seminariosCursosSelect = seminariosCursosSelect;
    }

    public InputText getTxtNombreSeminario() {
        return txtNombreSeminario;
    }

    public void setTxtNombreSeminario(InputText txtNombreSeminario) {
        this.txtNombreSeminario = txtNombreSeminario;
    }

    public InputText getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(InputText txtLugar) {
        this.txtLugar = txtLugar;
    }

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Calendar getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Calendar fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void limpiarCamposSeminarios() {
        txtNombreSeminario.setValue("");
        txtLugar.setValue("");
    }

    /**
     * Cuando el usuario seleccionada una fila de la tabla se actualiza la
     * variable herramientasSelect, de esta forma podemos saber cual elemento
     * desea actualizar o eliminar
     */
    public void seleccionarSeminario(SelectEvent e) {
        seminariosCursosSelect = (SeminariosCursos) e.getObject();

        txtNombreSeminario.setValue(seminariosCursosSelect.getNombre());
        txtLugar.setValue(seminariosCursosSelect.getLugar());
        fechaIngreso.setValue(seminariosCursosSelect.getFechaInicio());
        fechaFinalizacion.setValue(seminariosCursosSelect.getFechaFinalizacion());
    }

    /**
     * Se toman los datos de los campos del formulario herramientas y se crea un
     * objeto con esta informacion
     */
    public void registrarSeminario() {
        try {
            SeminariosCursos nuevoSeminario = new SeminariosCursos();

            nuevoSeminario.setNombre(txtNombreSeminario.getValue().toString());
            nuevoSeminario.setLugar(txtLugar.getValue().toString());
            nuevoSeminario.setFechaInicio((Date) fechaIngreso.getValue());
            nuevoSeminario.setFechaFinalizacion((Date) fechaFinalizacion.getValue());
            nuevoSeminario.setId(10);
            seminariosCursosLogica.registrarSeminarioCurso(nuevoSeminario);
            limpiarCamposSeminarios();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El seminario ha sido registrado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    /**
     * Se toman los datos de los campos del formulario herramientas y se
     * actualiza el objeto que previamente fue almacenado en la variable
     * herramientaSelect
     */
    public void editarSeminario() {
        try {
            SeminariosCursos editarSeminario = seminariosCursosSelect;

            editarSeminario.setNombre(txtNombreSeminario.getValue().toString());
            editarSeminario.setLugar(txtLugar.getValue().toString());
            editarSeminario.setFechaInicio((Date) fechaIngreso.getValue());
            editarSeminario.setFechaFinalizacion((Date) fechaFinalizacion.getValue());
            seminariosCursosLogica.editarSeminarioCurso(editarSeminario);
            limpiarCamposSeminarios();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El seminario ha sido editada"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    public void eliminarSeminario() {
        try {
            seminariosCursosLogica.eliminarSeminarioCurso(seminariosCursosSelect);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El seminario ha sido eliminado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

}
