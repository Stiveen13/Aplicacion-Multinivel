/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Herramientas;

/**
 *
 * @author Juans
 */
@Stateless
public class HerramientasFacade extends AbstractFacade<Herramientas> implements HerramientasFacadeLocal {

    @PersistenceContext(unitName = "Aplicaciones_MultinivelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HerramientasFacade() {
        super(Herramientas.class);
    }
    
}
