/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.dao;

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
public class TiposCargaDAO extends GenericDAO {

    private static final long serialVersionUID = 2954398918327918825L;

    private EntityManager sesion;
    private static final Logger LOG = Logger.getLogger(PedidosDAO.class.getName());

    /**
     * Devuelve una lista de TiposCarga
     *
     * @return List<TiposCarga>
     */
    public List<TiposCarga> getAllTiposCarga() {
        Query q = null;
        List<TiposCarga> l = new ArrayList<>();
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("TiposCarga.findAll");

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
