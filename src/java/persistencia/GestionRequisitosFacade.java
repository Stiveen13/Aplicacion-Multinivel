/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.GestionRequisitos;

/**
 *
 * @author Juans
 */
@Stateless
public class GestionRequisitosFacade extends AbstractFacade<GestionRequisitos> implements GestionRequisitosFacadeLocal {

    @PersistenceContext(unitName = "Aplicaciones_MultinivelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionRequisitosFacade() {
        super(GestionRequisitos.class);
    }
    
}
