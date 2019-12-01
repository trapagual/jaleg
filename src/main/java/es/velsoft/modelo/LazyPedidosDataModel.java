/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.modelo;

import es.velsoft.dao.PedidosDAO;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author SGEN0290
 */
public class LazyPedidosDataModel extends LazyDataModel<PedidosGrid> {

    private static final long serialVersionUID = 6985529279841971648L;

    private List<Pedidos> datos;
    private PedidosDAO dao = new PedidosDAO();

    public LazyPedidosDataModel() {
        this.setRowCount(dao.getCuentaTotalPedidos());
    }

    public LazyPedidosDataModel(List<Pedidos> datos) {
        this.datos = datos;
    }

    @Override
    public List<PedidosGrid> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        
        // rellenar lista
        List<PedidosGrid> data = dao.getListaPedidos(first, pageSize, filters, sortField, sortOrder);
        
        if (filters != null && filters.size() > 0 ) {
            // si no, mostrará todas las páginas, pero las del final estarán vacías        
            this.setRowCount(dao.getCuentaFiltradaPedidos(filters));
        } else {
            this.setRowCount(dao.getCuentaTotalPedidos());
        }
        
        return data;

    }
    
    @Override
    public Object getRowKey(PedidosGrid p) {
        return p != null ? p.getIdPedido() : null;
    }
    
    @Override
    public PedidosGrid getRowData(String rowKey) {
        List<PedidosGrid> lista = (List<PedidosGrid>) getWrappedData();
        Integer valor = Integer.valueOf(rowKey);
        
        for (PedidosGrid p : lista) {
            Integer idp = Integer.valueOf(p.getIdPedido());
            if (idp.equals(valor)) {
                return p;
            }
        }
        return null;
    }
}
