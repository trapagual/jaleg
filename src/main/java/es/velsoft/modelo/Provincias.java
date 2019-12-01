/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.velsoft.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Provincias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincias.findAll", query = "SELECT p FROM Provincias p")})
public class Provincias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CodProvincia")
    private String codProvincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodPais")
    private int codPais;
    @Column(name = "xfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xfec;
    @Size(max = 50)
    @Column(name = "xord")
    private String xord;
    @Size(max = 50)
    @Column(name = "xusr")
    private String xusr;
    @Column(name = "codcomunidad")
    private Integer codcomunidad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprovincia")
    private Integer idprovincia;
    @OneToMany(mappedBy = "provincia")
    private List<Direcciones> direccionesList;

    public Provincias() {
    }

    public Provincias(Integer idprovincia) {
        this.idprovincia = idprovincia;
    }

    public Provincias(Integer idprovincia, String codProvincia, String provincia, int codPais) {
        this.idprovincia = idprovincia;
        this.codProvincia = codProvincia;
        this.provincia = provincia;
        this.codPais = codPais;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
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

    public String getXusr() {
        return xusr;
    }

    public void setXusr(String xusr) {
        this.xusr = xusr;
    }

    public Integer getCodcomunidad() {
        return codcomunidad;
    }

    public void setCodcomunidad(Integer codcomunidad) {
        this.codcomunidad = codcomunidad;
    }

    public Integer getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Integer idprovincia) {
        this.idprovincia = idprovincia;
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
        hash += (idprovincia != null ? idprovincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincias)) {
            return false;
        }
        Provincias other = (Provincias) object;
        if ((this.idprovincia == null && other.idprovincia != null) || (this.idprovincia != null && !this.idprovincia.equals(other.idprovincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.velsoft.modelo.Provincias[ idprovincia=" + idprovincia + " ]";
    }
    
}
