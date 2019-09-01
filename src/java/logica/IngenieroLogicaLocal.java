/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingenieros;

/**
 *
 * @author Juans
 */
@Local
public interface IngenieroLogicaLocal {
    public List<Ingenieros> listarIngenieros();
    public void registrarIngeniero(Ingenieros nuevoIngeniero) throws Exception;
    public void editarIngeniero(Ingenieros editarIngeniero) throws Exception;
    public Ingenieros buscarxCedula(Integer cedula);
    public void eliminarIngeniero(Ingenieros eliminarIngeniero);
}
