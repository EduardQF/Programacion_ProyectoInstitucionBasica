
package modelo;

import Institucion.Profesor;
import Institucion.INstitucion;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import datos.GenarateReport;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @version 0,4,0 20/04/2017
 * @author Eduard QF
 */
public class Body {

    /**
     * atributo que almacena la instancia de INstitucion.
     */
    private INstitucion inst;

    /**
     * metodo que inicia el objeto Body pero no es el constructor de esta clase.
     */
    public void init() throws FileNotFoundException {
        XStream xs = new XStream();
        Gson gson = new Gson();
        String DatosTotal = datos.DataReader.readDataS("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\datos\\DatosTotal.json");
        inst = gson.fromJson(DatosTotal, INstitucion.class);
        System.out.println(inst.getCursos().get(0).getIDCurso());
        //inst = (INstitucion) xs.fromXML(new FileReader("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\datos\\DatosTotal.xml"));

    }

    /**
     * metodo que entrega la istanciacion de Instituto para generar una
     * coceccion con las ventanas.
     *
     * @return la instanciacion de Instituto
     */
    public INstitucion asignInst() {
        return inst;
    }

    /**
     * metodo que compara los datos entregados con los de los Docente para
     * retornar cual de todos es.
     *
     * @param selectedItem nombre del Profesor obtenido de un jComboBox.
     * @param curso numero del 0 al 15 que indica al curso con el que se
     * trabajaba.
     * @return el Profesor correspondiente a los datos entregados en los
     * parametros.
     */
    public Profesor compareDocentes(Object selectedItem, int curso) {
        int prof = 0;

        for (int j = 0; j < inst.getCursos().get(curso).getAsignatura().size(); j++) {
            if (inst.getCursos().get(curso).getAsignatura().get(j).getDocente().getNombre().equals((String) selectedItem)) {
                prof = j;
                break;
            }
        }

        return inst.getCursos().get(curso).getAsignatura().get(prof).getDocente();
    }

    /**
     * metodo encargado de obtener los datos para generar los reportes a
     * entregar a los Apoderados, y entregarselo a metodo que generara los
     * reportes.
     *
     * @param selectedIndex indica el curso con el que se obtendra los datos.
     */
    public void generarReporte(int selectedIndex) {
        datos.GenarateReport gr = new GenarateReport();
        for (int i = 0; i < inst.getCursos().get((int) selectedIndex).getAlumnos().size(); i++) {
            gr.genararReporteAlumno(inst.getCursos().get((int) selectedIndex).getAlumnos().get(i));
        }
    }

    /**
     * metodo encargado de obtener los datos para generar los los reportes de
     * notas para los profesores de cada asignatura.
     *
     * @param selectedIndex indica el numero de curso con el que se trabajaba
     * con un rango del 0 al 16.
     * @param codAsignature indicale el codigo de la signatura con la que se
     * esta trabajando.
     */
    public void generarReporteNotasAsignaturas(int selectedIndex, String codAsignature) {
        datos.GenarateReport gr = new GenarateReport();
        ArrayList<String> notas = new ArrayList<>();
        ArrayList<ArrayList> estudiantes = new ArrayList<>();
        int cantnot = 0,codas=0;
        double promedio = 0;
        for (int i = 0; i < inst.getCursos().get(selectedIndex).getAlumnos().size(); i++) {
            notas.add(inst.getCursos().get(selectedIndex).getAlumnos().get(i).getNombre());
            for (int j = 0; j < inst.getCursos().get(selectedIndex).getAlumnos().get(i).getNotasEvaluaciones().size(); j++) {
                if (inst.getCursos().get(selectedIndex).getAlumnos().get(i).getNotasEvaluaciones().get(j).getMateria().equals(codAsignature)) {
                    notas.add(String.valueOf(inst.getCursos().get(selectedIndex).getAlumnos().get(i).getNotasEvaluaciones().get(j).getNota()));
                    promedio += inst.getCursos().get(selectedIndex).getAlumnos().get(i).getNotasEvaluaciones().get(j).getNota();
                    cantnot++;
                    codas=inst.getCursos().get(selectedIndex).getAsignatura().get(j).getCodigoAsign();
                }
            }
            promedio = promedio / cantnot;
            notas.add(String.valueOf(promedio));
            estudiantes.add(notas);
            notas.clear();
            cantnot = 0;
            promedio = 0;
        }
        gr.generarReporteNotasAsign(codas, estudiantes,inst.getCursos().get(selectedIndex));
    }

    /**
     * metodo encagado de guardar los cambios generados.
     */
    public void guardarCambios() {
         XStream xs =new XStream();
            xs.alias("Institucion", INstitucion.class);
            String t = xs.toXML(inst);
            datos.DataReader.writeData("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\datos\\DatosTotal.xml", t);
            System.out.println(t);
            /*---------------------------*/
            Gson g=new Gson();
            String p=g.toJson(inst);
            datos.DataReader.writeData("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\datos\\DatosTotal.json", p);
            System.out.println(p);
    }

    /**
     * metodo encargado de obtener la fecha que tiene estipulada el computador en el que se trabaja.
     * @return la fecha en la que nos encontrames
     */
        public String getFecha() {
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(fecha);
    }
}
