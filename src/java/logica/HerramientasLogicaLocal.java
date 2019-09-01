/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Herramientas;

/**
 *
 * @author Juans
 */
@Local
public interface HerramientasLogicaLocal {
    
    public List<Herramientas> listaHerramientas();
    
    public Herramientas buscarxId(Integer id);
    
    public Herramientas buscarxNombre(String nombre);
    
    public void registrarHerramienta(Herramientas nuevaHerramienta) throws Exception;
    
    public void editarHerramienta(Herramientas editarHerramienta) throws Exception;
    
    public void eliminarHerramienta(Herramientas eliminarHerramienta);
    
}
