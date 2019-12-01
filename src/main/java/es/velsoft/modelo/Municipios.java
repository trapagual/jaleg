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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "Municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")})
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodMunicipio")
    private Integer codMunicipio;
    @Size(max = 100)
    @Column(name = "Municipio")
    private String municipio;
    @Size(max = 20)
    @Column(name = "CodProvincia")
    private String codProvincia;
    @Column(name = "CodPais")
    private Integer codPais;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Lat")
    private Double lat;
    @Column(name = "Lon")
    private Double lon;
    @Size(max = 500)
    @Column(name = "DesMappoint")
    private String desMappoint;
    @Size(max = 50)
    @Column(name = "xusr")
    private String xusr;
    @Column(name = "xfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xfec;
    @Size(max = 50)
    @Column(name = "xord")
    private String xord;
    @Column(name = "codcomunidad")
    private Integer codcomunidad;
    @Size(max = 10)
    @Column(name = "CP")
    private String cp;
    @Column(name = "manual")
    private Boolean manual;
    @OneToMany(mappedBy = "municipio")
    private List<Direcciones> direccionesList;

    public Municipios() {
    }

    public Municipios(Integer codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public Integer getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(Integer codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getDesMappoint() {
        return desMappoint;
    }

    public void setDesMappoint(String desMappoint) {
        this.desMappoint = desMappoint;
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

    public Integer getCodcomunidad() {
        return codcomunidad;
    }

    public void setCodcomunidad(Integer codcomunidad) {
        this.codcomunidad = codcomunidad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
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
        hash += (codMunicipio != null ? codMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.codMunicipio == null && other.codMunicipio != null) || (this.codMunicipio != null && !this.codMunicipio.equals(other.codMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.velsoft.modelo.Municipios[ codMunicipio=" + codMunicipio + " ]";
    }
    
}
