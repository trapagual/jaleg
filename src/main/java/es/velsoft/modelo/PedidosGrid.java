/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "vPedidosGrid")
public class PedidosGrid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPedido")
    private int idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_agente")
    private int idAgente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nAgente")
    private String nombreAgente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apAgente")
    private String apellidoAgente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nickAgente")
    private String nickAgente;
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 50)
    @Column(name = "ref_cliente")
    private String refCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "fecha_ini_servicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniServicio;
    @Column(name = "fecha_fin_servicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinServicio;


    public PedidosGrid() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public String getApellidoAgente() {
        return apellidoAgente;
    }

    public void setApellidoAgente(String apellidoAgente) {
        this.apellidoAgente = apellidoAgente;
    }

    public String getNombreAgente() {
        return nombreAgente;
    }

    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }



    public String getNickAgente() {
        return nickAgente;
    }

    public void setNickAgente(String nickAgente) {
        this.nickAgente = nickAgente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getRefCliente() {
        return refCliente;
    }

    public void setRefCliente(String refCliente) {
        this.refCliente = refCliente;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaIniServicio() {
        return fechaIniServicio;
    }

    public void setFechaIniServicio(Date fechaIniServicio) {
        this.fechaIniServicio = fechaIniServicio;
    }

    public Date getFechaFinServicio() {
        return fechaFinServicio;
    }

    public void setFechaFinServicio(Date fechaFinServicio) {
        this.fechaFinServicio = fechaFinServicio;
    }
    
}
