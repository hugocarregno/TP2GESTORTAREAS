/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author Hugo Carreño
 */
public class Tarea {
    private String nombre;
    private String descripcion;
    private int prioridad;
    private boolean completada;
    private boolean anulada;
    private LocalDateTime vencimiento;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    public Tarea(String nombre, String descripcion, int prioridad, boolean completada, boolean anulada, LocalDateTime vencimiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = completada;
        this.anulada = anulada;
        this.vencimiento = vencimiento;
    }

    public String formatearFecha(){
        
        String mes = vencimiento.getMonth().getDisplayName(TextStyle.FULL, new Locale("es","ES"));
        String primerLetra = (mes.substring(0, 1)).toUpperCase();
        String resto = mes.substring(1, mes.length());
        mes = primerLetra + resto;
        return vencimiento.getDayOfMonth()+" de "+ mes +" de "+vencimiento.getYear()+" "+vencimiento.getHour()+":"+((vencimiento.getMinute() < 10) ? "0".concat(String.valueOf(vencimiento.getMinute())) : vencimiento.getMinute())+"hs";
    }
    public String mostrarTarea() {
        return "\nPrioridad: " + prioridad +
                "\nNombre: " + nombre + 
                "\nDescripción: " + descripcion +
                "\nVencimiento: " + (vencimiento != null ? formatearFecha() : vencimiento)+
                "\nCompletada: " + (completada ? "SI" : "NO") +
                "\nAnulada: " + (anulada ? "SI" : "NO");
    }

}
