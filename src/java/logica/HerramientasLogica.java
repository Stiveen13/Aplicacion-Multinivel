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

    @Override
    public void registrarHerramienta(Herramientas nuevaHerramienta) throws Exception {
        if(nuevaHerramienta.getNombre().equals("")){
            throw new Exception("El nombre de la herramienta es obligatorio");
        }
        
        /*
        Herramientas validarHerramienta = buscarxNombre(nuevaHerramienta.getNombre());
        if( validarHerramienta != null){
             throw new Exception("La herramienta ya existe");
        }*/
        
        herramientasDAO.create(nuevaHerramienta);
    }

    @Override
    public void editarHerramienta(Herramientas editarHerramienta) throws Exception {
        if(editarHerramienta.getNombre().equals("")){
            throw new Exception("El nombre de la herramienta es obligatorio");
        }
        
        herramientasDAO.edit(editarHerramienta);
    }

    @Override
    public void eliminarHerramienta(Herramientas eliminarHerramienta) {
        herramientasDAO.remove(eliminarHerramienta);
    }

    @Override
    public Herramientas buscarxNombre(String nombre) {
        return herramientasDAO.buscarxNombre(nombre);
    }
}
