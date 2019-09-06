/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenierosJunior;

/**
 *
 * @author Juans
 */
@Local
public interface IngenierosJuniorLogicaLocal {
    
    public List<IngenierosJunior> listaHorasAsignadas();
    public void asignarHoras(IngenierosJunior nuevaAsignacion) throws Exception;
    public void editarAsignacion(IngenierosJunior eliminarAsignacion) throws Exception;
    public void eliminarAsignacion(IngenierosJunior editarAsignacion) throws Exception;
}
