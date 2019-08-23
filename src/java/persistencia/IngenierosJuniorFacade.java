/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.IngenierosJunior;

/**
 *
 * @author Juans
 */
@Stateless
public class IngenierosJuniorFacade extends AbstractFacade<IngenierosJunior> implements IngenierosJuniorFacadeLocal {

    @PersistenceContext(unitName = "Aplicaciones_MultinivelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngenierosJuniorFacade() {
        super(IngenierosJunior.class);
    }
    
}
