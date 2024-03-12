package entidades;

import entidades.AstronautaNaveEntidad;
import entidades.VueloEntidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-12T00:01:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(NaveEntidad.class)
public class NaveEntidad_ { 

    public static volatile SingularAttribute<NaveEntidad, String> tamaño;
    public static volatile ListAttribute<NaveEntidad, VueloEntidad> listaVuelos;
    public static volatile SingularAttribute<NaveEntidad, String> color;
    public static volatile ListAttribute<NaveEntidad, AstronautaNaveEntidad> listaAstronautas;
    public static volatile SingularAttribute<NaveEntidad, Long> id;
    public static volatile SingularAttribute<NaveEntidad, String> nombre;
    public static volatile SingularAttribute<NaveEntidad, Integer> numeroPasajero;
    public static volatile SingularAttribute<NaveEntidad, String> pais;

}