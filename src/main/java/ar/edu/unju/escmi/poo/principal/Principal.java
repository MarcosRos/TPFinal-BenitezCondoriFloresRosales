package ar.edu.unju.escmi.poo.principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

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
import ar.edu.unju.escmi.poo.dominio.ClienteAgencia;
import ar.edu.unju.escmi.poo.dominio.ClienteParticular;
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
		Cliente unCliente = null;
		Mesa unaMesa = null;
		Mozo unMozo, mozoEncontrado;
		Reserva unaReserva = new Reserva();
		Salon unSalon;

		if (salonDao.obtenerSalones().size() == 0) {

			ArrayList<Mesa> mesas1 = new ArrayList<Mesa>();
			ArrayList<Mesa> mesas2 = new ArrayList<Mesa>();
			Salon salon1 = new Salon(mesas1);
			Salon salon2 = new Salon(mesas2);
			salonDao.guardarSalon(salon1);
			salonDao.guardarSalon(salon2);
			for (int i = 0; i < 20; i++) {
				Mesa mesa1 = new Mesa("Libre", 4, salon1);
				mesaDao.guardarMesa(mesa1);
				mesas1.add(mesa1);
			}
			for (int i = 0; i < 10; i++) {
				Mesa mesa2 = new Mesa("Libre", 4, salon2);
				mesaDao.guardarMesa(mesa2);
				mesas2.add(mesa2);
			}
			salon1.setMesas(mesas1);
			salon2.setMesas(mesas2);
			salonDao.modificarSalon(salon1);
			salonDao.modificarSalon(salon2);

		}
		
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
				if (mozoDao.obtenerMozos().size() < 6) {
					do {
						do {
							System.out.println("Ingrese el DNI del nuevo mozo");
							try {
								dni = sc.nextLong();
								bandera = true;
							} catch (InputMismatchException ime) {
								bandera = false;
								System.out.println("Formato Incorrecto");
								sc.next();
							}
						} while (bandera == false);

						try {
							mozoEncontrado = mozoDao.obtenerMozo(dni);
						} catch (NoResultException nre) {
							bandera = true;
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
				} else {
					System.out.println("Ya existen 6 mozos");
				}
			}
				break;
			case 2: {
				if (mozoDao.obtenerMozos().size() == 0) {
					System.out.println("Lista de mozos vacia");
				} else {
					System.out.println("=== Listado de Mozos ===");
					mozoDao.obtenerMozos().stream().forEach(System.out::println);
				}
			}
				break;
			case 3: {
				int opcion = 0, libre = 0, ocupado = 0;
				do {
					do {
						bandera = true;
						libre = 0;
						ocupado = 0;
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
						unSalon = salonDao.obtenerSalon(1);
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
						unSalon = salonDao.obtenerSalon(2);

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
						salonDao.obtenerSalon(1).getMesas().stream().filter(s -> s.getEstado().equals("Ocupado"))
								.forEach(System.out::println);
						break;
					case 2:
						salonDao.obtenerSalon(2).getMesas().stream().filter(s -> s.getEstado().equals("Ocupado"))
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
				boolean bandEncontrado = true, banderaSalon = false;
				int id = 0, comensales = 0, salonElegido = 0;

				if (mozoDao.obtenerMozos().isEmpty()) {
					System.out.println("Lo sentimos, no hay mozos disponibles en este momento");
				} else {
					ArrayList<Mozo> mozosDisponibles = new ArrayList<Mozo>();
					;

					for (int i = 0; i < mozoDao.obtenerMozos().size(); i++) {
						if (mozoDao.obtenerMozos().get(i).getReservasAtendidas() == null
								|| mozoDao.obtenerMozos().get(i).getReservasAtendidas().size() < 4) {
							mozosDisponibles.add(mozoDao.obtenerMozos().get(i));
						}
					}

					if (mozosDisponibles.size() != 0) {
						do {
							bandera = true;
							System.out.println("Ingrese el DNI o CUIL del usuario");
							try {
								dni = sc.nextLong();
							} catch (InputMismatchException ime) {
								bandera = false;
								System.out.println("Formato Incorrecto");
								sc.next();
							}
						} while (bandera == false);
						try {
							unCliente = clienteDao.obtenerClienteParticular(dni);
						} catch (NoResultException nre) {
							try {
								unCliente = clienteDao.obtenerClienteAgencia(dni);
							} catch (NoResultException nrex) {
								System.out.println("No se ha encontrado ningun usuario con dicho dni o cuil");
								bandEncontrado = false;
							}
						}
						if (bandEncontrado == false) {
							
							long telefono =0;
							System.out.println("Ingrese el nombre del cliente");
							String nombre = sc.next();
							System.out.println("Ingrese el email del cliente");
							String email = sc.next();
							do {
								System.out.println("Ingrese el telefono del cliente");
								bandera=true;
								try {
									telefono = sc.nextLong();
								}catch(InputMismatchException ime){
									bandera = false;
									System.out.println("Formato Incorrecto");
									sc.next();
								}
							}while (bandera==false);

							boolean tipoElegido = false;
							int opcion = 0;
							do {
								do {
									bandera = true;
									System.out.println("==== Registo de usuario ====");
									System.out.println("Seleccione el tipo de usuario:");
									System.out.println("1- Particular");
									System.out.println("2- Agencia");
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
									System.out.println("Ingrese su Apellido");
									String apellido = sc.next();
									unCliente = new ClienteParticular(nombre, email, telefono, apellido, dni);
									tipoElegido = true;
									break;
								case 2:
									unCliente = new ClienteAgencia(nombre, email, telefono, dni);
									tipoElegido = true;
									break;
								default:
									System.out.println("Opcion inexistente");
									break;
								}
							} while (tipoElegido == false);
							clienteDao.guardarCliente(unCliente);
						}

						do {
							System.out.println("Elija un mozo de la lista de mozos segun su ID:");
							unMozo = null;
							do {
								bandera = true;
								mozosDisponibles.stream().forEach(System.out::println);
								try {
									id = sc.nextInt();
								} catch (InputMismatchException ime) {
									bandera = false;
									System.out.println("Formato Incorrecto");
									sc.next();
								}
							} while (bandera == false);
							try {
								bandEncontrado = true;
								unMozo = mozoDao.obtenerMozoId(id);
							} catch (NoResultException nre) {
								System.out.println("Id inexistente, intente nuevamente");
								bandEncontrado = false;
							}
							if (unMozo != null) {
								if (unMozo.getReservasAtendidas() != null) {
									if (unMozo.getReservasAtendidas().size() == 4) {
										System.out.println(
												"El mozo seleccionado ya ha cumplido su trabajo el dia de hoy");
										bandEncontrado = false;
									}
								}
							}
						} while (bandEncontrado == false);
						do {
							bandera = true;
							System.out.println("Cuantos comensales seran?");
							try {
								comensales = sc.nextInt();
							} catch (InputMismatchException ime) {
								bandera = false;
								System.out.println("Formato Incorrecto");
								sc.next();
							}
						} while (bandera == false);
						ArrayList<Mesa> mesasS1 = new ArrayList<Mesa>();
						ArrayList<Mesa> mesasS2 = new ArrayList<Mesa>();
						int asientos1 = 0, asientos2 = 0;
						for (int i = 0; i < salonDao.obtenerSalon(1).getMesas().size(); i++) {
							unaMesa = salonDao.obtenerSalon(1).getMesas().get(i);
							if (unaMesa.getEstado().equals("Libre")) {
								mesasS1.add(unaMesa);
								asientos1 = asientos1 + 4;
							}
						}

						for (int i = 0; i < salonDao.obtenerSalon(2).getMesas().size(); i++) {
							unaMesa = salonDao.obtenerSalon(2).getMesas().get(i);
							if (unaMesa.getEstado().equals("Libre")) {
								mesasS2.add(unaMesa);
								asientos2 = asientos2 + 4;
							}
						}

						int mesasRequeridas = comensales / 4;
						if (comensales <= 4) {
							mesasRequeridas = 1;
						} else {
							if (comensales % 4 == 0) {
								mesasRequeridas = comensales / 4;
							} else {
								mesasRequeridas = comensales / 4;
								mesasRequeridas = mesasRequeridas + 1;
							}
						}

						if ((asientos1 >= comensales) && (asientos2 >= comensales)) {
							do {
								do {
									bandera = true;
									System.out.println("Elija en que salon desea ocupar");
									System.out.println("1- Salon 1");
									System.out.println("2- Salon 2");
									try {
										salonElegido = sc.nextInt();
									} catch (InputMismatchException ime) {
										bandera = false;
										System.out.println("Formato Incorrecto");
										sc.next();
									}
								} while (bandera == false);
								if (salonElegido==1 || salonElegido==2) {
								banderaSalon = true;
								}
								else {
									System.out.println("Salon ingresado inexistente");
									banderaSalon=false;
								}
							}while(banderaSalon==false);
							
						} else if (asientos1 >= comensales) {
							System.out.println("El unico salon disponible es el Salon 1");
							salonElegido = 1;
							banderaSalon = true;
						} else if (asientos2 >= comensales) {
							System.out.println("El unico salon disponible es el Salon 2");
							salonElegido = 2;
							banderaSalon = true;
						} else {
							System.out.println("No hay salones con el espacio requerido");
						}
						ArrayList<Mesa> mesasOcupadas = new ArrayList<Mesa>();

						if (banderaSalon == true) {
							if (salonElegido == 1) {
								//Se eligio el salon 1
								for (int i = 0; i < mesasRequeridas; i++) {
									mesasS1.get(i).setEstado("Ocupado");
									if (comensales >= 4) {
										comensales = comensales - 4;
										unaMesa = mesasS1.get(i);
										unaMesa.setCapacidad(unaMesa.getCapacidad() - 4);
									} else {
										int comensalesaux = comensales;
										comensales = comensales - comensales;
										unaMesa = mesasS1.get(i);
										unaMesa.setCapacidad(unaMesa.getCapacidad() - comensalesaux);
									}
									mesasOcupadas.add(unaMesa);
									mesaDao.modificarMesa(unaMesa);
								}
							} else {
								//Se eligio el salon 2
								mesasOcupadas = new ArrayList<Mesa>();
								for (int i = 0; i < mesasRequeridas; i++) {
									mesasS2.get(i).setEstado("Ocupado");
									if (comensales >= 4) {
										comensales = comensales - 4;
										unaMesa = mesasS2.get(i);
										unaMesa.setCapacidad(unaMesa.getCapacidad() - 4);
									} else {
										int comensalesaux = comensales;
										comensales = comensales - comensales;
										unaMesa = mesasS2.get(i);
										unaMesa.setCapacidad(unaMesa.getCapacidad() - comensalesaux);
									}
									mesasOcupadas.add(unaMesa);
									mesaDao.modificarMesa(unaMesa);
								}
							}
							double totalAPagar = 0;
							do {
								bandera = true;
								System.out.println("Ingrese el total a pagar");
								try {
									totalAPagar = sc.nextDouble();
								} catch (InputMismatchException ime) {
									bandera = false;
									System.out.println("Formato Incorrecto");
									sc.next();
								}
							} while (bandera == false);
							unSalon = salonDao.obtenerSalon(salonElegido);
							
							unaReserva=unaReserva.crearReserva(unCliente, unMozo, mesasOcupadas, salonElegido, totalAPagar);
							reservaDao.guardarReserva(unaReserva);

							if (unMozo.getReservasAtendidas() != null) {
								unMozo.getReservasAtendidas().add(unaReserva);
							} else {
								ArrayList<Reserva> reservasAAtender = new ArrayList<Reserva>();
								reservasAAtender.add(unaReserva);
								unMozo=unMozo.asignarReservas(unMozo, reservasAAtender);
							}
							mozoDao.modificarMozo(unMozo);
						}
					} else {
						System.out.println("Todos los mozos se encuentran ocupados por el momento");
					}
				}
			}
				break;
			case 6: {
				int opcion = 0;
				boolean reservaEncontrada = true;
				if (reservaDao.obtenerReservas().size()==0) {
				System.out.println("No hay reservas en el sistema");
				}
				else {
				
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
				if (unaReserva.getEstado().equals("Pagado")){
					System.out.println("Ya se pago esa Reserva");
				}
				else {
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
						
						unMozo=mozoDao.obtenerMozo(unaReserva.getMozoAtendiendo().getDni());
						for(int i=0;i<unMozo.getReservasAtendidas().size();i++){
							if(unMozo.getReservasAtendidas().get(i).getId()==unaReserva.getId()){
								unMozo.getReservasAtendidas().remove(i);
							}
						}
						mozoDao.modificarMozo(unMozo);
					}
				}
			}
			}
				break;
			case 7: {
				boolean bandAgencia = true, bandPart = true;
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
					unCliente = clienteDao.obtenerClienteAgencia(dni);
				} catch (NoResultException nre) {
					bandAgencia = false;
					unCliente = null;
				}
				if (unCliente == null) {
					try {
						unCliente = clienteDao.obtenerClienteParticular(dni);
					} catch (NoResultException nre) {
						bandPart = false;
						unCliente = null;
					}
				}
				if (bandAgencia == false && bandPart == false) {
					System.out.println("No se encontro ningun usuario");
				} else {
					System.out.println(unCliente);
				}

			}
				break;
			case 8: {
				int id = 0;
				System.out.println("====== RESERVAS SIN PAGAR (CANCELABLES) =====");
				reservaDao.obtenerReservas().stream().filter(s -> s.getEstado().equals("Sin Pagar")).forEach(System.out::println);
				System.out.println(" ");
				do {
					bandera = true;
					System.out.println("Ingrese el id de la Reserva");
					try {
						id = sc.nextInt();
					} catch (InputMismatchException ime) {
						bandera = false;
						System.out.println("Formato incorrecto");
						sc.next();
					}
				} while (bandera == false);
				bandera = true;
				try {
					unaReserva = reservaDao.obtenerReserva(id);
				} catch (NoResultException nre) {
					System.out.println("No se ha encontrado dicha reserva");
					bandera = false;
				}
				if (bandera == true) {
					if(unaReserva.getEstado().equals("Sin Pagar")) {
						List<Mesa> mesasALiberar = unaReserva.getMesasOcupadas();
						for(int i=0;i<mesasALiberar.size();i++) {
							unaMesa = mesasALiberar.get(i);
							unaMesa.setCapacidad(4);
							unaMesa.setEstado("Libre");
							mesaDao.modificarMesa(unaMesa);
						}
						unMozo=mozoDao.obtenerMozoId(unaReserva.getMozoAtendiendo().getId());
					for(int i=0;i<unMozo.getReservasAtendidas().size();i++){
						if(unMozo.getReservasAtendidas().get(i).getId()==unaReserva.getId()){
							unMozo.getReservasAtendidas().remove(i);
						}
					}
					mozoDao.modificarMozo(unMozo);
					reservaDao.borrarReserva(unaReserva);
					System.out.println("Reserva borrada/cancelada correctamente!");
					}
					else {
						System.out.println("Ingrese un id valido de una reserva para cancelarla, no se pueden eliminar las reservas ya pagadas");
					}	
				}
			}
				break;
			case 9: {
				reservaDao.obtenerReservas().stream().forEach(System.out::println);
			}
				break;
			case 10: {
				System.out.println("Saliendo del Programa...");
			}
				break;
			default: {
				System.out.println("Opcion Inexistente!");
			}
				break;
			}

		} while (opc != 10);
		sc.close();
	}

	private static void menu() {
		System.out.println("--------------- MENU PRINCIPAL ---------------");
		System.out.println("1-  Alta de Mozo.");
		System.out.println("2-  Listado de Mozos.");
		System.out.println("3-  Consultar disponibilidad de mesas según salón.");
		System.out.println("4-  Consultar mesas ocupadas y comensales.");
		System.out.println("5-  Alta de una reserva.");
		System.out.println("6-  Realizar la búsqueda de una reserva y modificar su pago.");
		System.out.println("7-  Consultar los datos del cliente ingresando cuil o dni.");
		System.out.println("8-  Eliminar una reserva ingresando el id.");
		System.out.println("9-  Listar todas las reservas.");
		System.out.println("10- Salir.");
		System.out.println("Elija una opcion:");
		System.out.println(" ");
	}

}
