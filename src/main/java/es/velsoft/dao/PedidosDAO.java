package es.velsoft.dao;

import es.velsoft.modelo.Pedidos;
import es.velsoft.modelo.PedidosGrid;
import es.velsoft.modelo.TiposCarga;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.primefaces.model.SortOrder;

/**
 * DAO para la lista de tablas auxiliares
 *
 * @author Alejandro
 */
public class PedidosDAO extends GenericDAO {

    private EntityManager sesion;
    private static final Logger LOG = Logger.getLogger(PedidosDAO.class.getName());

    /**
     * Este metodo no devuelve todos los pedidos, sino los filtrados y solo el
     * trozo que se muestra Devolvera los registros desde 'start', hasta
     * 'start'+'size', habiendo filtrado antes la consulta segun los filtros que
     * vienen en 'filters'.
     *
     * @param start
     * @param size
     * @param filters
     * @param sortField
     * @param sortOrder
     * @return
     */
    public List<PedidosGrid> getListaPedidos(int start, int size, Map<String, Object> filters, String sortField, SortOrder sortOrder) {

        List<PedidosGrid> listaFiltrados = new ArrayList<>();

        try {
            sesion = obtenerSessionHibernate();
            CriteriaBuilder cb = sesion.getCriteriaBuilder();
            CriteriaQuery<PedidosGrid> cq = cb.createQuery(PedidosGrid.class);
            Root<PedidosGrid> root = cq.from(PedidosGrid.class);
            CriteriaQuery<PedidosGrid> select = cq.select(root);

            // filtros
            if (filters != null && filters.size() > 0) {
                List<Predicate> predicados = new ArrayList<>();
                for (Map.Entry<String, Object> entry : filters.entrySet()) {
                    String field = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        continue;
                    }
                    Expression<String> expr = root.get(field).as(String.class);
                    Predicate p = cb.like(cb.lower(expr),
                            '%' + value.toString().toLowerCase() + '%');
                    predicados.add(p);
                }
                if (predicados.size() > 0) {
                    cq.where(cb.and(predicados.toArray(new Predicate[predicados.size()])));
                }

            }
            // ordenacion
            if (sortField != null) {
                cq.orderBy(sortOrder == SortOrder.DESCENDING
                        ? cb.asc(root.get(sortField)) : cb.desc(root.get(sortField)));
            }

            // la consulta
            TypedQuery<PedidosGrid> q = sesion.createQuery(select);
            q.setFirstResult(start);
            q.setMaxResults(size);
            listaFiltrados = q.getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error en carga: {0}", e.getLocalizedMessage());
        }

        return listaFiltrados;
    }

    /**
     * Devuelve la cuenta de los registros del total de la tabla, sin filtros
     *
     * @return
     */
    public int getCuentaTotalPedidos() {
        int cuenta = -1;

        try {
            sesion = obtenerSessionHibernate();
            Query q = sesion.createQuery("SELECT COUNT(p.id) FROM Pedidos p");
            cuenta = ((Long) q.getSingleResult()).intValue();
            LOG.log(Level.INFO, "La tabla de Pedidos tiene en total {0} registros", cuenta);

        } catch (Exception ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cuenta;
    }

    public int getCuentaFiltradaPedidos(Map<String, Object> filters) {
        Long cuenta = -1L;

        try {
            sesion = obtenerSessionHibernate();
            CriteriaBuilder cb = sesion.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<PedidosGrid> root = cq.from(PedidosGrid.class);
            CriteriaQuery<Long> select = cq.select(cb.count(root));

            // filtros
            if (filters != null && filters.size() > 0) {
                List<Predicate> predicados = new ArrayList<>();
                for (Map.Entry<String, Object> entry : filters.entrySet()) {
                    String field = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        continue;
                    }
                    Expression<String> expr = root.get(field).as(String.class);
                    Predicate p = cb.like(cb.lower(expr),
                            '%' + value.toString().toLowerCase() + '%');
                    predicados.add(p);
                }
                if (predicados.size() > 0) {
                    cq.where(cb.and(predicados.toArray(new Predicate[predicados.size()])));
                }

                // la consulta
                cuenta = sesion.createQuery(select).getSingleResult();
                LOG.log(Level.INFO, "La tabla de Pedidos FILTRADA tiene  {0} registros", cuenta);

            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error en cuenta: {0}", e.getLocalizedMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }

        return cuenta.intValue();

    }

    /**
     * Devuelve un pedido según su ID, utilizando un named query que está
     * declarado en la entidad
     *
     * @param id
     * @return
     */
    public Pedidos findById(int id) {
        Query q = null;
        Pedidos p = null;
        try {
            sesion = obtenerSessionHibernate();
            q = sesion.createNamedQuery("Pedidos.findById");
            q.setParameter("id", id);
            
            p = (Pedidos)q.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return p;
    }


}
