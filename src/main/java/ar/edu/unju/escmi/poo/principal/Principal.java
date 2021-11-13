package ar.edu.unju.escmi.poo.principal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
	}

	private void menu() {
		System.out.println("====== MENU PRINCIPAL ======");
		System.out.println("1- Alta de Mozo");
		System.out.println("2- Listado de Mozos");
		System.out.println("3- Consultar disponibilidad de mesas según salón.");
		System.out.println("4- Consultar mesas ocupadas y comensales.");
		System.out.println("5- Alta de una reserva.");
		System.out.println("6- Realizar la búsqueda de una reserva y modificar su pago");
		/*(significa que finaliza la reserva). El estado se debe actualizar de forma automática (no se ingresa).
		Las mesas deben quedar liberadas para una próxima reserva.*/
		System.out.println("7- Consultar los datos del cliente ingresando cuil o dni.");
		System.out.println("8- Eliminar una reserva ingresando el id.");
		System.out.println("9- Listar todas las reservas");
		System.out.println("Elija una opcion:");
	}

}
