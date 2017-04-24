package alumnos;

/**
 * clase encargada de tener los datos de los objetos tipo Apoderado.
 *
 * @version 0.1.0
 * @author Eduard QF
 */
public class Apoderado extends Persona {

    /**
     * constructor de la clase Apoderado.
     *
     * @param nombre nombre del Apoderado.
     * @param rut rut a tener el apoderado.
     */
    public Apoderado(String nombre, String rut) {
        super(nombre, rut);
    }

    /**
     * @return el nombre del Apoderado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el rut del apoderado
     */
    public String getRut() {
        return rut;
    }
}
