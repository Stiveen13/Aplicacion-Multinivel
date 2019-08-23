/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenierosSenior;

/**
 *
 * @author Juans
 */
@Local
public interface IngenierosSeniorFacadeLocal {

    void create(IngenierosSenior ingenierosSenior);

    void edit(IngenierosSenior ingenierosSenior);

    void remove(IngenierosSenior ingenierosSenior);

    IngenierosSenior find(Object id);

    List<IngenierosSenior> findAll();

    List<IngenierosSenior> findRange(int[] range);

    int count();
    
}
