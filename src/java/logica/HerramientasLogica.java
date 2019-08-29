/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Herramientas;
import persistencia.HerramientasFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class HerramientasLogica implements HerramientasLogicaLocal {
    
    @EJB
    private HerramientasFacadeLocal herramientasDAO;
    
    @Override
    public List<Herramientas> listaHerramientas() {
        return herramientasDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Herramientas buscarxId(Integer id) {
        return herramientasDAO.buscarxId(id);
    }
}
