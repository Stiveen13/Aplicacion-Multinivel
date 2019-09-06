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
import logica.IngenieroLogicaLocal;
import logica.IngenierosJefeLogicaLocal;
import logica.IngenierosJuniorLogicaLocal;
import logica.IngenierosSeniorLogicaLocal;
import modelo.Ingenieros;
import modelo.IngenierosJefe;
import modelo.IngenierosJunior;
import modelo.IngenierosSenior;
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
    private List<SelectItem> selectItemJefe; //Aux para mostrar los ingenieros en el cmb
    private List<IngenierosJefe> listaPresupuestoAsignado; //almacena todos los registros de la bd de la tabla Ingenieros Jefe
    private IngenierosJefe ingenieroJefeSelect; //Almacena temporalmente el obj IngenieroJefe que ha sido seleccionado por el usuario
    private InputText txtPresupuesto;
    private SelectOneMenu cmbIngenierosJefe;
    

    /**
     * Variables para la gestion de ingenieros Senior
     */
    @EJB
    private IngenierosSeniorLogicaLocal proyectosAsignadosLogica;

    private List<IngenierosSenior> listaProyectosAsignados;

    /**
     * Variables para la gestion de ingenieros Junior
     */
    @EJB
    private IngenierosJuniorLogicaLocal horasAsignadasLogica;

    private List<Ingenieros> ingeierosJunior;
    private List<SelectItem> selectItemJunior;
    private SelectOneMenu cmbIngenierosJunior;
    private InputText txtHoras;
    private List<IngenierosJunior> listaHorasAsignadas;
    private IngenierosJunior ingenierosJuniorSelect;

    /**
     * ************** Funciones para la gestion de los ingenieros Jefe *********
     */
    public List<Ingenieros> getIngeierosJefe() {
        return ingeierosJefe;
    }

    public void setIngeierosJefe(List<Ingenieros> ingeierosJefe) {
        this.ingeierosJefe = ingeierosJefe;
    }
    
    /** Inicializa los el cmb (Obj selectItem) con los datos almacenados en la BD
     */
    public List<SelectItem> getSelectItemJefe() {
        selectItemJefe = new ArrayList<SelectItem>();
        
        List<Ingenieros> listaIngenieros = ingenierosLogica.ingenierosJefe(); //Se consultan los ingenieros de clase Jefe
        
        // La lista anterior es iterada para mapear cada elemento a tipo selectitem
        for (int i = 0; i < listaIngenieros.size(); i++) {
            
            //El objeto selectItem recibe dos parametros: 1. El id - 2. El valor que se va mostrar en el cmb de la interfaz
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

    public void limpiarCamposJefe() {
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

    /* ===========================Gstions de proyectos asignados=============================== */
    public List<IngenierosSenior> getListaProyectosAsignados() {
        listaProyectosAsignados = proyectosAsignadosLogica.listaProyectosAsignados();
        return listaProyectosAsignados;
    }

    public void setListaProyectosAsignados(List<IngenierosSenior> listaProyectosAsignados) {
        this.listaProyectosAsignados = listaProyectosAsignados;
    }

    /* ==============================Funciones para la gestion de Ing. Junior============================ */
    public void limpiarCamposJunior() {
        txtHoras.setValue("");
        cmbIngenierosJunior.setValue("");
    }

    public void seleccionarIngenieroJunior(SelectEvent e) {
        ingenierosJuniorSelect = (IngenierosJunior) e.getObject();

        txtHoras.setValue(ingenierosJuniorSelect.getHorasDia());
        cmbIngenierosJunior.setValue(ingenierosJuniorSelect.getIngenierosCedula().getCedula());
    }

    public InputText getTxtHoras() {
        return txtHoras;
    }

    public void setTxtHoras(InputText txtHoras) {
        this.txtHoras = txtHoras;
    }

    public List<IngenierosJunior> getListaHorasAsignadas() {
        listaHorasAsignadas = horasAsignadasLogica.listaHorasAsignadas();
        return listaHorasAsignadas;
    }

    public void setListaHorasAsignadas(List<IngenierosJunior> listaHorasAsignadas) {
        this.listaHorasAsignadas = listaHorasAsignadas;
    }

    public IngenierosJunior getIngenierosJuniorSelect() {
        return ingenierosJuniorSelect;
    }

    public void setIngenierosJuniorSelect(IngenierosJunior ingenierosJuniorSelect) {
        this.ingenierosJuniorSelect = ingenierosJuniorSelect;
    }

    public List<Ingenieros> getIngeierosJunior() {
        return ingeierosJunior;
    }

    public void setIngeierosJunior(List<Ingenieros> ingeierosJunior) {
        this.ingeierosJunior = ingeierosJunior;
    }

    public List<SelectItem> getSelectItemJunior() {
        selectItemJunior = new ArrayList<SelectItem>();

        List<Ingenieros> listaIngenieros = ingenierosLogica.ingenierosJunior();

        for (int i = 0; i < listaIngenieros.size(); i++) {
            SelectItem item = new SelectItem(listaIngenieros.get(i).getCedula(),
                    listaIngenieros.get(i).getCedula() + " "
                    + listaIngenieros.get(i).getNombres() + " "
                    + listaIngenieros.get(i).getApellidos());
            selectItemJunior.add(item);
        }

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

    public void asignarHoras() {
        try {
            IngenierosJunior nuevaAsignacionHora = new IngenierosJunior();
            nuevaAsignacionHora.setHorasDia(Integer.parseInt(txtHoras.getValue().toString()));
            Ingenieros ingenieroObj = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenierosJunior.getValue().toString()));
            nuevaAsignacionHora.setIngenierosCedula(ingenieroObj);

            horasAsignadasLogica.asignarHoras(nuevaAsignacionHora);
            limpiarCamposJunior();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "Las horas han sido asignadas"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    public void editarhorasAsignadas() {
        try {
            IngenierosJunior nuevaAsignacionHora = ingenierosJuniorSelect;
            nuevaAsignacionHora.setHorasDia(Integer.parseInt(txtHoras.getValue().toString()));
            Ingenieros ingenieroObj = ingenierosLogica.buscarxCedula(Integer.parseInt(cmbIngenierosJunior.getValue().toString()));
            nuevaAsignacionHora.setIngenierosCedula(ingenieroObj);

            horasAsignadasLogica.editarAsignacion(nuevaAsignacionHora);
            limpiarCamposJunior();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "Las horas han sido editado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }
}
