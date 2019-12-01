/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.dao;

import es.velsoft.modelo.Clientes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SGEN0290
 */
public class ClientesDAO extends GenericDAO {


    private EntityManager sesion;
    private static final Logger LOG = Logger.getLogger(PedidosDAO.class.getName());


    /**
     * Devuelve una lista de Clientes
     * @return 
     */
    public List<Clientes> getAllClientes() {
        Query q = null;
        List<Clientes> l = new ArrayList<>();
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Clientes.findAll");
            
            l= q.getResultList();
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
