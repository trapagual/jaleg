/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.dao;

import es.velsoft.modelo.TiposVehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SGEN0290
 */
public class TiposVehiculoDAO extends GenericDAO {

    private static final long serialVersionUID = -2950785108092858143L;


    private EntityManager sesion;
    private static final Logger LOG = Logger.getLogger(PedidosDAO.class.getName());

    /**
     * Devuelve una lista de TiposVehiculo
     *
     * @return List<TiposVehiculo>
     */
    public List<TiposVehiculo> getAllTiposVehiculo() {
        Query q = null;
        List<TiposVehiculo> l = new ArrayList<>();
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("TiposVehiculo.findAll");

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

}
