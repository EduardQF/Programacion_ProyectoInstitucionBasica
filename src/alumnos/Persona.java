
package alumnos;

/**
 *
 * @author Eduard QF
 */
public class Persona {
    
    /**
     * atributo que almacena el nombre de la persona
     */
    protected String nombre;
    
    /**
     * atributo que almacena el rut de la persona
     */
    protected String rut;

    /**
     * constructor de la clase Persona
     * 
     * @param nombre nombre a tener la persona 
     * @param rut identificador de la perosna
     */
    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    /**
     * @return el nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el valor del id de la persona.
     */
    public String getRut() {
        return rut;
    }
    
}
