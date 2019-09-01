/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.Date;
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

    private List<Conocimientos> listaConocimientos;
    private List<SeminariosAsistidos> listaSeminariosAsistidos;

    private List<SelectItem> selectItemIngenieros;
    private List<SelectItem> selectItemIngenierosSeminarios;
    private List<SelectItem> selectItemHerramientas;
    private List<SelectItem> selectItemSeminarios;
    
    private SelectOneMenu cmbIngenieros;
    private SelectOneMenu cmbIngenierosSeminarios;
    private SelectOneMenu cmbHerramientas;
    private SelectOneMenu cmbSeminarios; 

    public List<Conocimientos> getListaConocimientos() {
        listaConocimientos = conocimientosLogica.listaConocimientos();
        return listaConocimientos;
    }

    public void setListaConocimientos(List<Conocimientos> listaConocimientos) {
        this.listaConocimientos = listaConocimientos;
    }

    public List<SeminariosAsistidos> getListaSeminariosAsistidos() {
        listaSeminariosAsistidos = seminariosAsistidosLogica.listaSeminarios();
        return listaSeminariosAsistidos;
    }

    public void setListaSeminariosAsistidos(List<SeminariosAsistidos> listaSeminariosAsistidos) {
        this.listaSeminariosAsistidos = listaSeminariosAsistidos;
    }
    
    public void registrarConocimiento() {
        try {
            Ingenieros ingenieroSel = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenieros.getValue().toString()));
            Herramientas herramientaSel = herramientasLogica.buscarxId(Integer.parseInt(cmbHerramientas.getValue().toString()));
            
            Conocimientos nuevoConocimiento = new Conocimientos();
            nuevoConocimiento.setIngenierosCedula(ingenieroSel);
            nuevoConocimiento.setHerramientasId(herramientaSel);
            
            conocimientosLogica.registarConocimiento(nuevoConocimiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El conocimiento ha sido registrado"));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }
    
    public void registrarAsistenciaCurso() {
        try {
            Ingenieros ingenieroSel = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenierosSeminarios.getValue().toString()));
            SeminariosCursos seminarioSel = seminariosLogica.buscarxId(Integer.parseInt(cmbSeminarios.getValue().toString()));
            
            SeminariosAsistidos nuevaAsistencia = new SeminariosAsistidos();
            nuevaAsistencia.setIngenierosCedula(ingenieroSel);
            nuevaAsistencia.setSeminariosCursosId(seminarioSel);
            seminariosAsistidosLogica.registrarSeminarioAsistido(nuevaAsistencia);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "La asistencia ha sido registrado"));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
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

    public List<SelectItem> getSelectItemIngenierosSeminarios() {
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
    

    public List<SelectItem> getSelectItemHerramientas() {
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

    public List<SelectItem> getSelectItemSeminarios() {
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

    public SelectOneMenu getCmbIngenieros() {
        return cmbIngenieros;
    }

    public void setCmbIngenieros(SelectOneMenu cmbIngenieros) {
        this.cmbIngenieros = cmbIngenieros;
    }

    public SelectOneMenu getCmbIngenierosSeminarios() {
        return cmbIngenierosSeminarios;
    }

    public void setCmbIngenierosSeminarios(SelectOneMenu cmbIngenierosSeminarios) {
        this.cmbIngenierosSeminarios = cmbIngenierosSeminarios;
    }
    

    public SelectOneMenu getCmbHerramientas() {
        return cmbHerramientas;
    }

    public void setCmbHerramientas(SelectOneMenu cmbHerramientas) {
        this.cmbHerramientas = cmbHerramientas;
    }

    public SelectOneMenu getCmbSeminarios() {
        return cmbSeminarios;
    }

    public void setCmbSeminarios(SelectOneMenu cmbSeminarios) {
        this.cmbSeminarios = cmbSeminarios;
    }
    
    

}
