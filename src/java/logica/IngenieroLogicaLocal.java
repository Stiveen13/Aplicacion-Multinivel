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
    public void registrarIngeniero(Ingenieros ing) throws Exception;
    public Ingenieros buscarxCedula(Integer cedula);
}
