package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.GestionRequisitos;
import modelo.Proyectos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(RequisitosProyecto.class)
public class RequisitosProyecto_ { 

    public static volatile SingularAttribute<RequisitosProyecto, String> descripcion;
    public static volatile SingularAttribute<RequisitosProyecto, Proyectos> proyectosId;
    public static volatile SingularAttribute<RequisitosProyecto, String> tipo;
    public static volatile SingularAttribute<RequisitosProyecto, String> estado;
    public static volatile ListAttribute<RequisitosProyecto, GestionRequisitos> gestionRequisitosList;
    public static volatile SingularAttribute<RequisitosProyecto, Integer> id;

}