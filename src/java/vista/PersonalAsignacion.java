/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.IngenieroLogicaLocal;
import logica.IngenierosJefeLogicaLocal;
import modelo.Ingenieros;
import modelo.IngenierosJefe;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Juans
 */
@Named(value = "personalAsignacion")
@RequestScoped
public class PersonalAsignacion {

    /**
     * Creates a new instance of PersonalAsignacion
     */
    public PersonalAsignacion() {
    }

    @EJB
    private IngenieroLogicaLocal ingenierosLogica;

    /**
     * Variables para la gestion de ingenieros Jefe
     */
    @EJB
    private IngenierosJefeLogicaLocal presupuestoAsignadoLogica;

    private List<Ingenieros> ingeierosJefe;
    private List<SelectItem> selectItemJefe;
    private SelectOneMenu cmbIngenierosJefe;
    private List<IngenierosJefe> listaPresupuestoAsignado;
    private InputText txtPresupuesto;
    private IngenierosJefe ingenieroJefeSelect;

    /**
     * Variables para la gestion de ingenieros Senior
     */
    private List<Ingenieros> ingeierosSenior;
    private List<SelectItem> selectItemSenior;
    private SelectOneMenu cmbIngenierosSenior;

    /**
     * Variables para la gestion de ingenieros Junior
     */
    private List<Ingenieros> ingeierosJunior;
    private List<SelectItem> selectItemJunior;
    private SelectOneMenu cmbIngenierosJunior;

    /* Funciones para la gestion de los ingenieros Jefe */
    public List<Ingenieros> getIngeierosJefe() {
        return ingeierosJefe;
    }

    public void setIngeierosJefe(List<Ingenieros> ingeierosJefe) {
        this.ingeierosJefe = ingeierosJefe;
    }

    public List<SelectItem> getSelectItemJefe() {
        selectItemJefe = new ArrayList<SelectItem>();
        List<Ingenieros> listaIngenieros = ingenierosLogica.ingenierosJefe();

        for (int i = 0; i < listaIngenieros.size(); i++) {
            SelectItem item = new SelectItem(listaIngenieros.get(i).getCedula(),
                    listaIngenieros.get(i).getCedula() + " "
                    + listaIngenieros.get(i).getNombres() + " "
                    + listaIngenieros.get(i).getApellidos());
            selectItemJefe.add(item);
        }

        return selectItemJefe;
    }

    public void setSelectItemJefe(List<SelectItem> selectItemJefe) {
        this.selectItemJefe = selectItemJefe;
    }

    public SelectOneMenu getCmbIngenierosJefe() {
        return cmbIngenierosJefe;
    }

    public void setCmbIngenierosJefe(SelectOneMenu cmbIngenierosJefe) {
        this.cmbIngenierosJefe = cmbIngenierosJefe;
    }

    public List<IngenierosJefe> getListaPresupuestoAsignado() {
        listaPresupuestoAsignado = presupuestoAsignadoLogica.listaPresupuestoAsignado();
        return listaPresupuestoAsignado;
    }

    public void setListaPresupuestoAsignado(List<IngenierosJefe> listaPresupuestoAsignado) {
        this.listaPresupuestoAsignado = listaPresupuestoAsignado;
    }

    public InputText getTxtPresupuesto() {
        return txtPresupuesto;
    }

    public void setTxtPresupuesto(InputText txtPresupuesto) {
        this.txtPresupuesto = txtPresupuesto;
    }

    public IngenierosJefe getIngenieroJefeSelect() {
        return ingenieroJefeSelect;
    }

    public void setIngenieroJefeSelect(IngenierosJefe ingenieroJefeSelect) {
        this.ingenieroJefeSelect = ingenieroJefeSelect;
    }
    
    public void limpiarCamposJefe(){
        txtPresupuesto.setValue("");
        cmbIngenierosJefe.setValue("");
    }
    
    public void seleccionarIngenieroJefe(SelectEvent e) {
        ingenieroJefeSelect = (IngenierosJefe) e.getObject();

        txtPresupuesto.setValue(ingenieroJefeSelect.getPresupuesto());
        cmbIngenierosJefe.setValue(ingenieroJefeSelect.getIngenierosCedula().getCedula());
    }

    public void asignarPresupuesto() {
        try {
            IngenierosJefe nuevaAsignacionPresupuesto = new IngenierosJefe();
            nuevaAsignacionPresupuesto.setPresupuesto(Integer.parseInt(txtPresupuesto.getValue().toString()));
            Ingenieros ingenieroObj = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenierosJefe.getValue().toString()));
            nuevaAsignacionPresupuesto.setIngenierosCedula(ingenieroObj);
            presupuestoAsignadoLogica.asignarPresupuesto(nuevaAsignacionPresupuesto);
            limpiarCamposJefe();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El presupuesto ha sido asignado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }
    
    public void editarPresupuesto() {
        try {
            IngenierosJefe nuevaAsignacionPresupuesto = ingenieroJefeSelect;
            nuevaAsignacionPresupuesto.setPresupuesto(Integer.parseInt(txtPresupuesto.getValue().toString()));
            Ingenieros ingenieroObj = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenierosJefe.getValue().toString()));
            nuevaAsignacionPresupuesto.setIngenierosCedula(ingenieroObj);
            presupuestoAsignadoLogica.editarPresupuesto(nuevaAsignacionPresupuesto);
            limpiarCamposJefe();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El presupuesto ha sido editado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    /* =================================================================== */
    public List<Ingenieros> getIngeierosSenior() {
        return ingeierosSenior;
    }

    public void setIngeierosSenior(List<Ingenieros> ingeierosSenior) {
        this.ingeierosSenior = ingeierosSenior;
    }

    public List<SelectItem> getSelectItemSenior() {
        return selectItemSenior;
    }

    public void setSelectItemSenior(List<SelectItem> selectItemSenior) {
        this.selectItemSenior = selectItemSenior;
    }

    public SelectOneMenu getCmbIngenierosSenior() {
        return cmbIngenierosSenior;
    }

    public void setCmbIngenierosSenior(SelectOneMenu cmbIngenierosSenior) {
        this.cmbIngenierosSenior = cmbIngenierosSenior;
    }

    public List<Ingenieros> getIngeierosJunior() {
        return ingeierosJunior;
    }

    public void setIngeierosJunior(List<Ingenieros> ingeierosJunior) {
        this.ingeierosJunior = ingeierosJunior;
    }

    public List<SelectItem> getSelectItemJunior() {
        return selectItemJunior;
    }

    public void setSelectItemJunior(List<SelectItem> selectItemJunior) {
        this.selectItemJunior = selectItemJunior;
    }

    public SelectOneMenu getCmbIngenierosJunior() {
        return cmbIngenierosJunior;
    }

    public void setCmbIngenierosJunior(SelectOneMenu cmbIngenierosJunior) {
        this.cmbIngenierosJunior = cmbIngenierosJunior;
    }

}
