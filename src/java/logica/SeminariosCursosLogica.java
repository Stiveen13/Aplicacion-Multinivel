/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.SeminariosCursos;
import persistencia.SeminariosCursosFacadeLocal;

/**
 *
 * @author Juans
 */
@Stateless
public class SeminariosCursosLogica implements SeminariosCursosLogicaLocal {
    
    @EJB
    private SeminariosCursosFacadeLocal seminariosCursosDAO;

    @Override
    public List<SeminariosCursos> listaSeminariosCursos() {
        return seminariosCursosDAO.findAll();
    }

    @Override
    public void registrarSeminarioCurso(SeminariosCursos nuevoObj) throws Exception {
        seminariosCursosDAO.create(nuevoObj);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public SeminariosCursos buscarxId(Integer id) {
        return seminariosCursosDAO.findxId(id);
    }

    @Override
    public void editarSeminarioCurso(SeminariosCursos editSeminario) throws Exception {
        if(editSeminario == null){
            throw new Exception("Ningun seminario o curso seleccionado");
        }
        
        seminariosCursosDAO.edit(editSeminario);
    }

    @Override
    public void eliminarSeminarioCurso(SeminariosCursos eliminarSeminario) throws Exception {
        if(eliminarSeminario == null){
            throw new Exception("Ningun seminario o curso seleccionado");
        }
        
        seminariosCursosDAO.remove(eliminarSeminario);
    }

    @Override
    public SeminariosCursos buscarxNombre(String nombre) {
        return seminariosCursosDAO.findxNombres(nombre);
    }
}
