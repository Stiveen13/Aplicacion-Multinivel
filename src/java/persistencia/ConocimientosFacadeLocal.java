/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Conocimientos;

/**
 *
 * @author Juans
 */
@Local
public interface ConocimientosFacadeLocal {

    void create(Conocimientos conocimientos);

    void edit(Conocimientos conocimientos);

    void remove(Conocimientos conocimientos);

    Conocimientos find(Object id);

    List<Conocimientos> findAll();

    List<Conocimientos> findRange(int[] range);

    int count();
    
}
