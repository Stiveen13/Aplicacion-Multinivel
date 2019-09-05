/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Conocimientos;
import persistencia.ConocimientosFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class ConocimientosLogica implements ConocimientosLogicaLocal {
    
    @EJB
    private ConocimientosFacadeLocal conocimientosDAO;
    
    @Override
    public List<Conocimientos> listaConocimientos() {
        return conocimientosDAO.findAll();
    }

    @Override
    public void registarConocimiento(Conocimientos nuevoConocimiento) throws Exception {
        conocimientosDAO.create(nuevoConocimiento);
    }

    @Override
    public Conocimientos buscarxId(Integer id) throws Exception {
        return conocimientosDAO.findxId(id);
    }

    @Override
    public void eliminarConocimiento(Conocimientos eliminarConocimiento) throws Exception {
        conocimientosDAO.remove(eliminarConocimiento);
    }
}
