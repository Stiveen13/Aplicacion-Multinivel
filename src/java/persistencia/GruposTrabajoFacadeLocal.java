/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GruposTrabajo;

/**
 *
 * @author Juans
 */
@Local
public interface GruposTrabajoFacadeLocal {

    void create(GruposTrabajo gruposTrabajo);

    void edit(GruposTrabajo gruposTrabajo);

    void remove(GruposTrabajo gruposTrabajo);

    GruposTrabajo find(Object id);

    List<GruposTrabajo> findAll();

    List<GruposTrabajo> findRange(int[] range);

    int count();
    
}
