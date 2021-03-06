/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Conocimientos;

/**
 *
 * @author Juans
 */
@Local
public interface ConocimientosLogicaLocal {
    
    public List<Conocimientos> listaConocimientos();
    
    public void registarConocimiento(Conocimientos nuevoConocimiento) throws Exception;
    
    public void eliminarConocimiento(Conocimientos eliminarConocimiento) throws Exception;
    
    public Conocimientos buscarxId(Integer id) throws Exception;
}
