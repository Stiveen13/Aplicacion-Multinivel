/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.ConocimientosLogicaLocal;
import logica.HerramientasLogicaLocal;
import logica.IngenieroLogicaLocal;
import logica.SeminariosAsistidosLogicaLocal;
import logica.SeminariosCursosLogicaLocal;
import modelo.Conocimientos;
import modelo.Herramientas;
import modelo.Ingenieros;
import modelo.SeminariosAsistidos;
import modelo.SeminariosCursos;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Juans
 */
@Named(value = "personalConocimientosVista")
@RequestScoped
public class PersonalConocimientosVista {

    /**
     * Creates a new instance of PersonalConocimientosVista
     */
    public PersonalConocimientosVista() {

    }

    @EJB
    private ConocimientosLogicaLocal conocimientosLogica;

    @EJB
    private IngenieroLogicaLocal ingenierosLogica;

    @EJB
    private HerramientasLogicaLocal herramientasLogica;

    @EJB
    private SeminariosCursosLogicaLocal seminariosLogica;

    @EJB
    private SeminariosAsistidosLogicaLocal seminariosAsistidosLogica;

    /**
     * Variables para gestionar la tabla conocimientos
     */
    private List<Conocimientos> listaConocimientos;
    private List<SelectItem> selectItemIngenieros;
    private List<SelectItem> selectItemHerramientas;
    private SelectOneMenu cmbIngenieros;
    private SelectOneMenu cmbHerramientas;
    private Conocimientos conociminetosSelect;
    /**
     * ===============================================
     */

    /**
     * Variables para gestionar la tabla seminariosAsistidos
     */
    private List<SeminariosAsistidos> listaSeminariosAsistidos;
    private List<SelectItem> selectItemIngenierosSeminarios;
    private List<SelectItem> selectItemSeminarios;
    private SelectOneMenu cmbIngenierosSeminarios;
    private SelectOneMenu cmbSeminarios;
    private SeminariosAsistidos seminariosAsistidosSelect;

    /**
     * ===============================================
     */
    /**
     * =================== Gestion de la tabla conocimientos ==============
     *
     * @return
     */
    public List<Conocimientos> getListaConocimientos() {
        listaConocimientos = conocimientosLogica.listaConocimientos();
        return listaConocimientos;
    }

    public void setListaConocimientos(List<Conocimientos> listaConocimientos) {
        this.listaConocimientos = listaConocimientos;
    }

    public SelectOneMenu getCmbIngenieros() {
        return cmbIngenieros;
    }

    public void setCmbIngenieros(SelectOneMenu cmbIngenieros) {
        this.cmbIngenieros = cmbIngenieros;
    }

    public SelectOneMenu getCmbHerramientas() {
        return cmbHerramientas;
    }

    public void setCmbHerramientas(SelectOneMenu cmbHerramientas) {
        this.cmbHerramientas = cmbHerramientas;
    }

    public Conocimientos getConociminetosSelect() {
        return conociminetosSelect;
    }

    public void setConociminetosSelect(Conocimientos conociminetosSelect) {
        this.conociminetosSelect = conociminetosSelect;
    }

    public List<SelectItem> getSelectItemHerramientas() {
        selectItemHerramientas = new ArrayList<SelectItem>();
        List<Herramientas> listaHerramientas = herramientasLogica.listaHerramientas();

        for (int i = 0; i < listaHerramientas.size(); i++) {
            SelectItem item = new SelectItem(listaHerramientas.get(i).getId(),
                    listaHerramientas.get(i).getNombre());
            selectItemHerramientas.add(item);
        }
        return selectItemHerramientas;
    }

    public void setSelectItemHerramientas(List<SelectItem> selectItemHerramientas) {
        this.selectItemHerramientas = selectItemHerramientas;
    }

    public List<SelectItem> getSelectItemIngenieros() {
        selectItemIngenieros = new ArrayList<SelectItem>();
        List<Ingenieros> listaIngenieros = ingenierosLogica.listarIngenieros();

        for (int i = 0; i < listaIngenieros.size(); i++) {
            SelectItem item = new SelectItem(listaIngenieros.get(i).getCedula(),
                    listaIngenieros.get(i).getCedula() + " "
                    + listaIngenieros.get(i).getNombres() + " "
                    + listaIngenieros.get(i).getApellidos());
            selectItemIngenieros.add(item);
        }
        return selectItemIngenieros;
    }

    public void setSelectItemIngenieros(List<SelectItem> selectItemIngenieros) {
        this.selectItemIngenieros = selectItemIngenieros;
    }

    public void limpiarCamposConocimientos() {
        cmbIngenieros.setValue("");
        cmbHerramientas.setValue("");
    }
    
    public void seleccionarConocimiento(SelectEvent e) {
        conociminetosSelect = (Conocimientos) e.getObject();

        cmbIngenieros.setValue(conociminetosSelect.getIngenierosCedula().getCedula());
        cmbHerramientas.setValue(conociminetosSelect.getHerramientasId().getId());
    }

    public void registrarConocimiento() {
        try {
            Ingenieros ingenieroSel = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenieros.getValue().toString()));
            Herramientas herramientaSel = herramientasLogica.buscarxId(Integer.parseInt(cmbHerramientas.getValue().toString()));

            Conocimientos nuevoConocimiento = new Conocimientos();
            nuevoConocimiento.setIngenierosCedula(ingenieroSel);
            nuevoConocimiento.setHerramientasId(herramientaSel);
            limpiarCamposConocimientos();
            conocimientosLogica.registarConocimiento(nuevoConocimiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El conocimiento ha sido registrado"));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }
    
    public void eliminarConocimiento() {
        try {
            conocimientosLogica.eliminarConocimiento(conociminetosSelect);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El conocimiento ha sido eliminado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    /**
     * ====================================================================
     */
    /**
     * =================== Gestion de la tabla Seminarios Asistidos
     * ==============
     *
     * @return
     */
    public List<SeminariosAsistidos> getListaSeminariosAsistidos() {
        listaSeminariosAsistidos = seminariosAsistidosLogica.listaSeminarios();
        return listaSeminariosAsistidos;
    }

    public void setListaSeminariosAsistidos(List<SeminariosAsistidos> listaSeminariosAsistidos) {
        this.listaSeminariosAsistidos = listaSeminariosAsistidos;
    }

    public void limpiarCamposSeminariosAsistidos() {
        cmbIngenierosSeminarios.setValue("");
        cmbSeminarios.setValue("");
    }

    /**
     * Cuando el usuario seleccionada una fila de la tabla se actualiza la
     * variable herramientasSelect, de esta forma podemos saber cual elemento
     * desea actualizar o eliminar
     */
    public void seleccionarSeminarioAsistido(SelectEvent e) {
        seminariosAsistidosSelect = (SeminariosAsistidos) e.getObject();

        cmbIngenierosSeminarios.setValue(seminariosAsistidosSelect.getIngenierosCedula().getCedula());
        cmbSeminarios.setValue(seminariosAsistidosSelect.getSeminariosCursosId().getId());
    }

    public void registrarAsistenciaCurso() {
        try {
            Ingenieros ingenieroSel = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenierosSeminarios.getValue().toString()));
            SeminariosCursos seminarioSel = seminariosLogica.buscarxId(Integer.parseInt(cmbSeminarios.getValue().toString()));

            SeminariosAsistidos nuevaAsistencia = new SeminariosAsistidos();
            nuevaAsistencia.setIngenierosCedula(ingenieroSel);
            nuevaAsistencia.setSeminariosCursosId(seminarioSel);
            seminariosAsistidosLogica.registrarSeminarioAsistido(nuevaAsistencia);
            limpiarCamposSeminariosAsistidos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "La asistencia ha sido registrado"));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    public void eliminarAsistenciaCurso() {
        try {
            seminariosAsistidosLogica.eliminarSeminarioAsistido(seminariosAsistidosSelect);
            limpiarCamposSeminariosAsistidos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "La asistencia ha sido eliminada"));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    public List<SelectItem> getSelectItemIngenierosSeminarios() {
        selectItemIngenierosSeminarios = new ArrayList<SelectItem>();
        List<Ingenieros> listaIngenieros = ingenierosLogica.listarIngenieros();

        for (int i = 0; i < listaIngenieros.size(); i++) {
            SelectItem item = new SelectItem(listaIngenieros.get(i).getCedula(),
                    listaIngenieros.get(i).getCedula() + " "
                    + listaIngenieros.get(i).getNombres() + " "
                    + listaIngenieros.get(i).getApellidos());
            selectItemIngenierosSeminarios.add(item);
        }
        return selectItemIngenierosSeminarios;
    }

    public void setSelectItemIngenierosSeminarios(List<SelectItem> selectItemIngenierosSeminarios) {
        this.selectItemIngenierosSeminarios = selectItemIngenierosSeminarios;
    }

    public List<SelectItem> getSelectItemSeminarios() {
        selectItemSeminarios = new ArrayList<SelectItem>();
        List<SeminariosCursos> listaSeminarios = seminariosLogica.listaSeminariosCursos();

        for (int i = 0; i < listaSeminarios.size(); i++) {
            SelectItem item = new SelectItem(listaSeminarios.get(i).getId(),
                    listaSeminarios.get(i).getNombre());
            selectItemSeminarios.add(item);
        }

        return selectItemSeminarios;
    }

    public void setSelectItemSeminarios(List<SelectItem> selectItemSeminarios) {
        this.selectItemSeminarios = selectItemSeminarios;
    }

    public SelectOneMenu getCmbIngenierosSeminarios() {
        return cmbIngenierosSeminarios;
    }

    public void setCmbIngenierosSeminarios(SelectOneMenu cmbIngenierosSeminarios) {
        this.cmbIngenierosSeminarios = cmbIngenierosSeminarios;
    }

    public SelectOneMenu getCmbSeminarios() {
        return cmbSeminarios;
    }

    public void setCmbSeminarios(SelectOneMenu cmbSeminarios) {
        this.cmbSeminarios = cmbSeminarios;
    }

    public SeminariosAsistidos getSeminariosAsistidosSelect() {
        return seminariosAsistidosSelect;
    }

    public void setSeminariosAsistidosSelect(SeminariosAsistidos seminariosAsistidosSelect) {
        this.seminariosAsistidosSelect = seminariosAsistidosSelect;
    }
}
