package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.CompatibilidadProyecto;
import modelo.Conocimientos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(Herramientas.class)
public class Herramientas_ { 

    public static volatile SingularAttribute<Herramientas, Integer> tipo;
    public static volatile ListAttribute<Herramientas, CompatibilidadProyecto> compatibilidadProyectoList;
    public static volatile SingularAttribute<Herramientas, Integer> id;
    public static volatile SingularAttribute<Herramientas, String> nombre;
    public static volatile ListAttribute<Herramientas, Conocimientos> conocimientosList;

}