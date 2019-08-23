/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenierosJefe;

/**
 *
 * @author Juans
 */
@Local
public interface IngenierosJefeFacadeLocal {

    void create(IngenierosJefe ingenierosJefe);

    void edit(IngenierosJefe ingenierosJefe);

    void remove(IngenierosJefe ingenierosJefe);

    IngenierosJefe find(Object id);

    List<IngenierosJefe> findAll();

    List<IngenierosJefe> findRange(int[] range);

    int count();
    
}
