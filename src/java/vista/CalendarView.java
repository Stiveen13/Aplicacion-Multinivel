/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Juans
 */
@Named(value = "calendarView")
@RequestScoped
public class CalendarView {

    /**
     * Creates a new instance of CalendarView
     */
    public CalendarView() {
    }
    private Date fechaNacimiento;
    private Date fechaIngreso;
    
    private List<Date> multi;
    private List<Date> range;
    private ArrayList<Date> invalidDates;
    private ArrayList<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    private Date fechaTitulo;
    private Date fechaIngresoSeminario;
    private Date fechaFinalizacionSeminario;

    public void init() {
        invalidDates = new ArrayList<>();
        Date today = new Date();
        invalidDates.add(today);
        long oneDay = 24 * 60 * 60 * 1000;
        for (int i = 0; i < 5; i++) {
            invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
        }
 
        invalidDays = new ArrayList<>();
        invalidDays.add(0); /* the first day of week is disabled */
        invalidDays.add(3);
 
        minDate = new Date(today.getTime() - (365 * oneDay));
        maxDate = new Date(today.getTime() + (365 * oneDay));
    }
 
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
 
    public void click() {
        /*PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");*/
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaTitulo() {
        return fechaTitulo;
    }

    public void setFechaTitulo(Date fechaTitulo) {
        this.fechaTitulo = fechaTitulo;
    }
   
    public List<Date> getMulti() {
        return multi;
    }
 
    public void setMulti(List<Date> multi) {
        this.multi = multi;
    }
 
    public List<Date> getRange() {
        return range;
    }
 
    public void setRange(List<Date> range) {
        this.range = range;
    }
 
    public ArrayList<Date> getInvalidDates() {
        return invalidDates;
    }
 
    public void setInvalidDates(ArrayList<Date> invalidDates) {
        this.invalidDates = invalidDates;
    }
 
    public ArrayList<Integer> getInvalidDays() {
        return invalidDays;
    }
 
    public void setInvalidDays(ArrayList<Integer> invalidDays) {
        this.invalidDays = invalidDays;
    }
 
    public Date getMinDate() {
        return minDate;
    }
 
    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
 
    public Date getMaxDate() {
        return maxDate;
    }
 
    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public Date getFechaIngresoSeminario() {
        return fechaIngresoSeminario;
    }

    public void setFechaIngresoSeminario(Date fechaIngresoSeminario) {
        this.fechaIngresoSeminario = fechaIngresoSeminario;
    }

    public Date getFechaFinalizacionSeminario() {
        return fechaFinalizacionSeminario;
    }

    public void setFechaFinalizacionSeminario(Date fechaFinalizacionSeminario) {
        this.fechaFinalizacionSeminario = fechaFinalizacionSeminario;
    }
    
    

}
