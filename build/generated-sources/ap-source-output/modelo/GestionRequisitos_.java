package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.RequisitosProyecto;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(GestionRequisitos.class)
public class GestionRequisitos_ { 

    public static volatile SingularAttribute<GestionRequisitos, String> descripcion;
    public static volatile SingularAttribute<GestionRequisitos, String> estado;
    public static volatile SingularAttribute<GestionRequisitos, String> verificador;
    public static volatile SingularAttribute<GestionRequisitos, RequisitosProyecto> requisitosProyectoId;
    public static volatile SingularAttribute<GestionRequisitos, String> release;
    public static volatile SingularAttribute<GestionRequisitos, String> solicitante;
    public static volatile SingularAttribute<GestionRequisitos, String> titulo;
    public static volatile SingularAttribute<GestionRequisitos, String> origen;
    public static volatile SingularAttribute<GestionRequisitos, String> esfuerzo;
    public static volatile SingularAttribute<GestionRequisitos, Integer> numeroSolicitud;
    public static volatile SingularAttribute<GestionRequisitos, Date> fecha;
    public static volatile SingularAttribute<GestionRequisitos, String> tipoSolicitud;
    public static volatile SingularAttribute<GestionRequisitos, String> proridadSolicitante;
    public static volatile SingularAttribute<GestionRequisitos, String> prioridadRealizacion;
    public static volatile SingularAttribute<GestionRequisitos, Date> fechaUltimaActualizacion;
    public static volatile SingularAttribute<GestionRequisitos, String> comentarios;

}