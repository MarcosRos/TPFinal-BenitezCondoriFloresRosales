package ar.edu.unju.escmi.poo.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FechaUtil {

	public static LocalDate convertirStringLocalDate(String fecha) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaLocalDate = LocalDate.parse(fecha,formato);
		return fechaLocalDate;
	}
	
	public static String convertirLocalDateString(LocalDate fechaLocalDate) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaString = formato.format(fechaLocalDate);
		return fechaString;
	}
	
	public static int calcularAntiguedad(LocalDate fechaIngreso) {
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaIngreso, ahora);
		return periodo.getYears();
	}

}
