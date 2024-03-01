package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblNaves")
public class NaveEntidad implements Serializable {

    @Id
    @Column(name = "idNave")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "pais", nullable = false, length = 50)
    private String pais;

    @Column(name = "numeroPasajero", nullable = false)
    private Integer numeroPasajero;

    @Column(name = "tamanio", nullable = false, length = 50)
    private String tamaño;
    
    @OneToMany(mappedBy = "nave", cascade = CascadeType.PERSIST)
    private List<VueloEntidad> listaVuelos;

    @OneToMany(mappedBy = "nave", cascade = CascadeType.PERSIST)
    private List<AstronautaNaveEntidad> listaAstronautas;
    
    public NaveEntidad() {
    }

    public NaveEntidad(String nombre, String color, String pais, Integer numeroPasajero, String tamaño, List<VueloEntidad> listaVuelos, List<AstronautaNaveEntidad> listaAstronautas) {
        this.nombre = nombre;
        this.color = color;
        this.pais = pais;
        this.numeroPasajero = numeroPasajero;
        this.tamaño = tamaño;
        this.listaVuelos = listaVuelos;
        this.listaAstronautas = listaAstronautas;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(Integer numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public List<VueloEntidad> getListaVuelos() {
        return listaVuelos;
    }

    public void setVuelos(List<VueloEntidad> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public List<AstronautaNaveEntidad> getListaAstronautas() {
        return listaAstronautas;
    }

    public void setListaAstronautas(List<AstronautaNaveEntidad> listaAstronautas) {
        this.listaAstronautas = listaAstronautas;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NaveEntidad other = (NaveEntidad) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
