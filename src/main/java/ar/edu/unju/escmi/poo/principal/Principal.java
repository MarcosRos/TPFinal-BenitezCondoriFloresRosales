package ar.edu.unju.escmi.poo.principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        boolean bandera;
        int opc=0;

        do {
            do {
                bandera = true;
                menu();
                try {
                    opc = sc.nextInt();
                } catch (InputMismatchException ime) {
                    bandera = false;
                    System.out.println("Formato Incorrecto");
                    sc.next();
                }
            } while (bandera == false);
            switch(opc) {
            case 1:{
            	
            }
            break;
            case 2:{
                System.out.println("a");
            }
            break;
            }

    }while(opc!=10);
        sc.close();
    }


    private static void menu() {
        System.out.println("--------------- MENU PRINCIPAL ---------------");
        System.out.println("1- Alta de Mozo.");
        System.out.println("2- Listado de Mozos.");
        System.out.println("3- Consultar disponibilidad de mesas según salón.");
        System.out.println("4- Consultar mesas ocupadas y comensales.");
        System.out.println("5- Alta de una reserva.");
        System.out.println("6- Realizar la búsqueda de una reserva y modificar su pago.");
        /*(significa que finaliza la reserva). El estado se debe actualizar de forma automática (no se ingresa).
        Las mesas deben quedar liberadas para una próxima reserva.*/
        System.out.println("7- Consultar los datos del cliente ingresando cuil o dni.");
        System.out.println("8- Eliminar una reserva ingresando el id.");
        System.out.println("9- Listar todas las reservas.");
        System.out.println("10- Salir.");
        System.out.println("Elija una opcion:");
        System.out.println(" ");
    }

}
