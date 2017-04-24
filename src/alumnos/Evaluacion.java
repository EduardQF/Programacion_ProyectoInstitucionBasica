
package alumnos;

/**
 * clase dedicada a la informacion de las notas
 *
 * @version 0.0.0
 * @author Eduard QF
 */
public class Evaluacion {

    /**
     * atributo que almacena la materia a la que pertenece.
     */
    private String materia;
    
    /**
     * atributo que almacena la nota.
     */
    private float nota;
    
    /**
     * atributo que almacena el numero de evaluacion a la que pertenece.
     */
    private String numEvaluacion;

    /**
     * constructor de la clase
     *
     * @param materia materia a la que pertenese la nota
     * @param nota evaluacion comprendida entre 1.0 y el 7.0
     * @param numEvaluacion ind a la que pertenece la evaluacion.
     */
    public Evaluacion(String materia, float nota, String numEvaluacion) {
        this.materia = materia;
        this.nota = nota;
        this.numEvaluacion = numEvaluacion;
    }

    /**
     * @return la materia a la que pertenece la nota
     */
    public String getMateria() {
        return materia;
    }

    /**
     * @return la nota que obtubo
     */
    public float getNota() {
        return nota;
    }

    /**
     * @return el numero de la evaluacion que es
     */
    public String getNumEvaluacion() {
        return numEvaluacion;
    }

}
