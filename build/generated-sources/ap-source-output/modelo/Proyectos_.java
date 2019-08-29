package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.CompatibilidadProyecto;
import modelo.GruposTrabajo;
import modelo.RequisitosProyecto;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(Proyectos.class)
public class Proyectos_ { 

    public static volatile SingularAttribute<Proyectos, Date> fechaInicioAnalisis;
    public static volatile SingularAttribute<Proyectos, Date> fechaAsignacion;
    public static volatile ListAttribute<Proyectos, GruposTrabajo> gruposTrabajoList;
    public static volatile SingularAttribute<Proyectos, String> areaAplicacion;
    public static volatile SingularAttribute<Proyectos, String> faseProyecto;
    public static volatile SingularAttribute<Proyectos, Integer> costoTotal;
    public static volatile SingularAttribute<Proyectos, String> nombre;
    public static volatile SingularAttribute<Proyectos, Date> fechaPrevistaLiberacion;
    public static volatile ListAttribute<Proyectos, RequisitosProyecto> requisitosProyectoList;
    public static volatile SingularAttribute<Proyectos, Date> fechaInicioPruebas;
    public static volatile SingularAttribute<Proyectos, String> versionPrograma;
    public static volatile SingularAttribute<Proyectos, Date> fechaIngreso;
    public static volatile ListAttribute<Proyectos, CompatibilidadProyecto> compatibilidadProyectoList;
    public static volatile SingularAttribute<Proyectos, Date> fechaInicioCodificacion;
    public static volatile SingularAttribute<Proyectos, Date> fechaInicioDiseño;
    public static volatile SingularAttribute<Proyectos, Integer> id;

}