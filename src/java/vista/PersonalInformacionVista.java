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
import logica.TitulosAcademicosLogicaLocal;
import modelo.Ingenieros;
import modelo.TitulosAcademicos;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

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
    
    @EJB 
    private TitulosAcademicosLogicaLocal titulosAcademicosLogica;
    
    private List<Ingenieros> listaIngenieros;
    
    /** Variables Prime para obtener los datos digitados por el usuario
     * por cada variable se debe generar los set y get 
     */
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
    private InputText txtTituloObtenido;
    private InputText txtInstitucion;
    private Calendar fechaObtencion;
    
    /** Variable que almacena la información del ingeniero seleccionado en la tabla */
    private Ingenieros ingenieroSelect;

    public List<Ingenieros> getListaIngenieros() {
        listaIngenieros = ingenieroLogica.listarIngenieros();
        return listaIngenieros;
    }

    public void setListaIngenieros(List<Ingenieros> listaIngenieros) {
        this.listaIngenieros = listaIngenieros;
    }
    
    /** Para registrar un nuevo ingeneiro se toman los datos de los campos input del formulario */
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
            //nuevoIngeniero.setEdad(Integer.parseInt(txtEdad.getValue().toString()));
            char caracterSexo = cmbSexo.getValue().toString().charAt(0);
            nuevoIngeniero.setSexo(caracterSexo);
            nuevoIngeniero.setFechaIngreso((Date) fechaIngreso.getValue());
            nuevoIngeniero.setClase(Integer.parseInt(cmbClase.getValue().toString()));
            ingenieroLogica.registrarIngeniero(nuevoIngeniero);
            
            /** Como el titulo academico es una tabla en la BD, se debe
             crear el objeto de este tipo para asociarlo al ingeniero. */
            TitulosAcademicos tituloObj = new TitulosAcademicos();
            tituloObj.setTituloObtenido(txtTituloObtenido.getValue().toString());
            tituloObj.setInstitucion(txtInstitucion.getValue().toString());
            tituloObj.setFechaObtencion((Date) fechaObtencion.getValue());
            tituloObj.setIngenierosCedula(nuevoIngeniero);
            tituloObj.setIdTitulo(nuevoIngeniero.getCedula());
            titulosAcademicosLogica.registrarTitulo(tituloObj);
                    
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información: ", "El Ing. ha sido registrado"));
           
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información: ", ex.getMessage()));
        }
    }
    
    /** Se actualiza los datos del ingeniero que previamente habia sido almacenado en la variable 
     * ingenieroSelect
    */
    public void editarIngeniero(){
         try {
            Ingenieros updateContratista = ingenieroSelect;
            updateContratista.setNombres(txtNombres.getValue().toString());
            updateContratista.setApellidos(txtApellidos.getValue().toString());
            updateContratista.setEmail(txtEmail.getValue().toString());
            updateContratista.setTelefonoFijo(txtTelefonoFijo.getValue().toString());
            updateContratista.setTelefonoMovil(txtTelefonoMovil.getValue().toString());
            updateContratista.setDireccion(txtDireccion.getValue().toString());
            updateContratista.setFechaNacimiento((Date) fechaNacimiento.getValue());
            //nuevoIngeniero.setEdad(Integer.parseInt(txtEdad.getValue().toString()));
            char caracterSexo = cmbSexo.getValue().toString().charAt(0);
            updateContratista.setSexo(caracterSexo);
            updateContratista.setFechaIngreso((Date) fechaIngreso.getValue());
            updateContratista.setClase(Integer.parseInt(cmbClase.getValue().toString()));
            ingenieroLogica.editarIngeniero(updateContratista);
                
            /** Al igual que en registrar, se debe obtener el titulo que tiene el ingeniero y
             este titulo es una tupla de la tabla TitulosAcademicos.
             Por tiempo, solo se almacenará 1 titulo por cada ingeniero. por esta razón
             de la lista de titulos siempre se obtiene el de la posicion 0*/
            TitulosAcademicos titulo = ingenieroSelect.getTitulosAcademicosList().get(0);
            titulo.setTituloObtenido(txtTituloObtenido.getValue().toString());
            titulo.setInstitucion(txtInstitucion.getValue().toString());
            titulo.setFechaObtencion((Date) fechaObtencion.getValue());
            titulosAcademicosLogica.editarTitulo(titulo);
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "El Ingeniero ha sido modificado"));
            limpiarCampos();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "mensaje", ex.getMessage()));
        }
    }
    
    public void eliminarIngeniero(){
        ingenieroLogica.eliminarIngeniero(ingenieroSelect);
    }
       /** Metodo que almacena los datos del ingeniero seleccionado en la tabla.
     La tabla tiene una propiedad que activa el evento y el objeto selecContratista 
     es actualizado**/
    public void seleccionarIngeniero(SelectEvent e) {
        ingenieroSelect = (Ingenieros) e.getObject();
        txtCedula.setValue(ingenieroSelect.getCedula());
        txtNombres.setValue(ingenieroSelect.getNombres());
        txtApellidos.setValue(ingenieroSelect.getApellidos());
        txtEmail.setValue(ingenieroSelect.getEmail());
        txtTelefonoFijo.setValue(ingenieroSelect.getTelefonoFijo());
        txtTelefonoMovil.setValue(ingenieroSelect.getTelefonoMovil());
        txtDireccion.setValue(ingenieroSelect.getDireccion());
        fechaNacimiento.setValue(ingenieroSelect.getFechaNacimiento());
        txtEdad.setValue(ingenieroSelect.getEdad());
        cmbSexo.setValue(ingenieroSelect.getSexo());
        fechaIngreso.setValue(ingenieroSelect.getFechaIngreso());
        cmbClase.setValue(ingenieroSelect.getClase());
        TitulosAcademicos titulo = ingenieroSelect.getTitulosAcademicosList().get(0);
        txtTituloObtenido.setValue(titulo.getTituloObtenido());
        txtInstitucion.setValue(titulo.getInstitucion());
        fechaObtencion.setValue(titulo.getFechaObtencion());      
    }
    
    public void limpiarCampos() {
        txtCedula.setValue("");
        txtNombres.setValue("");
        txtApellidos.setValue("");
        txtEmail.setValue("");
        txtTelefonoFijo.setValue("");
        txtTelefonoMovil.setValue("");
        txtDireccion.setValue("");
        txtEdad.setValue("");
        cmbSexo.setValue("");
        cmbClase.setValue("");
        txtTituloObtenido.setValue("");
        txtInstitucion.setValue("");
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

    public Ingenieros getIngenieroSelect() {
        return ingenieroSelect;
    }

    public void setIngenieroSelect(Ingenieros ingenieroSelect) {
        this.ingenieroSelect = ingenieroSelect;
    }

    public InputText getTxtTituloObtenido() {
        return txtTituloObtenido;
    }

    public void setTxtTituloObtenido(InputText txtTituloObtenido) {
        this.txtTituloObtenido = txtTituloObtenido;
    }

    public InputText getTxtInstitucion() {
        return txtInstitucion;
    }

    public void setTxtInstitucion(InputText txtInstitucion) {
        this.txtInstitucion = txtInstitucion;
    }

    public Calendar getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(Calendar fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }
    
}
