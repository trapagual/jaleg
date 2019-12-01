/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.dao;

import es.velsoft.modelo.Servicios;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SGEN0290
 */
public class ServiciosDAO extends GenericDAO {


    private EntityManager sesion;
    private static final Logger LOG = Logger.getLogger(PedidosDAO.class.getName());

    /**
     * Devuelve una lista de Rutas
     *
     * @return List<Rutas>
     */
    public List<Servicios> getAllServicios() {
        Query q = null;
        List<Servicios> l = new ArrayList<>();
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Servicios.findAll");

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
     * Obtener los servicios que dependen de un pedido determinado
     * @param idPedido
     * @return 
     */
    public List<Servicios> getSvcByIdPedido(int idPedido) {
        Query q = null;
        List<Servicios> l = new ArrayList<>();
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Servicios.findByIdSeervicio");
            q.setParameter("idPedido", idPedido);

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
