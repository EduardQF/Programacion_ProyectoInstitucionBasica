/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institucion;

import java.util.ArrayList;

/**
 *
 * @author Eduard QF
 */
public class Planificacion {
    ArrayList<Actividad>actividades;

    public Planificacion(Actividad actividad) {
        actividades=new ArrayList<>();
        actividades.add(actividad);
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void addActividades(Actividad actividad) {
        actividades.add(actividad);
    }
    
}
