package es.velsoft.beans;

import es.velsoft.dao.ClientesDAO;
import es.velsoft.dao.PedidosDAO;
import es.velsoft.dao.RutasDAO;
import es.velsoft.dao.TiposCargaDAO;
import es.velsoft.dao.TiposVehiculoDAO;
import es.velsoft.modelo.Clientes;
import es.velsoft.modelo.Pedidos;
import es.velsoft.modelo.TiposCarga;
import es.velsoft.modelo.TiposVehiculo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Alejandro
 */
@ManagedBean(name = "epBean")
@ViewScoped
public class EditPedidoBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(EditPedidoBean.class.getName());

    private static final long serialVersionUID = 4015919747385367318L;

    private PedidosDAO dao;
    private Pedidos pedido;

    private List<TiposCarga> tiposCarga;
    private List<TiposVehiculo> tiposVehiculo;
    
    private List<Clientes> clientes;

    private TiposCarga tc;
    private TiposVehiculo tv;
    
    private String aliasRuta;
    private Double jornadasTeoricas = 0.00;
    private Double costeJornadaTeorica = 0.00;
    

    private EntityManager sesion;

    public EditPedidoBean() {

    }

    @PostConstruct
    public void init() {
        
        // el dao
        dao = new PedidosDAO();
        
        // obtener parametros get
        int id;
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String elId = params.get("id");

        // cargar el pedido que nos viene por parametro
        cargaPedido(Integer.parseInt(elId));

        // cargar los tipos de carga y los vehiculos
        cargaSelectores();

        // cargar el objeto auxiliar para que en el SelectOneMenu venga seleccionado el valor que tiene el objeto al cargarlo
        tc = new TiposCarga(pedido.getIdTipoCarga());
        tv = new TiposVehiculo(pedido.getIdTipoVehiculo());

    }

    public void cargaPedido(int id) {
        this.pedido = dao.findById(id);
    }

    public void cargaSelectores() {
        TiposCargaDAO tcdao = new TiposCargaDAO();
        tiposCarga = tcdao.getAllTiposCarga();
        TiposVehiculoDAO tvdao = new TiposVehiculoDAO();
        tiposVehiculo = tvdao.getAllTiposVehiculo();
        ClientesDAO cldao = new ClientesDAO();
        clientes = cldao.getAllClientes();
        RutasDAO rdao = new RutasDAO();
        aliasRuta = rdao.getAliasByID(this.pedido.getIdRuta());
    }
    
    ///////////////////// GETTERS - SETTERS ////////////////////////////
    public Pedidos getPedido() {
        return pedido;
    }

    public List<TiposCarga> getTiposCarga() {
        return tiposCarga;
    }

    public List<TiposVehiculo> getTiposVehiculo() {
        return tiposVehiculo;
    }

    public TiposCarga getTc() {
        return tc;
    }

    public void setTc(TiposCarga tc) {
        this.tc = tc;
        // cargar tambien la propiedad del Pedido porque no lo hemos
        // declarado como relación para evitar selects innecesarios
        this.pedido.setIdTipoCarga(tc.getId());
    }

    public TiposVehiculo getTv() {
        return tv;
    }

    public void setTv(TiposVehiculo tv) {
        this.tv = tv;
        // cargar tambien la propiedad del Pedido porque no lo hemos
        // declarado como relación para evitar selects innecesarios
        this.pedido.setIdTipoVehiculo(tv.getId());
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
    

       
    public String getAliasRuta() {
        return aliasRuta;
    }

    public void setAliasRuta(String aliasRuta) {
        this.aliasRuta = aliasRuta;
    }

    public Double getJornadasTeoricas() {
        return jornadasTeoricas;
    }

    public void setJornadasTeoricas(Double jornadasTeoricas) {
        this.jornadasTeoricas = jornadasTeoricas;
    }

    public Double getCosteJornadaTeorica() {
        return costeJornadaTeorica;
    }

    public void setCosteJornadaTeorica(Double costeJornadaTeorica) {
        this.costeJornadaTeorica = costeJornadaTeorica;
    }


}
