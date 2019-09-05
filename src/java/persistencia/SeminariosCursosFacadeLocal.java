/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.SeminariosCursos;

/**
 *
 * @author Juans
 */
@Local
public interface SeminariosCursosFacadeLocal {

    void create(SeminariosCursos seminariosCursos);

    void edit(SeminariosCursos seminariosCursos);

    void remove(SeminariosCursos seminariosCursos);

    SeminariosCursos find(Object id);

    List<SeminariosCursos> findAll();

    List<SeminariosCursos> findRange(int[] range);

    int count();
    
    SeminariosCursos findxId(Integer id);
    
    SeminariosCursos findxNombres(String nombre);
    
}
