/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.ejb.EJB;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import logica.HerramientasLogicaLocal;
import logica.SeminariosCursosLogicaLocal;
import modelo.Herramientas;
import modelo.SeminariosCursos;

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
    
    private List<SeminariosCursos> listaSeminariosCursos;
    private List<Herramientas> listaHerramientas;

    public List<SeminariosCursos> getListaSeminariosCursos() {
        listaSeminariosCursos = seminariosCursosLogica.listaSeminariosCursos();
        return listaSeminariosCursos;
    }

    public void setListaSeminariosCursos(List<SeminariosCursos> listaSeminariosCursos) {
        this.listaSeminariosCursos = listaSeminariosCursos;
    }

    public List<Herramientas> getListaHerramientas() {
        listaHerramientas = herramientasLogica.listaHerramientas();
        return listaHerramientas;
    }

    public void setListaHerramientas(List<Herramientas> listaHerramientas) {
        this.listaHerramientas = listaHerramientas;
    }
    
    
}
