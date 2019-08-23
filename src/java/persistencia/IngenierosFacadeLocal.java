/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingenieros;

/**
 *
 * @author Juans
 */
@Local
public interface IngenierosFacadeLocal {

    void create(Ingenieros ingenieros);

    void edit(Ingenieros ingenieros);

    void remove(Ingenieros ingenieros);

    Ingenieros find(Object id);

    List<Ingenieros> findAll();

    List<Ingenieros> findRange(int[] range);

    int count();
    
}
