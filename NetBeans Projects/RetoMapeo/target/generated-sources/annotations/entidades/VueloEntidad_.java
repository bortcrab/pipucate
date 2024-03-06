package entidades;

import entidades.NaveEntidad;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-06T13:58:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(VueloEntidad.class)
public class VueloEntidad_ { 

    public static volatile SingularAttribute<VueloEntidad, NaveEntidad> nave;
    public static volatile SingularAttribute<VueloEntidad, Calendar> fechaHoraSalida;
    public static volatile SingularAttribute<VueloEntidad, Long> id;
    public static volatile SingularAttribute<VueloEntidad, Integer> numeroPasajero;

}