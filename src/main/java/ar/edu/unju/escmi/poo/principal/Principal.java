package ar.edu.unju.escmi.poo.principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.internal.build.AllowSysOut;

import ar.edu.unju.escmi.poo.dao.IClienteDao;
import ar.edu.unju.escmi.poo.dao.IMesaDao;
import ar.edu.unju.escmi.poo.dao.IMozoDao;
import ar.edu.unju.escmi.poo.dao.IReservaDao;
import ar.edu.unju.escmi.poo.dao.ISalonDao;
import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.MesaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.MozoDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.ReservaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.SalonDaoImp;
import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import ar.edu.unju.escmi.poo.dominio.Salon;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		IClienteDao clienteDao = new ClienteDaoImp();
		IMesaDao mesaDao = new MesaDaoImp();
		IMozoDao mozoDao = new MozoDaoImp();
		IReservaDao reservaDao = new ReservaDaoImp();
		ISalonDao salonDao = new SalonDaoImp();
		boolean bandera;
		int opc = 0;
		long dni = 0;
		Cliente unCliente;
		Mesa unaMesa;
		Mozo unMozo, mozoEncontrado;
		Reserva unaReserva = null;
		Salon unSalon;

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
			switch (opc) {
			case 1: {
				do {
					System.out.println("Ingrese el DNI del nuevo mozo");
					try {
						dni = sc.nextLong();
					} catch (InputMismatchException ime) {
						bandera = false;
						System.out.println("Formato Incorrecto");
						sc.next();
					}
					try {
						mozoEncontrado = mozoDao.obtenerMozo(dni);
					} catch (NoResultException nre) {
						System.out.println("Dni Disponible");
						mozoEncontrado = null;
					}
					if (mozoEncontrado != null) {
						System.out.println("Ya existe un Usuario con ese DNI!");
						bandera = false;
					}
				} while (bandera == false);

				System.out.println("Ingrese el Nombre del nuevo mozo");
				String nombre = sc.next();

				System.out.println("Ingrese el Apellido del nuevo mozo");
				String apellido = sc.next();

				ArrayList<Reserva> reservasAtendidas = null;
				unMozo = new Mozo(nombre, apellido, dni, reservasAtendidas);
				mozoDao.guardarMozo(unMozo);

			}
				break;
			case 2: {
				System.out.println("=== Listado de Mozos ===");
				mozoDao.obtenerMozos().stream().forEach(System.out::println);
			}
				break;
			case 3: {
				int opcion = 0, libre = 0, ocupado = 0;
				do {
					do {
						bandera = true;
						System.out.println("Seleccione el salon del que quiere ver sus mesas:");
						System.out.println("1- Salon 1");
						System.out.println("2- Salon 2");
						System.out.println("3- Salir");
						System.out.println("Elija una opcion: ");
						try {
							opcion = sc.nextInt();
						} catch (InputMismatchException ime) {
							System.out.println("Formato Incorrecto");
							bandera = false;
							sc.next();
						}
					} while (bandera == false);
					switch (opcion) {
					case 1:
						System.out.println("===== Salon 1 =====");
						unSalon = salonDao.obtenerSalon(opc);
						for (int i = 0; i < unSalon.getMesas().size(); i++) {
							if (unSalon.getMesas().get(i).getEstado().equals("Libre")) {
								libre++;
							} else {
								ocupado++;
							}
						}
						System.out.println("Total de Mesas: " + unSalon.getMesas().size());
						System.out.println("Hay un total de: " + libre + " mesas libres");
						System.out.println("Hay un total de: " + ocupado + " mesas ocupadas");
						System.out.println(" ");
						System.out.println("==== Mesas libres ====");
						salonDao.obtenerSalon(1).getMesas().stream().filter(s -> s.getEstado().equals("Libre"))
								.forEach(System.out::println);
						break;
					case 2:
						System.out.println("===== Salon 2 =====");
						unSalon = salonDao.obtenerSalon(opc);

						for (int i = 0; i < unSalon.getMesas().size(); i++) {
							if (unSalon.getMesas().get(i).getEstado().equals("Libre")) {
								libre++;
							} else {
								ocupado++;
							}
						}
						System.out.println("Total de Mesas: " + unSalon.getMesas().size());
						System.out.println("Hay un total de: " + libre + " mesas libres");
						System.out.println("Hay un total de: " + ocupado + " mesas ocupadas");
						System.out.println(" ");
						System.out.println("==== Mesas libres ====");
						salonDao.obtenerSalon(2).getMesas().stream().filter(s -> s.getEstado().equals("Libre"))
								.forEach(System.out::println);
						break;
					case 3:
						System.out.println("Saliendo del menu");
						break;
					default:
						System.out.println("Opcion inexistente");
						break;
					}
				} while (opcion != 3);
			}
				break;
			case 4: {
				int opcion = 0;
				do {
					do {
						bandera = true;
						System.out.println("==== Menu Mesas Ocupadas ====");
						System.out.println("1- Ver las mesas ocupadas del salon 1");
						System.out.println("2- Ver las mesas ocupadas del salon 2");
						System.out.println("3- Salir");
						try {
							opcion = sc.nextInt();
						} catch (InputMismatchException ime) {
							bandera = false;
							System.out.println("Formato Incorrecto");
							sc.next();
						}
					} while (bandera == false);
					switch (opcion) {
					case 1:
						salonDao.obtenerSalon(1).getMesas().stream().filter(s -> s.getEstado().equals("Ocupada"))
								.forEach(System.out::println);
						break;
					case 2:
						salonDao.obtenerSalon(2).getMesas().stream().filter(s -> s.getEstado().equals("Ocupada"))
								.forEach(System.out::println);
						break;
					case 3:
						System.out.println("Saliendo del menu");
						break;
					default:
						System.out.println("Opcion inexistente");
						break;
					}
				} while (opcion != 3);

			}
				break;
			case 5: {
				System.out.println("a");
			}
				break;
			case 6: {
				int opcion = 0;
				boolean reservaEncontrada = true;
				System.out.println("Reservas:");
				reservaDao.obtenerReservas().stream().filter(s -> s.getEstado().equals("Sin Pagar"))
						.forEach(System.out::println);
				do {
					bandera = true;
					System.out.println("Ingrese el id de la reserva:");
					try {
						opcion = sc.nextInt();
					} catch (InputMismatchException ime) {
						bandera = false;
						System.out.println("Formato Incorrecto");
						sc.next();
					}
				} while (bandera == false);
				try {
					unaReserva = reservaDao.obtenerReserva(opcion);
				} catch (NoResultException nre) {
					System.out.println("No se encontro una reserva con ese id");
					reservaEncontrada = false;
				}
				if (reservaEncontrada == true) {
					unaReserva.setEstado("Pagado");
					unaReserva.setTotalAPagar(0);
					List<Mesa> mesasALiberar = unaReserva.getMesasOcupadas();
					unaReserva.setMesasOcupadas(null);
					reservaDao.modificarReserva(unaReserva);

					for (int i = 0; i < mesasALiberar.size(); i++) {
						unaMesa = mesasALiberar.get(i);
						unaMesa.setCapacidad(4);
						unaMesa.setEstado("Libre");
						mesaDao.modificarMesa(unaMesa);
					}
				}
			}
				break;
			case 7: {
				boolean bandAgencia=true,bandPart=true;
				do {
					bandera = true;
					System.out.println("Ingrese el Dni o Cuil");
					try {
						dni = sc.nextLong();
					} catch (InputMismatchException ime) {
						bandera = false;
						System.out.println("Formato incorrecto");
						sc.next();
					}
				} while (bandera == false);
				try {
				unCliente=clienteDao.obtenerClienteAgencia(dni);
				}catch(NoResultException nre){
					bandAgencia=false;
					unCliente=null;
				}
				if (unCliente==null) {
					try {
						unCliente=clienteDao.obtenerClienteParticular(dni);
						}catch(NoResultException nre){
							bandPart=false;
							unCliente=null;
						}
				}
				if (bandAgencia==false && bandPart==false) {
					System.out.println("No se encontro ningun usuario");
				}
				else
				{
					System.out.println(unCliente);
				}
				
				
			}
				break;
			case 8: {
				int id=0;
				reservaDao.obtenerReservas().stream().forEach(System.out::println);
				System.out.println(" ");
				do{
					bandera=true;
					System.out.println("Ingrese el id de la Reserva");
					try {
						id=sc.nextInt();
					}catch (InputMismatchException ime){
						bandera = false;
						System.out.println("Formato incorrecto");
						sc.next();
					}
				}while (bandera==false);
				bandera=true;
				try {
				unaReserva=reservaDao.obtenerReserva(id);
				}catch(NoResultException nre) {
					System.out.println("No se ha encontrado dicha reserva");
					bandera=false;
				}
				if(bandera==true) {
				reservaDao.borrarReserva(unaReserva);
				System.out.println("Reserva borrada correctamente!");
				}
			}
				break;
			case 9: {
				reservaDao.obtenerReservas().stream().forEach(System.out::println);
			}
				break;
			case 10: {
				// if (salonDao.obtenerSalon())
			}
				break;
			case 11: {
				System.out.println("Saliendo del Programa...");
			}
				break;
			default: {
				System.out.println("Opcion Inexistente!");
			}
				break;
			}

		} while (opc != 11);
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
		/*
		 * (significa que finaliza la reserva). El estado se debe actualizar de forma
		 * automática (no se ingresa). Las mesas deben quedar liberadas para una próxima
		 * reserva.
		 */
		System.out.println("7- Consultar los datos del cliente ingresando cuil o dni.");
		System.out.println("8- Eliminar una reserva ingresando el id.");
		System.out.println("9- Listar todas las reservas.");
		System.out.println("10- Cargar datos default (solo si las tablas estan vacias)");
		System.out.println("11- Salir.");
		System.out.println("Elija una opcion:");
		System.out.println(" ");
	}

}
