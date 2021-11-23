package ar.edu.unju.escmi.poo.test;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.ClienteAgencia;
import ar.edu.unju.escmi.poo.dominio.Mesa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Reserva;
import junit.framework.TestCase;

public class ReservaTest extends TestCase{
	
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
	public void testVerificarCrearReserva() {
		Cliente unCliente= new ClienteAgencia();
		Mozo unMozo=new Mozo();
		ArrayList<Mesa> mesas=new ArrayList<Mesa>();
		Reserva unaReserva=new Reserva(), unaReserva2=null;
		unaReserva2=unaReserva.crearReserva(unCliente, unMozo, mesas, 1, 0,LocalTime.now());
		
		assertNotNull(unaReserva2);
	}

}
