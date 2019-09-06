/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenierosSenior;

/**
 *
 * @author Juans
 */
@Local
public interface IngenierosSeniorLogicaLocal {
    public void asignarProyecto(IngenierosSenior nuevaAsignacion) throws Exception;
    public List<IngenierosSenior> listaProyectosAsignados();
    public void eliminarAsignacionProyecto(IngenierosSenior eliminarAsignacion) throws Exception;
}
