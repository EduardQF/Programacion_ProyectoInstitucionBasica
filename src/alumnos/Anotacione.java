

package alumnos;

import Institucion.Profesor;

/**
 * clase que registra los detalles de las anotacions
 *@version 0.0.0
 * @author Eduard QF
 */
public class Anotacione {
    /**
     *atributo q indica el tipo de anotacion(positiva o negativa) 
     */
    private Boolean tipo;
    
    /**
     * atributo qur indica en detalle la anotacion
     */
    private String detalle;
    
    /**
     * atributo que indica el profesor que escrivio la anotacion
     */
    private Profesor profesor;

    /**
     * constructor de la clase Anotacion.
     * @param tipo indica el ipo de anotacion.
     * @param detalle entrega el contenido de la anotacion.
     * @param profesor indica el profesor que la registro.
     */
    public Anotacione(Boolean tipo, String detalle, Profesor profesor) {
        this.tipo = tipo;
        this.detalle = detalle;
        this.profesor = profesor;
    }

    /**
     *  @return el tipo de anotacion
     */
    public Boolean getTipo() {
        return tipo;
    }

    /**
     * @return el detalle de la anotacion
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @return el profesor que registro la anotacion
     */
    public Profesor getProfesor() {
        return profesor;
    }
    
}
