/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GestionRequisitos;

/**
 *
 * @author Juans
 */
@Local
public interface GestionRequisitosFacadeLocal {

    void create(GestionRequisitos gestionRequisitos);

    void edit(GestionRequisitos gestionRequisitos);

    void remove(GestionRequisitos gestionRequisitos);

    GestionRequisitos find(Object id);

    List<GestionRequisitos> findAll();

    List<GestionRequisitos> findRange(int[] range);

    int count();
    
}
