/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.CompatibilidadProyecto;

/**
 *
 * @author Juans
 */
@Local
public interface CompatibilidadProyectoFacadeLocal {

    void create(CompatibilidadProyecto compatibilidadProyecto);

    void edit(CompatibilidadProyecto compatibilidadProyecto);

    void remove(CompatibilidadProyecto compatibilidadProyecto);

    CompatibilidadProyecto find(Object id);

    List<CompatibilidadProyecto> findAll();

    List<CompatibilidadProyecto> findRange(int[] range);

    int count();
    
}
