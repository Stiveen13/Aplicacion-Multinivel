/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.SeminariosAsistidos;
import persistencia.SeminariosAsistidosFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class SeminariosAsistidosLogica implements SeminariosAsistidosLogicaLocal {
    
    @EJB
    private SeminariosAsistidosFacadeLocal seminariosAsistidosDAO;
    
    @Override
    public void registrarSeminarioAsistido(SeminariosAsistidos nuevoRegistro) throws Exception {
        seminariosAsistidosDAO.create(nuevoRegistro);
    }  

    @Override
    public List<SeminariosAsistidos> listaSeminarios() {
        return seminariosAsistidosDAO.findAll();
    }

    @Override
    public void eliminarSeminarioAsistido(SeminariosAsistidos eliminarRegistro) throws Exception {
        seminariosAsistidosDAO.remove(eliminarRegistro);
    }
}
