/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.SeminariosAsistidos;

/**
 *
 * @author Juans
 */
@Local
public interface SeminariosAsistidosLogicaLocal {
    public List<SeminariosAsistidos> listaSeminarios();
    public void registrarSeminarioAsistido(SeminariosAsistidos nuevoRegistro) throws Exception;
    public void eliminarSeminarioAsistido(SeminariosAsistidos eliminarRegistro) throws Exception;
}
