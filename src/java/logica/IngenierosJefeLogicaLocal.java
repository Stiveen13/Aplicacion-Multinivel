/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenierosJefe;

/**
 *
 * @author Juans
 */
@Local
public interface IngenierosJefeLogicaLocal {
    public List<IngenierosJefe> listaPresupuestoAsignado();
    public void asignarPresupuesto(IngenierosJefe obj) throws Exception;
    public void editarPresupuesto(IngenierosJefe obj) throws Exception;
}
