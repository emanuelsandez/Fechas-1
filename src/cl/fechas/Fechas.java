/*
 * ESTE PROGRAMA REALIZA LA COMPARACIÓN DE LAS FECHAS DE NACIMIENTO DE DOS PERSONAS
 * DEBE ENTREGAR COMO RESULTADO LA PERSONA DE MAYOR EDAD
 */
package cl.fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Fechas {
	static boolean validado;


//	METODO VALIDACION DE FECHA
	private static String validaFormatoFecha(String fechaIngresada) {

		validado = false;
		String fechaValidada = "";

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
		formatoFecha.setLenient(false);
		/*
		 * El método setLenient(boolean leniency) en la clase DateFormat se usa para
		 * especificar si la interpretación de la fecha y la hora de este objeto
		 * DateFormat debe ser indulgente o no.
		 */
		try {
			Date fecha = formatoFecha.parse(fechaIngresada);

			SimpleDateFormat nuevoFormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			fechaValidada = nuevoFormatoFecha.format(fecha);
			validado = true;

		} catch (ParseException e) {
			System.out.println("ERROR. DATO INCORRECTO!\n");

		}
		return fechaValidada;
	}

	
	
	//metodo principal
	public static void main(String[] args) {
		String fecha1, fecha2, fecha1OK, fecha2OK;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**** QUIEN ES EL MAYOR ? ****\n");
		
		//proceso de validación de fecha PERSONA 1
		do {
			System.out.println("PERSONA 1 \nIngrese fecha de nacimiento, 'dd/mm/yyyy'");
			fecha1 = sc.nextLine(); 
			fecha1OK = validaFormatoFecha(fecha1);
		} while (!validado);
		System.out.println(fecha1OK + "  FECHA VALIDA");

		//proceso de validación de fecha PERSONA 2
		do {
			System.out.println("\nPERSONA 2 \nIngrese fecha de nacimiento, 'dd/mm/yyyy'");
			fecha2 = sc.nextLine();

			fecha2OK = validaFormatoFecha(fecha2);

		} while (!validado);

		System.out.println(fecha2OK + "  FECHA VALIDA");

		sc.close();

		int diaFecha1 = Integer.parseInt(fecha1OK.substring(0, 2)); // dia primera fecha
		int diaFecha2 = Integer.parseInt(fecha2OK.substring(0, 2)); // dia segunda fecha
		int mesFecha1 = Integer.parseInt(fecha1OK.substring(3, 5)); // mes primera fecha
		int mesFecha2 = Integer.parseInt(fecha2OK.substring(3, 5)); // mes segunda fecha
		int agnoFecha1 = Integer.parseInt(fecha1OK.substring(6, 10)); // año primera fecha
		int agnoFecha2 = Integer.parseInt(fecha2OK.substring(6, 10)); // año segunda fecha

		// proceso de comparación de fechas

		int edadMayor;
		if (agnoFecha1 < agnoFecha2) {
			edadMayor = 1;
			System.out.println("\nRESULTADO\n*** LA PERSONA " + edadMayor + " ES MAYOR ***");
			
		} else if (agnoFecha1 > agnoFecha2) {
			edadMayor = 2;
			System.out.println("\nRESULTADO\n*** LA PERSONA " + edadMayor + " ES MAYOR ***");
			
		} else if (mesFecha1 < mesFecha2) {
			edadMayor = 1;
			System.out.println("\nRESULTADO\n*** LA PERSONA " + edadMayor + " ES MAYOR ***");
			
		} else if (mesFecha1 > mesFecha2) {
			edadMayor = 2;
			System.out.println("\nRESULTADO\n*** LA PERSONA " + edadMayor + " ES MAYOR ***");
			
		} else if (diaFecha1 < diaFecha2) {
			edadMayor = 1;
			System.out.println("\nRESULTADO\n*** LA PERSONA " + edadMayor + " ES MAYOR ***");
		
		} else if (diaFecha1 > diaFecha2) {
			edadMayor = 2;
			System.out.println("\nRESULTADO\n*** LA PERSONA " + edadMayor + " ES MAYOR ***");
			
		} else {
			System.out.println(" TIENEN LA MISMA EDAD !! ");
		}

	}
}
