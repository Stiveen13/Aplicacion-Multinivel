/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Ingenieros;

/**
 *
 * @author Juans
 */
@Stateless
public class IngenierosFacade extends AbstractFacade<Ingenieros> implements IngenierosFacadeLocal {

    @PersistenceContext(unitName = "Aplicaciones_MultinivelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngenierosFacade() {
        super(Ingenieros.class);
    }

    @Override
    public Ingenieros findxCedula(Integer cedula) {
        String consulta = "SELECT i FROM Ingenieros i WHERE i.cedula =  " + cedula;
        try {
            Query query = em.createQuery(consulta);
            return (Ingenieros) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Ingenieros> ingenierosJefe() {
        String consulta = "SELECT i FROM Ingenieros i WHERE i.clase =  " + 1;
        try {
            Query query = em.createQuery(consulta);
            return (List<Ingenieros>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Ingenieros> ingenierosSenior() {
        String consulta = "SELECT i FROM Ingenieros i WHERE i.clase =  " + 2;
        try {
            Query query = em.createQuery(consulta);
            return (List<Ingenieros>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Ingenieros> ingenierosJunior() {
        String consulta = "SELECT i FROM Ingenieros i WHERE i.clase =  " + 3;
        try {
            Query query = em.createQuery(consulta);
            return (List<Ingenieros>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
