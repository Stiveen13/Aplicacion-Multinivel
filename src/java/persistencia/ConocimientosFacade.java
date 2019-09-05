/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Conocimientos;

/**
 *
 * @author Juans
 */
@Stateless
public class ConocimientosFacade extends AbstractFacade<Conocimientos> implements ConocimientosFacadeLocal {

    @PersistenceContext(unitName = "Aplicaciones_MultinivelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConocimientosFacade() {
        super(Conocimientos.class);
    }

    @Override
    public Conocimientos findxId(Integer id) {
        String consulta = "SELECT c FROM Conocimientos c WHERE c.id = " + id;

        try {
            Query query = em.createQuery(consulta);
            return (Conocimientos) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
