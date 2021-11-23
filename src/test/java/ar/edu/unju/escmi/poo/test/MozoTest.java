package ar.edu.unju.escmi.poo.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import junit.framework.TestCase;

public class MozoTest extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inicio Test");
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Fin Test");
		super.tearDown();
	}

	@Test
	public void testAsignarReserva() {
		Mozo unMozo=new Mozo("pepe","asd",1,null);
		Reserva unaReserva=new Reserva(null,unMozo,null,1,LocalDate.now(),LocalTime.now(),1,"ASD");
		ArrayList<Reserva> reservas=new ArrayList<Reserva>();
		reservas.add(unaReserva);
		unMozo=unMozo.asignarReservas(unMozo, reservas);
		assertNotNull(unMozo.getReservasAtendidas());
	}

}
