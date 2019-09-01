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
import modelo.Ingenieros;

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

    @Override
    public Herramientas buscarxId(Integer id) {
        String consulta = "SELECT h FROM Herramientas h WHERE h.id = " + id;
        try {
            Query query = em.createQuery(consulta);
            return (Herramientas) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Herramientas buscarxNombre(String nombre) {
        String consulta = "SELECT h FROM Herramientas h WHERE h.nombre = " + nombre;

        try {
            Query query = em.createQuery(consulta);
            return (Herramientas) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
