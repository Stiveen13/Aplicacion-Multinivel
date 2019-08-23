/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenierosJunior;

/**
 *
 * @author Juans
 */
@Local
public interface IngenierosJuniorFacadeLocal {

    void create(IngenierosJunior ingenierosJunior);

    void edit(IngenierosJunior ingenierosJunior);

    void remove(IngenierosJunior ingenierosJunior);

    IngenierosJunior find(Object id);

    List<IngenierosJunior> findAll();

    List<IngenierosJunior> findRange(int[] range);

    int count();
    
}
