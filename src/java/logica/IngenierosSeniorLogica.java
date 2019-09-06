/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.IngenierosSenior;
import persistencia.IngenierosSeniorFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class IngenierosSeniorLogica implements IngenierosSeniorLogicaLocal {
    
    @EJB
    private IngenierosSeniorFacadeLocal ingenierosSeniorDAO;
    
    @Override
    public void asignarProyecto(IngenierosSenior nuevaAsignacion) throws Exception {
        ingenierosSeniorDAO.create(nuevaAsignacion);
    }

    @Override
    public List<IngenierosSenior> listaProyectosAsignados() {
       return ingenierosSeniorDAO.findAll();
    }

    @Override
    public void eliminarAsignacionProyecto(IngenierosSenior eliminarAsignacion) throws Exception {
        ingenierosSeniorDAO.remove(eliminarAsignacion);
    }
}
