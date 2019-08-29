package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ingenieros;
import modelo.Proyectos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(GruposTrabajo.class)
public class GruposTrabajo_ { 

    public static volatile SingularAttribute<GruposTrabajo, Proyectos> proyectosId;
    public static volatile SingularAttribute<GruposTrabajo, Date> fechaInicio;
    public static volatile SingularAttribute<GruposTrabajo, Ingenieros> ingenierosCedula;
    public static volatile SingularAttribute<GruposTrabajo, Integer> id;
    public static volatile SingularAttribute<GruposTrabajo, Date> fechaFinalizacion;

}