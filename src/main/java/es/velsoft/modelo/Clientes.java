/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author velsoft
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c ORDER BY c.nombreComercial")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodCliente")
    private int codCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NombreComercial")
    private String nombreComercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Apellido2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Alias")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CodTipoVia")
    private String codTipoVia;
    @Size(max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 30)
    @Column(name = "Numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "APTDOCorreos")
    private String aPTDOCorreos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Cif")
    private String cif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SufijoMunicipio")
    private String sufijoMunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodMunicipio")
    private int codMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PrefijoMunicipio")
    private String prefijoMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CP")
    private String cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Baja")
    private boolean baja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Completo")
    private int completo;
    @Column(name = "CodFormaPago")
    private Integer codFormaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DC")
    private String dc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Cuenta")
    private String cuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Entidad")
    private String entidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Oficina")
    private String oficina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CuentaContable")
    private String cuentaContable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CuentaCobro")
    private String cuentaCobro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CuentaCompensacion")
    private String cuentaCompensacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DtoProntoPago")
    private BigDecimal dtoProntoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AgruparFactura")
    private boolean agruparFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ConformeObligatorio")
    private boolean conformeObligatorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiaFijoPago1")
    private int diaFijoPago1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiaFijoPago2")
    private int diaFijoPago2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiaFijoPago3")
    private int diaFijoPago3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodIVA")
    private int codIVA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Swift")
    private String swift;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "IBAN")
    private String iban;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ObserFac")
    private String obserFac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LimiteCredito")
    private BigDecimal limiteCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RiesgoPropuesto")
    private BigDecimal riesgoPropuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PlazoCobro")
    private int plazoCobro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodAgente")
    private int codAgente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodPais")
    private int codPais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PendienteFacturar")
    private BigDecimal pendienteFacturar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FacturasPendientes")
    private BigDecimal facturasPendientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OtrosPendientes")
    private BigDecimal otrosPendientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EfectosPendientes")
    private BigDecimal efectosPendientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodProveedor")
    private int codProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Personalidad")
    private String personalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CalcVTOSobreFactura")
    private boolean calcVTOSobreFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComisionFija")
    private BigDecimal comisionFija;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DescuentoFijo")
    private BigDecimal descuentoFijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BloquearCyC")
    private boolean bloquearCyC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ActuaComoBase")
    private boolean actuaComoBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SiempreIntercambioPalets")
    private boolean siempreIntercambioPalets;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CertAEATEnviado")
    private boolean certAEATEnviado;
    @Column(name = "FechaEnvioAEAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvioAEAT;
    @Column(name = "FechaSolicitudAEAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitudAEAT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Principal")
    private boolean principal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EnviarCorreoHC")
    private boolean enviarCorreoHC;
    @Size(max = 200)
    @Column(name = "DestinatarioCorreoHC")
    private String destinatarioCorreoHC;
    @Column(name = "tipofacturacion")
    private String tipofacturacion;
    @Column(name = "ncopiasfactura")
    private Integer ncopiasfactura;
    @Column(name = "diasexcesoaceptados")
    private Integer diasexcesoaceptados;
    @Column(name = "ignorardiasexceso")
    private Boolean ignorardiasexceso;
    @Size(max = 500)
    @Column(name = "ExcesoDias_Observ")
    private String excesoDiasObserv;
    @Size(max = 20)
    @Column(name = "excesodias_usuario")
    private String excesodiasUsuario;
    @Size(max = 300)
    @Column(name = "MotivoBLoqueoCyC")
    private String motivoBLoqueoCyC;
    @Column(name = "Req_Seguimiento_temperatura")
    private Boolean reqSeguimientotemperatura;
    @Column(name = "Req_Lavado_Requerido")
    private Boolean reqLavadoRequerido;
    @Column(name = "Req_Equipamiento_Seguridad_Oblig")
    private Boolean reqEquipamientoSeguridadOblig;
    @Column(name = "Req_Frigo_Incompatible")
    private Boolean reqFrigoIncompatible;
    @Column(name = "Req_Intercambio_Palets")
    private Boolean reqIntercambioPalets;
    @Column(name = "Req_Grupaje")
    private Boolean reqGrupaje;
    @Column(name = "Req_Mercancia_Industria")
    private Boolean reqMercanciaIndustria;
    @Column(name = "Req_Mercancia_Perecedera")
    private Boolean reqMercanciaPerecedera;
    @Column(name = "Req_Mercancia_congelada")
    private Boolean reqMercanciacongelada;
    @Column(name = "Req_Incotermo_Especial")
    private Boolean reqIncotermoEspecial;
    @Size(max = 500)
    @Column(name = "Req_Observaciones")
    private String reqObservaciones;
    @Size(max = 20)
    @Column(name = "xusr")
    private String xusr;
    @Column(name = "xfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xfec;
    @Size(max = 20)
    @Column(name = "xord")
    private String xord;
    @Size(max = 20)
    @Column(name = "CodigoEAN")
    private String codigoEAN;
    @Size(max = 10)
    @Column(name = "PasswordWeb")
    private String passwordWeb;
    @Column(name = "CodClienteFacturacion")
    private Integer codClienteFacturacion;
    @Column(name = "idSector")
    private Integer idSector;
    @Column(name = "ExcluirMargen")
    private Boolean excluirMargen;
    @Column(name = "CodTipoMercancia")
    private Integer codTipoMercancia;
    @Column(name = "Req_ObsIntroducidas")
    private Boolean reqObsIntroducidas;
    @Column(name = "ControlCalidad")
    private Boolean controlCalidad;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "AnexoHC")
    private String anexoHC;
    @Column(name = "fechaconcesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaconcesion;
    @Column(name = "fechaconcesioninicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaconcesioninicial;
    @Column(name = "fechaconfirmacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaconfirmacion;
    @Size(max = 15)
    @Column(name = "CodigoCyC")
    private String codigoCyC;
    @Column(name = "riesgogerencia")
    private BigDecimal riesgogerencia;
    @Column(name = "fechariesgogerencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechariesgogerencia;
    @Column(name = "StatusCliente")
    private Integer statusCliente;
    @Size(max = 9)
    @Column(name = "CtaVinculada")
    private String ctaVinculada;
    @Column(name = "DiasExceso")
    private Integer diasExceso;
    @Column(name = "PromedioCobro")
    private Integer promedioCobro;
    @Size(max = 100)
    @Column(name = "ObservacionesCobro")
    private String observacionesCobro;
    @Column(name = "EnviarFax")
    private Boolean enviarFax;
    @Column(name = "EnviarEmail")
    private Boolean enviarEmail;
    @Column(name = "EntregadaDoc")
    private Boolean entregadaDoc;
    @Column(name = "claveclipro")
    private String claveclipro;
    @Column(name = "Dec347")
    private Boolean dec347;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Comentario")
    private String comentario;
    @Size(max = 20)
    @Column(name = "Telefono1")
    private String telefono1;
    @Size(max = 20)
    @Column(name = "Telefono2")
    private String telefono2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "ImporteExcedido")
    private BigDecimal importeExcedido;
    @Size(max = 20)
    @Column(name = "REM_Cref")
    private String rEMCref;
    @Size(max = 50)
    @Column(name = "REM_Nombre")
    private String rEMNombre;
    @Size(max = 50)
    @Column(name = "REM_Apellido1")
    private String rEMApellido1;
    @Size(max = 50)
    @Column(name = "REM_Apellido2")
    private String rEMApellido2;
    @Size(max = 10)
    @Column(name = "REM_Banco")
    private String rEMBanco;
    @Size(max = 10)
    @Column(name = "REM_Sucursal")
    private String rEMSucursal;
    @Size(max = 5)
    @Column(name = "REM_Digito")
    private String rEMDigito;
    @Size(max = 20)
    @Column(name = "REM_Cuenta")
    private String rEMCuenta;
    @Column(name = "IdBancoFactura")
    private Integer idBancoFactura;
    @Column(name = "Factorizar")
    private Boolean factorizar;
    @Column(name = "factorizar_codbanco")
    private Integer factorizarCodbanco;
    @Column(name = "FechaFinRiesgoGerencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinRiesgoGerencia;
    @Column(name = "ReferenciaObligatoria")
    private Boolean referenciaObligatoria;
    @Size(max = 20)
    @Column(name = "Autor")
    private String autor;
    @Column(name = "FechaInsercion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInsercion;
    @Column(name = "ASTRE")
    private Boolean astre;
    @Column(name = "Deshabilitado")
    private Boolean deshabilitado;
    @Column(name = "Autofactura")
    private Boolean autofactura;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    
    @OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
    private List<Pedidos> pedidos;    
    
    
    public Clientes() {
    }

    public Clientes(Integer id) {
        this.id = id;
    }

    public Clientes(Integer id, int codCliente, String nombreComercial, String nombre, String apellido1, String apellido2, String alias, String codTipoVia, String aPTDOCorreos, String cif, String sufijoMunicipio, int codMunicipio, String prefijoMunicipio, String cp, String observaciones, boolean baja, int completo, String dc, String cuenta, String entidad, String oficina, String cuentaContable, String cuentaCobro, String cuentaCompensacion, BigDecimal dtoProntoPago, boolean agruparFactura, boolean conformeObligatorio, int diaFijoPago1, int diaFijoPago2, int diaFijoPago3, int codIVA, String swift, String iban, String obserFac, BigDecimal limiteCredito, BigDecimal riesgoPropuesto, int plazoCobro, int codAgente, int codPais, BigDecimal pendienteFacturar, BigDecimal facturasPendientes, BigDecimal otrosPendientes, BigDecimal efectosPendientes, int codProveedor, String personalidad, boolean calcVTOSobreFactura, BigDecimal comisionFija, BigDecimal descuentoFijo, boolean bloquearCyC, boolean actuaComoBase, boolean siempreIntercambioPalets, boolean certAEATEnviado, boolean principal, boolean enviarCorreoHC) {
        this.id = id;
        this.codCliente = codCliente;
        this.nombreComercial = nombreComercial;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.alias = alias;
        this.codTipoVia = codTipoVia;
        this.aPTDOCorreos = aPTDOCorreos;
        this.cif = cif;
        this.sufijoMunicipio = sufijoMunicipio;
        this.codMunicipio = codMunicipio;
        this.prefijoMunicipio = prefijoMunicipio;
        this.cp = cp;
        this.observaciones = observaciones;
        this.baja = baja;
        this.completo = completo;
        this.dc = dc;
        this.cuenta = cuenta;
        this.entidad = entidad;
        this.oficina = oficina;
        this.cuentaContable = cuentaContable;
        this.cuentaCobro = cuentaCobro;
        this.cuentaCompensacion = cuentaCompensacion;
        this.dtoProntoPago = dtoProntoPago;
        this.agruparFactura = agruparFactura;
        this.conformeObligatorio = conformeObligatorio;
        this.diaFijoPago1 = diaFijoPago1;
        this.diaFijoPago2 = diaFijoPago2;
        this.diaFijoPago3 = diaFijoPago3;
        this.codIVA = codIVA;
        this.swift = swift;
        this.iban = iban;
        this.obserFac = obserFac;
        this.limiteCredito = limiteCredito;
        this.riesgoPropuesto = riesgoPropuesto;
        this.plazoCobro = plazoCobro;
        this.codAgente = codAgente;
        this.codPais = codPais;
        this.pendienteFacturar = pendienteFacturar;
        this.facturasPendientes = facturasPendientes;
        this.otrosPendientes = otrosPendientes;
        this.efectosPendientes = efectosPendientes;
        this.codProveedor = codProveedor;
        this.personalidad = personalidad;
        this.calcVTOSobreFactura = calcVTOSobreFactura;
        this.comisionFija = comisionFija;
        this.descuentoFijo = descuentoFijo;
        this.bloquearCyC = bloquearCyC;
        this.actuaComoBase = actuaComoBase;
        this.siempreIntercambioPalets = siempreIntercambioPalets;
        this.certAEATEnviado = certAEATEnviado;
        this.principal = principal;
        this.enviarCorreoHC = enviarCorreoHC;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCodTipoVia() {
        return codTipoVia;
    }

    public void setCodTipoVia(String codTipoVia) {
        this.codTipoVia = codTipoVia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAPTDOCorreos() {
        return aPTDOCorreos;
    }

    public void setAPTDOCorreos(String aPTDOCorreos) {
        this.aPTDOCorreos = aPTDOCorreos;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getSufijoMunicipio() {
        return sufijoMunicipio;
    }

    public void setSufijoMunicipio(String sufijoMunicipio) {
        this.sufijoMunicipio = sufijoMunicipio;
    }

    public int getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getPrefijoMunicipio() {
        return prefijoMunicipio;
    }

    public void setPrefijoMunicipio(String prefijoMunicipio) {
        this.prefijoMunicipio = prefijoMunicipio;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public int getCompleto() {
        return completo;
    }

    public void setCompleto(int completo) {
        this.completo = completo;
    }

    public Integer getCodFormaPago() {
        return codFormaPago;
    }

    public void setCodFormaPago(Integer codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(String cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }

    public String getCuentaCompensacion() {
        return cuentaCompensacion;
    }

    public void setCuentaCompensacion(String cuentaCompensacion) {
        this.cuentaCompensacion = cuentaCompensacion;
    }

    public BigDecimal getDtoProntoPago() {
        return dtoProntoPago;
    }

    public void setDtoProntoPago(BigDecimal dtoProntoPago) {
        this.dtoProntoPago = dtoProntoPago;
    }

    public boolean getAgruparFactura() {
        return agruparFactura;
    }

    public void setAgruparFactura(boolean agruparFactura) {
        this.agruparFactura = agruparFactura;
    }

    public boolean getConformeObligatorio() {
        return conformeObligatorio;
    }

    public void setConformeObligatorio(boolean conformeObligatorio) {
        this.conformeObligatorio = conformeObligatorio;
    }

    public int getDiaFijoPago1() {
        return diaFijoPago1;
    }

    public void setDiaFijoPago1(int diaFijoPago1) {
        this.diaFijoPago1 = diaFijoPago1;
    }

    public int getDiaFijoPago2() {
        return diaFijoPago2;
    }

    public void setDiaFijoPago2(int diaFijoPago2) {
        this.diaFijoPago2 = diaFijoPago2;
    }

    public int getDiaFijoPago3() {
        return diaFijoPago3;
    }

    public void setDiaFijoPago3(int diaFijoPago3) {
        this.diaFijoPago3 = diaFijoPago3;
    }

    public int getCodIVA() {
        return codIVA;
    }

    public void setCodIVA(int codIVA) {
        this.codIVA = codIVA;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getObserFac() {
        return obserFac;
    }

    public void setObserFac(String obserFac) {
        this.obserFac = obserFac;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public BigDecimal getRiesgoPropuesto() {
        return riesgoPropuesto;
    }

    public void setRiesgoPropuesto(BigDecimal riesgoPropuesto) {
        this.riesgoPropuesto = riesgoPropuesto;
    }

    public int getPlazoCobro() {
        return plazoCobro;
    }

    public void setPlazoCobro(int plazoCobro) {
        this.plazoCobro = plazoCobro;
    }

    public int getCodAgente() {
        return codAgente;
    }

    public void setCodAgente(int codAgente) {
        this.codAgente = codAgente;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public BigDecimal getPendienteFacturar() {
        return pendienteFacturar;
    }

    public void setPendienteFacturar(BigDecimal pendienteFacturar) {
        this.pendienteFacturar = pendienteFacturar;
    }

    public BigDecimal getFacturasPendientes() {
        return facturasPendientes;
    }

    public void setFacturasPendientes(BigDecimal facturasPendientes) {
        this.facturasPendientes = facturasPendientes;
    }

    public BigDecimal getOtrosPendientes() {
        return otrosPendientes;
    }

    public void setOtrosPendientes(BigDecimal otrosPendientes) {
        this.otrosPendientes = otrosPendientes;
    }

    public BigDecimal getEfectosPendientes() {
        return efectosPendientes;
    }

    public void setEfectosPendientes(BigDecimal efectosPendientes) {
        this.efectosPendientes = efectosPendientes;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public boolean getCalcVTOSobreFactura() {
        return calcVTOSobreFactura;
    }

    public void setCalcVTOSobreFactura(boolean calcVTOSobreFactura) {
        this.calcVTOSobreFactura = calcVTOSobreFactura;
    }

    public BigDecimal getComisionFija() {
        return comisionFija;
    }

    public void setComisionFija(BigDecimal comisionFija) {
        this.comisionFija = comisionFija;
    }

    public BigDecimal getDescuentoFijo() {
        return descuentoFijo;
    }

    public void setDescuentoFijo(BigDecimal descuentoFijo) {
        this.descuentoFijo = descuentoFijo;
    }

    public boolean getBloquearCyC() {
        return bloquearCyC;
    }

    public void setBloquearCyC(boolean bloquearCyC) {
        this.bloquearCyC = bloquearCyC;
    }

    public boolean getActuaComoBase() {
        return actuaComoBase;
    }

    public void setActuaComoBase(boolean actuaComoBase) {
        this.actuaComoBase = actuaComoBase;
    }

    public boolean getSiempreIntercambioPalets() {
        return siempreIntercambioPalets;
    }

    public void setSiempreIntercambioPalets(boolean siempreIntercambioPalets) {
        this.siempreIntercambioPalets = siempreIntercambioPalets;
    }

    public boolean getCertAEATEnviado() {
        return certAEATEnviado;
    }

    public void setCertAEATEnviado(boolean certAEATEnviado) {
        this.certAEATEnviado = certAEATEnviado;
    }

    public Date getFechaEnvioAEAT() {
        return fechaEnvioAEAT;
    }

    public void setFechaEnvioAEAT(Date fechaEnvioAEAT) {
        this.fechaEnvioAEAT = fechaEnvioAEAT;
    }

    public Date getFechaSolicitudAEAT() {
        return fechaSolicitudAEAT;
    }

    public void setFechaSolicitudAEAT(Date fechaSolicitudAEAT) {
        this.fechaSolicitudAEAT = fechaSolicitudAEAT;
    }

    public boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public boolean getEnviarCorreoHC() {
        return enviarCorreoHC;
    }

    public void setEnviarCorreoHC(boolean enviarCorreoHC) {
        this.enviarCorreoHC = enviarCorreoHC;
    }

    public String getDestinatarioCorreoHC() {
        return destinatarioCorreoHC;
    }

    public void setDestinatarioCorreoHC(String destinatarioCorreoHC) {
        this.destinatarioCorreoHC = destinatarioCorreoHC;
    }

    public String getTipofacturacion() {
        return tipofacturacion;
    }

    public void setTipofacturacion(String tipofacturacion) {
        this.tipofacturacion = tipofacturacion;
    }

    public Integer getNcopiasfactura() {
        return ncopiasfactura;
    }

    public void setNcopiasfactura(Integer ncopiasfactura) {
        this.ncopiasfactura = ncopiasfactura;
    }

    public Integer getDiasexcesoaceptados() {
        return diasexcesoaceptados;
    }

    public void setDiasexcesoaceptados(Integer diasexcesoaceptados) {
        this.diasexcesoaceptados = diasexcesoaceptados;
    }

    public Boolean getIgnorardiasexceso() {
        return ignorardiasexceso;
    }

    public void setIgnorardiasexceso(Boolean ignorardiasexceso) {
        this.ignorardiasexceso = ignorardiasexceso;
    }

    public String getExcesoDiasObserv() {
        return excesoDiasObserv;
    }

    public void setExcesoDiasObserv(String excesoDiasObserv) {
        this.excesoDiasObserv = excesoDiasObserv;
    }

    public String getExcesodiasUsuario() {
        return excesodiasUsuario;
    }

    public void setExcesodiasUsuario(String excesodiasUsuario) {
        this.excesodiasUsuario = excesodiasUsuario;
    }

    public String getMotivoBLoqueoCyC() {
        return motivoBLoqueoCyC;
    }

    public void setMotivoBLoqueoCyC(String motivoBLoqueoCyC) {
        this.motivoBLoqueoCyC = motivoBLoqueoCyC;
    }

    public Boolean getReqSeguimientotemperatura() {
        return reqSeguimientotemperatura;
    }

    public void setReqSeguimientotemperatura(Boolean reqSeguimientotemperatura) {
        this.reqSeguimientotemperatura = reqSeguimientotemperatura;
    }

    public Boolean getReqLavadoRequerido() {
        return reqLavadoRequerido;
    }

    public void setReqLavadoRequerido(Boolean reqLavadoRequerido) {
        this.reqLavadoRequerido = reqLavadoRequerido;
    }

    public Boolean getReqEquipamientoSeguridadOblig() {
        return reqEquipamientoSeguridadOblig;
    }

    public void setReqEquipamientoSeguridadOblig(Boolean reqEquipamientoSeguridadOblig) {
        this.reqEquipamientoSeguridadOblig = reqEquipamientoSeguridadOblig;
    }

    public Boolean getReqFrigoIncompatible() {
        return reqFrigoIncompatible;
    }

    public void setReqFrigoIncompatible(Boolean reqFrigoIncompatible) {
        this.reqFrigoIncompatible = reqFrigoIncompatible;
    }

    public Boolean getReqIntercambioPalets() {
        return reqIntercambioPalets;
    }

    public void setReqIntercambioPalets(Boolean reqIntercambioPalets) {
        this.reqIntercambioPalets = reqIntercambioPalets;
    }

    public Boolean getReqGrupaje() {
        return reqGrupaje;
    }

    public void setReqGrupaje(Boolean reqGrupaje) {
        this.reqGrupaje = reqGrupaje;
    }

    public Boolean getReqMercanciaIndustria() {
        return reqMercanciaIndustria;
    }

    public void setReqMercanciaIndustria(Boolean reqMercanciaIndustria) {
        this.reqMercanciaIndustria = reqMercanciaIndustria;
    }

    public Boolean getReqMercanciaPerecedera() {
        return reqMercanciaPerecedera;
    }

    public void setReqMercanciaPerecedera(Boolean reqMercanciaPerecedera) {
        this.reqMercanciaPerecedera = reqMercanciaPerecedera;
    }

    public Boolean getReqMercanciacongelada() {
        return reqMercanciacongelada;
    }

    public void setReqMercanciacongelada(Boolean reqMercanciacongelada) {
        this.reqMercanciacongelada = reqMercanciacongelada;
    }

    public Boolean getReqIncotermoEspecial() {
        return reqIncotermoEspecial;
    }

    public void setReqIncotermoEspecial(Boolean reqIncotermoEspecial) {
        this.reqIncotermoEspecial = reqIncotermoEspecial;
    }

    public String getReqObservaciones() {
        return reqObservaciones;
    }

    public void setReqObservaciones(String reqObservaciones) {
        this.reqObservaciones = reqObservaciones;
    }

    public String getXusr() {
        return xusr;
    }

    public void setXusr(String xusr) {
        this.xusr = xusr;
    }

    public Date getXfec() {
        return xfec;
    }

    public void setXfec(Date xfec) {
        this.xfec = xfec;
    }

    public String getXord() {
        return xord;
    }

    public void setXord(String xord) {
        this.xord = xord;
    }

    public String getCodigoEAN() {
        return codigoEAN;
    }

    public void setCodigoEAN(String codigoEAN) {
        this.codigoEAN = codigoEAN;
    }

    public String getPasswordWeb() {
        return passwordWeb;
    }

    public void setPasswordWeb(String passwordWeb) {
        this.passwordWeb = passwordWeb;
    }

    public Integer getCodClienteFacturacion() {
        return codClienteFacturacion;
    }

    public void setCodClienteFacturacion(Integer codClienteFacturacion) {
        this.codClienteFacturacion = codClienteFacturacion;
    }

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

    public Boolean getExcluirMargen() {
        return excluirMargen;
    }

    public void setExcluirMargen(Boolean excluirMargen) {
        this.excluirMargen = excluirMargen;
    }

    public Integer getCodTipoMercancia() {
        return codTipoMercancia;
    }

    public void setCodTipoMercancia(Integer codTipoMercancia) {
        this.codTipoMercancia = codTipoMercancia;
    }

    public Boolean getReqObsIntroducidas() {
        return reqObsIntroducidas;
    }

    public void setReqObsIntroducidas(Boolean reqObsIntroducidas) {
        this.reqObsIntroducidas = reqObsIntroducidas;
    }

    public Boolean getControlCalidad() {
        return controlCalidad;
    }

    public void setControlCalidad(Boolean controlCalidad) {
        this.controlCalidad = controlCalidad;
    }

    public String getAnexoHC() {
        return anexoHC;
    }

    public void setAnexoHC(String anexoHC) {
        this.anexoHC = anexoHC;
    }

    public Date getFechaconcesion() {
        return fechaconcesion;
    }

    public void setFechaconcesion(Date fechaconcesion) {
        this.fechaconcesion = fechaconcesion;
    }

    public Date getFechaconcesioninicial() {
        return fechaconcesioninicial;
    }

    public void setFechaconcesioninicial(Date fechaconcesioninicial) {
        this.fechaconcesioninicial = fechaconcesioninicial;
    }

    public Date getFechaconfirmacion() {
        return fechaconfirmacion;
    }

    public void setFechaconfirmacion(Date fechaconfirmacion) {
        this.fechaconfirmacion = fechaconfirmacion;
    }

    public String getCodigoCyC() {
        return codigoCyC;
    }

    public void setCodigoCyC(String codigoCyC) {
        this.codigoCyC = codigoCyC;
    }

    public BigDecimal getRiesgogerencia() {
        return riesgogerencia;
    }

    public void setRiesgogerencia(BigDecimal riesgogerencia) {
        this.riesgogerencia = riesgogerencia;
    }

    public Date getFechariesgogerencia() {
        return fechariesgogerencia;
    }

    public void setFechariesgogerencia(Date fechariesgogerencia) {
        this.fechariesgogerencia = fechariesgogerencia;
    }

    public Integer getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(Integer statusCliente) {
        this.statusCliente = statusCliente;
    }

    public String getCtaVinculada() {
        return ctaVinculada;
    }

    public void setCtaVinculada(String ctaVinculada) {
        this.ctaVinculada = ctaVinculada;
    }

    public Integer getDiasExceso() {
        return diasExceso;
    }

    public void setDiasExceso(Integer diasExceso) {
        this.diasExceso = diasExceso;
    }

    public Integer getPromedioCobro() {
        return promedioCobro;
    }

    public void setPromedioCobro(Integer promedioCobro) {
        this.promedioCobro = promedioCobro;
    }

    public String getObservacionesCobro() {
        return observacionesCobro;
    }

    public void setObservacionesCobro(String observacionesCobro) {
        this.observacionesCobro = observacionesCobro;
    }

    public Boolean getEnviarFax() {
        return enviarFax;
    }

    public void setEnviarFax(Boolean enviarFax) {
        this.enviarFax = enviarFax;
    }

    public Boolean getEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(Boolean enviarEmail) {
        this.enviarEmail = enviarEmail;
    }

    public Boolean getEntregadaDoc() {
        return entregadaDoc;
    }

    public void setEntregadaDoc(Boolean entregadaDoc) {
        this.entregadaDoc = entregadaDoc;
    }

    public String getClaveclipro() {
        return claveclipro;
    }

    public void setClaveclipro(String claveclipro) {
        this.claveclipro = claveclipro;
    }

    public Boolean getDec347() {
        return dec347;
    }

    public void setDec347(Boolean dec347) {
        this.dec347 = dec347;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getImporteExcedido() {
        return importeExcedido;
    }

    public void setImporteExcedido(BigDecimal importeExcedido) {
        this.importeExcedido = importeExcedido;
    }

    public String getREMCref() {
        return rEMCref;
    }

    public void setREMCref(String rEMCref) {
        this.rEMCref = rEMCref;
    }

    public String getREMNombre() {
        return rEMNombre;
    }

    public void setREMNombre(String rEMNombre) {
        this.rEMNombre = rEMNombre;
    }

    public String getREMApellido1() {
        return rEMApellido1;
    }

    public void setREMApellido1(String rEMApellido1) {
        this.rEMApellido1 = rEMApellido1;
    }

    public String getREMApellido2() {
        return rEMApellido2;
    }

    public void setREMApellido2(String rEMApellido2) {
        this.rEMApellido2 = rEMApellido2;
    }

    public String getREMBanco() {
        return rEMBanco;
    }

    public void setREMBanco(String rEMBanco) {
        this.rEMBanco = rEMBanco;
    }

    public String getREMSucursal() {
        return rEMSucursal;
    }

    public void setREMSucursal(String rEMSucursal) {
        this.rEMSucursal = rEMSucursal;
    }

    public String getREMDigito() {
        return rEMDigito;
    }

    public void setREMDigito(String rEMDigito) {
        this.rEMDigito = rEMDigito;
    }

    public String getREMCuenta() {
        return rEMCuenta;
    }

    public void setREMCuenta(String rEMCuenta) {
        this.rEMCuenta = rEMCuenta;
    }

    public Integer getIdBancoFactura() {
        return idBancoFactura;
    }

    public void setIdBancoFactura(Integer idBancoFactura) {
        this.idBancoFactura = idBancoFactura;
    }

    public Boolean getFactorizar() {
        return factorizar;
    }

    public void setFactorizar(Boolean factorizar) {
        this.factorizar = factorizar;
    }

    public Integer getFactorizarCodbanco() {
        return factorizarCodbanco;
    }

    public void setFactorizarCodbanco(Integer factorizarCodbanco) {
        this.factorizarCodbanco = factorizarCodbanco;
    }

    public Date getFechaFinRiesgoGerencia() {
        return fechaFinRiesgoGerencia;
    }

    public void setFechaFinRiesgoGerencia(Date fechaFinRiesgoGerencia) {
        this.fechaFinRiesgoGerencia = fechaFinRiesgoGerencia;
    }

    public Boolean getReferenciaObligatoria() {
        return referenciaObligatoria;
    }

    public void setReferenciaObligatoria(Boolean referenciaObligatoria) {
        this.referenciaObligatoria = referenciaObligatoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public Boolean getAstre() {
        return astre;
    }

    public void setAstre(Boolean astre) {
        this.astre = astre;
    }

    public Boolean getDeshabilitado() {
        return deshabilitado;
    }

    public void setDeshabilitado(Boolean deshabilitado) {
        this.deshabilitado = deshabilitado;
    }

    public Boolean getAutofactura() {
        return autofactura;
    }

    public void setAutofactura(Boolean autofactura) {
        this.autofactura = autofactura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.velsoft.modelo.Clientes[ id=" + id + " ]";
    }
    
}
