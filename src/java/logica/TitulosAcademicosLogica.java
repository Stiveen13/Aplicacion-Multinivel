/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.TitulosAcademicos;
import persistencia.TitulosAcademicosFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class TitulosAcademicosLogica implements TitulosAcademicosLogicaLocal {
    
    @EJB
    private TitulosAcademicosFacadeLocal titulosAcademicosDAO;
    
    @Override
    public TitulosAcademicos buscarxId(Integer id) {
        return titulosAcademicosDAO.find(id);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrarTitulo(TitulosAcademicos nuevoTituloAcademico) throws Exception {
        
        if(nuevoTituloAcademico.getTituloObtenido().equals("")){
            throw new Exception("El nombre del titulo es obligatorio");
        }
        
        if(nuevoTituloAcademico.getInstitucion().equals("")){
            throw new Exception("El nombre de la institució es obligatorio");
        }
       
        titulosAcademicosDAO.create(nuevoTituloAcademico);
    }
    
    @Override
    public void editarTitulo(TitulosAcademicos actualizarTituloAcademico) throws Exception {
        titulosAcademicosDAO.edit(actualizarTituloAcademico);
    }
}
