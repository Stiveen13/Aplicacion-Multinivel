/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.IngenierosJefe;
import persistencia.IngenierosJefeFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class IngenierosJefeLogica implements IngenierosJefeLogicaLocal {
    
    @EJB
    private IngenierosJefeFacadeLocal ingenierosJefeDAO;
    
    @Override
    public List<IngenierosJefe> listaPresupuestoAsignado() {
        return ingenierosJefeDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void asignarPresupuesto(IngenierosJefe obj) throws Exception {
        ingenierosJefeDAO.create(obj);
    }

    @Override
    public void editarPresupuesto(IngenierosJefe obj) throws Exception {
        ingenierosJefeDAO.edit(obj);
    }
}
