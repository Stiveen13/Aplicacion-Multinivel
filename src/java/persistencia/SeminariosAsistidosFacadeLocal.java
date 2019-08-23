/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.SeminariosAsistidos;

/**
 *
 * @author Juans
 */
@Local
public interface SeminariosAsistidosFacadeLocal {

    void create(SeminariosAsistidos seminariosAsistidos);

    void edit(SeminariosAsistidos seminariosAsistidos);

    void remove(SeminariosAsistidos seminariosAsistidos);

    SeminariosAsistidos find(Object id);

    List<SeminariosAsistidos> findAll();

    List<SeminariosAsistidos> findRange(int[] range);

    int count();
    
}
