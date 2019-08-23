package vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.IngenieroLogicaLocal;
import modelo.Ingenieros;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author Juans
 */
@Named(value = "personalInformacionVista")
@RequestScoped
public class PersonalInformacionVista {

    /**
     * Creates a new instance of InformacionVista
     */
    public PersonalInformacionVista() {
    }
    
    @EJB
    private IngenieroLogicaLocal ingenieroLogica;
    
    private List<Ingenieros> listaIngenieros;
    
    private InputText txtCedula;
    private InputText txtNombres;
    private InputText txtApellidos;
    private InputText txtEmail;
    private InputText txtTelefonoFijo;
    private InputText txtTelefonoMovil;
    private InputText txtDireccion;
    private Calendar fechaNacimiento;
    private InputText txtEdad;
    private SelectOneMenu cmbSexo;
    private Calendar fechaIngreso;
    private SelectOneMenu cmbClase;

    public List<Ingenieros> getListaIngenieros() {
        listaIngenieros = ingenieroLogica.listarIngenieros();
        return listaIngenieros;
    }

    public void setListaIngenieros(List<Ingenieros> listaIngenieros) {
        this.listaIngenieros = listaIngenieros;
    }
    
    public void registrarIngeniero(){
        try {
            Ingenieros nuevoIngeniero = new Ingenieros();
            
            nuevoIngeniero.setCedula(Integer.parseInt(txtCedula.getValue().toString()));
            nuevoIngeniero.setNombres(txtNombres.getValue().toString());
            nuevoIngeniero.setApellidos(txtApellidos.getValue().toString());
            nuevoIngeniero.setEmail(txtEmail.getValue().toString());
            nuevoIngeniero.setTelefonoFijo(txtTelefonoFijo.getValue().toString());
            nuevoIngeniero.setTelefonoMovil(txtTelefonoMovil.getValue().toString());
            nuevoIngeniero.setDireccion(txtDireccion.getValue().toString());
            nuevoIngeniero.setFechaNacimiento((Date) fechaNacimiento.getValue());
            nuevoIngeniero.setEdad(Integer.parseInt(txtEdad.getValue().toString()));
            char caracterSexo = cmbSexo.getValue().toString().charAt(0);
            nuevoIngeniero.setSexo(caracterSexo);
            nuevoIngeniero.setFechaIngreso((Date) fechaIngreso.getValue());
            nuevoIngeniero.setClase(Integer.parseInt(cmbClase.getValue().toString()));
            
            ingenieroLogica.registrarIngeniero(nuevoIngeniero);
                    
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El Ing. ha sido registrado"));
           
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }

    public InputText getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(InputText txtCedula) {
        this.txtCedula = txtCedula;
    }

    public InputText getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(InputText txtNombres) {
        this.txtNombres = txtNombres;
    }

    public InputText getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(InputText txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtTelefonoFijo() {
        return txtTelefonoFijo;
    }

    public void setTxtTelefonoFijo(InputText txtTelefonoFijo) {
        this.txtTelefonoFijo = txtTelefonoFijo;
    }

    public InputText getTxtTelefonoMovil() {
        return txtTelefonoMovil;
    }

    public void setTxtTelefonoMovil(InputText txtTelefonoMovil) {
        this.txtTelefonoMovil = txtTelefonoMovil;
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public InputText getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(InputText txtEdad) {
        this.txtEdad = txtEdad;
    }

    public SelectOneMenu getCmbSexo() {
        return cmbSexo;
    }

    public void setCmbSexo(SelectOneMenu cmbSexo) {
        this.cmbSexo = cmbSexo;
    }

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public SelectOneMenu getCmbClase() {
        return cmbClase;
    }

    public void setCmbClase(SelectOneMenu cmbClase) {
        this.cmbClase = cmbClase;
    }
    
    
    
    
    
}
