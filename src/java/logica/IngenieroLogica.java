/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ingenieros;
import persistencia.IngenierosFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class IngenieroLogica implements IngenieroLogicaLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private IngenierosFacadeLocal ingenierosDAO; 

    @Override
    public List<Ingenieros> listarIngenieros() {
        return ingenierosDAO.findAll();
    }

    @Override
    public void registrarIngeniero(Ingenieros ing) throws Exception {
        ingenierosDAO.create(ing);
    }

    @Override
    public Ingenieros buscarxCedula(Integer cedula) {
        return ingenierosDAO.findxCedula(cedula);
    }
}
