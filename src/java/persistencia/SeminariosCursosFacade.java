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
import modelo.Herramientas;
import modelo.SeminariosCursos;

/**
 *
 * @author Juans
 */
@Stateless
public class SeminariosCursosFacade extends AbstractFacade<SeminariosCursos> implements SeminariosCursosFacadeLocal {

    @PersistenceContext(unitName = "Aplicaciones_MultinivelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeminariosCursosFacade() {
        super(SeminariosCursos.class);
    }

    @Override
    public SeminariosCursos findxId(Integer id) {
        String consulta = "SELECT s FROM SeminariosCursos s WHERE s.id = " + id;
        try {
            Query query = em.createQuery(consulta);
            return (SeminariosCursos) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
