/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.dao;

import es.velsoft.modelo.Rutas;
import es.velsoft.modelo.TiposCarga;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SGEN0290
 */
public class RutasDAO extends GenericDAO {


    private EntityManager sesion;
    private static final Logger LOG = Logger.getLogger(PedidosDAO.class.getName());

    /**
     * Devuelve una lista de Rutas
     *
     * @return List<Rutas>
     */
    public List<Rutas> getAllRutas() {
        Query q = null;
        List<Rutas> l = new ArrayList<>();
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Rutas.findAll");

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
     * Devuelve solo el alias de una ruta. Es para el formulario, evitando cargar el selector de rutas
     * @return 
     */
    public String getAliasByID(int idRuta) {
        Query q = null;
        String s = null;
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Rutas.findDescByID");
            q.setParameter("id", idRuta);
            
            s = (String)q.getSingleResult();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return null; 
    }

}
