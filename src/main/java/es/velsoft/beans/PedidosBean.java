package es.velsoft.beans;


import es.velsoft.dao.EntityManagerHelper;
import es.velsoft.dao.PedidosDAO;
import es.velsoft.modelo.Agentes;
import es.velsoft.modelo.Clientes;
import es.velsoft.modelo.LazyPedidosDataModel;
import es.velsoft.modelo.Pedidos;
import es.velsoft.modelo.PedidosGrid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author Alejandro
 */
@ManagedBean(name="pedidosBean")
@ViewScoped
public class PedidosBean implements Serializable {

    private static final long serialVersionUID = 7143779796955040248L;
    
    private List<PedidosGrid> pedidos;
    private List<PedidosGrid> filtrados;
    
    private Agentes detalleAgente;
    private boolean mostrarPanelAgente;
        
    private Clientes detalleCliente;   
    private boolean mostrarPanelCliente;

    private PedidosGrid selectedPedido;
    private static final Logger LOG = Logger.getLogger(PedidosBean.class.getName());


    
    LazyPedidosDataModel dataModel = new LazyPedidosDataModel();
    
    public PedidosBean() {
        this.filtrados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
       
    }
    
    public EntityManager sesion;
    
    @PostConstruct
    public void init() {
        sesion = EntityManagerHelper.getEMF().createEntityManager();
        this.detalleAgente = new Agentes();
        this.detalleCliente = new Clientes();
    }

    public LazyPedidosDataModel getDataModel() {
        return dataModel;
    }
    public LazyPedidosDataModel getModel() {
        return dataModel;
    }
    
    public List<PedidosGrid> getPedidosGrid() {
        return pedidos;
    }

    public List<PedidosGrid> getFiltrados() {
        return filtrados;
    }

    public void setFiltrados(List<PedidosGrid> filtrados) {
        this.filtrados = filtrados;
    }


    public PedidosGrid getSelectedPedido() {
        return selectedPedido;
    }

    public void setSelectedPedido(PedidosGrid selectedPedido) {
        this.selectedPedido = selectedPedido;
    }

    public boolean isMostrarPanelAgente() {
        return mostrarPanelAgente;
    }

    public void setMostrarPanelAgente(boolean mostrarPanelAgente) {
        this.mostrarPanelAgente = mostrarPanelAgente;
    }

    public Agentes getDetalleAgente() {
        return detalleAgente;
    }

    public void setDetalleAgente(Agentes detalleAgente) {
        this.detalleAgente = detalleAgente;
    }

    public Clientes getDetalleCliente() {
        return detalleCliente;
    }

    public void setDetalleCliente(Clientes detalleCliente) {
        this.detalleCliente = detalleCliente;
    }

    public boolean isMostrarPanelCliente() {
        return mostrarPanelCliente;
    }

    public void setMostrarPanelCliente(boolean mostrarPanelCliente) {
        this.mostrarPanelCliente = mostrarPanelCliente;
    }

    
    
    //////////////////// MANEJADORES DE EVENTOS //////////////////////
    public void handleAgentData(PedidosGrid p) {
        // obtener la entidad Pedidos para este id de pedido
        PedidosDAO dao = new PedidosDAO();
        int i = p.getIdPedido();
        Pedidos p2 = dao.findById(i);
        
        // de esta entidad, obtenemos el id_agente
        this.detalleAgente = p2.getAgente();
        
        // ya tenemos todos los datos; mostrar el formulario de detalle agentes
        mostrarPanelAgente = true;
        
    }

    public void handleClientData(PedidosGrid p) {
        // obtener la entidad Pedidos para este id de pedido
        PedidosDAO dao;
        Pedidos p2;
        dao = new PedidosDAO();
        p2 = dao.findById(p.getIdPedido());
        
        // de esta entidad, obtenemos el id_cliente
        this.detalleCliente = p2.getCliente();
        
        // ya tenemos todos los datos; mostrar el formulario de detalle agentes
        mostrarPanelCliente = true;
        
    }   
    
    public String cargaPedido(int id) {
        return "editPedido.xhtml?id=" + id;
    }    

}
