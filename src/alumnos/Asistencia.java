/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.Date;

/**
 * @version 0.0.0 ,19/04/2017
 * @author Eduard QF
 */
public class Asistencia {
    private Boolean asistencia;
    private String   time;

    public Asistencia(Boolean asistencia, String time) {
        this.asistencia = asistencia;
        this.time = time;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public String getTime() {
        return time;
    }
    
}
