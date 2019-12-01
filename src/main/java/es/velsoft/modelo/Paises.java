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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "Paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodPais")
    private Integer codPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Sigla")
    private String sigla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Comunitario")
    private boolean comunitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xfec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "xord")
    private String xord;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iva")
    private BigDecimal iva;
    @Size(max = 500)
    @Column(name = "refivaexento")
    private String refivaexento;
    @Size(max = 50)
    @Column(name = "PaisMappoint")
    private String paisMappoint;
    @OneToMany(mappedBy = "pais")
    private List<Direcciones> direccionesList;

    public Paises() {
    }

    public Paises(Integer codPais) {
        this.codPais = codPais;
    }

    public Paises(Integer codPais, String pais, String sigla, boolean comunitario, String autor, Date xfec, String xord) {
        this.codPais = codPais;
        this.pais = pais;
        this.sigla = sigla;
        this.comunitario = comunitario;
        this.autor = autor;
        this.xfec = xfec;
        this.xord = xord;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public boolean getComunitario() {
        return comunitario;
    }

    public void setComunitario(boolean comunitario) {
        this.comunitario = comunitario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public String getRefivaexento() {
        return refivaexento;
    }

    public void setRefivaexento(String refivaexento) {
        this.refivaexento = refivaexento;
    }

    public String getPaisMappoint() {
        return paisMappoint;
    }

    public void setPaisMappoint(String paisMappoint) {
        this.paisMappoint = paisMappoint;
    }

    @XmlTransient
    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.velsoft.modelo.Paises[ codPais=" + codPais + " ]";
    }
    
}
