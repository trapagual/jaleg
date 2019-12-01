/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "Rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r ORDER BY r.alias"),
    @NamedQuery(name = "Rutas.findDescByID", query = "SELECT r.alias FROM Rutas r WHERE r.idruta=:id")
})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idruta")
    private Integer idruta;
    @Column(name = "codmuncarga")
    private Integer codmuncarga;
    @Column(name = "codmundescarga")
    private Integer codmundescarga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kms")
    private BigDecimal kms;
    @Size(max = 1024)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "alias")
    private String alias;
    @Size(max = 50)
    @Column(name = "xusr")
    private String xusr;
    @Column(name = "xfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xfec;
    @Size(max = 50)
    @Column(name = "xord")
    private String xord;
    @Column(name = "autopista")
    private Integer autopista;
    @Column(name = "completa")
    private Boolean completa;
    @Size(max = 500)
    @Column(name = "DescripcionCompleta")
    private String descripcionCompleta;
    @Size(max = 500)
    @Column(name = "DescripcionSinPasos")
    private String descripcionSinPasos;
    @Size(max = 500)
    @Column(name = "DescripcionCargas")
    private String descripcionCargas;
    @Size(max = 500)
    @Column(name = "DescripcionDescargas")
    private String descripcionDescargas;
    @Size(max = 500)
    @Column(name = "DescripcionCargaDescarga")
    private String descripcionCargaDescarga;

    public Rutas() {
    }

    public Rutas(Integer idruta) {
        this.idruta = idruta;
    }

    public Integer getIdruta() {
        return idruta;
    }

    public void setIdruta(Integer idruta) {
        this.idruta = idruta;
    }

    public Integer getCodmuncarga() {
        return codmuncarga;
    }

    public void setCodmuncarga(Integer codmuncarga) {
        this.codmuncarga = codmuncarga;
    }

    public Integer getCodmundescarga() {
        return codmundescarga;
    }

    public void setCodmundescarga(Integer codmundescarga) {
        this.codmundescarga = codmundescarga;
    }

    public BigDecimal getKms() {
        return kms;
    }

    public void setKms(BigDecimal kms) {
        this.kms = kms;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public Integer getAutopista() {
        return autopista;
    }

    public void setAutopista(Integer autopista) {
        this.autopista = autopista;
    }

    public Boolean getCompleta() {
        return completa;
    }

    public void setCompleta(Boolean completa) {
        this.completa = completa;
    }

    public String getDescripcionCompleta() {
        return descripcionCompleta;
    }

    public void setDescripcionCompleta(String descripcionCompleta) {
        this.descripcionCompleta = descripcionCompleta;
    }

    public String getDescripcionSinPasos() {
        return descripcionSinPasos;
    }

    public void setDescripcionSinPasos(String descripcionSinPasos) {
        this.descripcionSinPasos = descripcionSinPasos;
    }

    public String getDescripcionCargas() {
        return descripcionCargas;
    }

    public void setDescripcionCargas(String descripcionCargas) {
        this.descripcionCargas = descripcionCargas;
    }

    public String getDescripcionDescargas() {
        return descripcionDescargas;
    }

    public void setDescripcionDescargas(String descripcionDescargas) {
        this.descripcionDescargas = descripcionDescargas;
    }

    public String getDescripcionCargaDescarga() {
        return descripcionCargaDescarga;
    }

    public void setDescripcionCargaDescarga(String descripcionCargaDescarga) {
        this.descripcionCargaDescarga = descripcionCargaDescarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idruta != null ? idruta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.idruta == null && other.idruta != null) || (this.idruta != null && !this.idruta.equals(other.idruta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.velsoft.modelo.Rutas[ idruta=" + idruta + " ]";
    }
    
}
