/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.TitulosAcademicos;

/**
 *
 * @author Juans
 */
@Local
public interface TitulosAcademicosLogicaLocal {
    public TitulosAcademicos buscarxId(Integer id);
    public void registrarTitulo(TitulosAcademicos nuevoTituloAcademico) throws Exception;
    public void editarTitulo(TitulosAcademicos actualizarTituloAcademico) throws Exception;
}
