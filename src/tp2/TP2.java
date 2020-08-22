/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Hugo Carreño
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime vencimiento;
        boolean completada, anulada;
        int prioridad;
        String nombre, descripcion;
        Tarea tarea;
        System.out.println("Sistema de Gestion de tareas");
        System.out.println("Selecciona una opción:");
        System.out.println("1. Ingrese una tarea");
        System.out.println("2. Ingrese una tarea completa");
        System.out.print("opción:");

        int opcion = sc.nextInt();
        if(opcion == 1 || opcion == 2){
            if(opcion == 1){
                System.out.print("Ingrese nombre de la tarea:");
                sc.nextLine();
                nombre = sc.nextLine();
                tarea = new Tarea(nombre);
                System.out.println(tarea.mostrarTarea());
            }else{
                
                System.out.print("Ingrese nombre de la tarea:");
                sc.nextLine();
                nombre = sc.nextLine();
                System.out.print("Ingrese descripción de la tarea:");
                descripcion = sc.nextLine();
                System.out.print("Ingrese prioridad de la tarea:");
                prioridad = sc.nextInt();
                System.out.print("¿Esta Completada la tarea?:(s/n)");
                completada = sc.next().charAt(0) == 's';
                System.out.print("¿Esta Anulada la tarea?:(s/n)");
                anulada = sc.next().charAt(0) == 's';
                System.out.print("Ingrese fecha de vencimiento :(dd/mm/aaaa HH:mm)");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                sc.nextLine();
                vencimiento = LocalDateTime.parse(sc.nextLine(), dateTimeFormatter);

                tarea = new Tarea(nombre, descripcion, prioridad, completada, anulada, vencimiento);
                System.out.println(tarea.mostrarTarea());
            }
        }else{
            System.out.println("opción inválida");
        }

    }
}
