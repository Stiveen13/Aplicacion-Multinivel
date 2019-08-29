/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Herramientas;

/**
 *
 * @author Juans
 */
@Local
public interface HerramientasFacadeLocal {

    void create(Herramientas herramientas);

    void edit(Herramientas herramientas);

    void remove(Herramientas herramientas);

    Herramientas find(Object id);

    List<Herramientas> findAll();

    List<Herramientas> findRange(int[] range);

    int count();
    
    Herramientas buscarxId(Integer id);
}
