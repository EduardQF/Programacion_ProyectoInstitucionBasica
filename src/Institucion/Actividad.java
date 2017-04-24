package Institucion;


/**
 * @version 0.0.0, 16/04/2017
 * @author Eduard QF
 */
public class Actividad {
    
    /**
     * atributo que almacenara el detalle de la actividad.
     */
    private String Actividad;
    
    /**
     * atributo que almacenara la fecha.
     */
    private String fecha;

    /**
     * constructor de la clase Actividad.
     * @param Actividad  indica el detalle de la actividad.
     * @param fecha indica la fecha en que se realizara.
     */
    public Actividad(String Actividad, String fecha) {
        this.Actividad = Actividad;
        this.fecha = fecha;
    }

    /**
     * @return el detalle de la actividad.
     */
    public String getActividad() {
        return Actividad;
    }

    /**
     * @return la fecha encontrada en el objeto.
     */
    public String getFecha() {
        return fecha;
    }

    
}
