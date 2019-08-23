/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.RequisitosProyecto;

/**
 *
 * @author Juans
 */
@Stateless
public class RequisitosProyectoFacade extends AbstractFacade<RequisitosProyecto> implements RequisitosProyectoFacadeLocal {

    @PersistenceContext(unitName = "Aplicaciones_MultinivelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequisitosProyectoFacade() {
        super(RequisitosProyecto.class);
    }
    
}
