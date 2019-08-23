/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.RequisitosProyecto;

/**
 *
 * @author Juans
 */
@Local
public interface RequisitosProyectoFacadeLocal {

    void create(RequisitosProyecto requisitosProyecto);

    void edit(RequisitosProyecto requisitosProyecto);

    void remove(RequisitosProyecto requisitosProyecto);

    RequisitosProyecto find(Object id);

    List<RequisitosProyecto> findAll();

    List<RequisitosProyecto> findRange(int[] range);

    int count();
    
}
