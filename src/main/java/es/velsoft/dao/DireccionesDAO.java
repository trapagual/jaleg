/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.dao;

import es.velsoft.modelo.Direcciones;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SGEN0290
 */
public class DireccionesDAO extends GenericDAO {


    private EntityManager sesion;
    private static final Logger LOG = Logger.getLogger(PedidosDAO.class.getName());

    /**
     * Devuelve una lista de Direcciones
     *
     * @return List<Direcciones>
     */
    public List<Direcciones> getAllDirecciones() {
        Query q = null;
        List<Direcciones> l = new ArrayList<>();
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Direcciones.findAll");

            l = q.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return l;
    }

    /**
     * Obtiene un objeto Direcciones dado su ID
     * @param id
     * @return 
     */
    public Direcciones getDirById(int id) {
        Query q = null;
        Direcciones d = null;
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Direcciones.findById");
            q.setParameter("id", id);

            d = (Direcciones)q.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }  
        return d;
    }

}
