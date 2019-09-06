/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.IngenierosJunior;
import persistencia.IngenierosJuniorFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class IngenierosJuniorLogica implements IngenierosJuniorLogicaLocal {
    
    @EJB
    private IngenierosJuniorFacadeLocal ingenierosJuniorDAO;
    
    @Override
    public List<IngenierosJunior> listaHorasAsignadas() {
        return ingenierosJuniorDAO.findAll();
    }

    @Override
    public void asignarHoras(IngenierosJunior nuevaAsignacion) throws Exception{
        ingenierosJuniorDAO.create(nuevaAsignacion);
    }

    @Override
    public void eliminarAsignacion(IngenierosJunior eliminarAsignacion) throws Exception{
        ingenierosJuniorDAO.remove(eliminarAsignacion);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void editarAsignacion(IngenierosJunior editarAsignacion) throws Exception {
        ingenierosJuniorDAO.edit(editarAsignacion);
    }
}
