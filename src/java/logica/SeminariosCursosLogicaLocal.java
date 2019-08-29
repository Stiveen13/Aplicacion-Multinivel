/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.SeminariosCursos;

/**
 *
 * @author Juans
 */
@Local
public interface SeminariosCursosLogicaLocal {
    
    public List<SeminariosCursos> listaSeminariosCursos();
    public void registrarSeminarioCurso(SeminariosCursos nuevoObj) throws Exception;
    public SeminariosCursos buscarxId(Integer id);
}
