package javase;

// import java.lang.*;

/**
 * Clase de ejemplo de inicio de Java
 * 
 * @author JavierLete
 *
 */
public class HolaMundo {
	/**
	 * M�todo que se ejecutar� cuando se inicie la aplicaci�n
	 * 
	 * @param args Argumentos de consola recibidos en un array
	 */
	public static void main(String[] args) {
		System.out.println("Hola Mundo"); // Muestra "Hola Mundo" por pantalla

		// Comentario
		// de
		// varias
		// l�neas

		// CTRL-MAY-7 � CTRL-7

		/*
		 * Comentario multil�nea mucho m�s c�modo
		 */

		// TIPOS PRIMITIVOS

		// Enteros TODOS CON SIGNO
		@SuppressWarnings("unused")
		byte b; // 8 bits -128 a 127
		@SuppressWarnings("unused")
		short s;// 16 bits -32768 a 32767
		int i; // 32 bits ~-4000M a ~4000M
		@SuppressWarnings("unused")
		long l; // 64 bits (trillones)

		i = 5;

		System.out.println("El valor de i es " + i);

		// COMA FLOTANTE | SIGNO | EXPONENTE | MANTISA (signo * mantisa * 2 ^ exponente)
		@SuppressWarnings("unused")
		float f; // 32 bits
		double d; // 64 bits

		d = 5.3E7; // 5000E-3 != 5 NUNCA COMPARAR IGUALDAD ENTRE N�MEROS DE COMA FLOTANTE

		System.out.println(d);

		// BOOLEANO S�LO PUEDEN VALER true O false
		@SuppressWarnings("unused")
		boolean bool;

		bool = true; // false

		// CARACTER
		@SuppressWarnings("unused")
		char c;

		c = 'l';

		// FIN DE TIPOS PRIMITIVOS (8)

		// Clases equivalentes a los tipos primitivos
		// Byte, Short, Integer, Long, Float, Double, Boolean, Character

		// OPERADORES
		// Matem�ticos: + - * / %

		int resto = 5 % 3; // El resto de dividir 5 / 3 es 2

		System.out.println(resto);

		// Comparaciones: ==, !=, <, >, <=, >=

		int x = 5;
		System.out.println(x == 3);

		System.out.println(x);

		// Operadores l�gicos: &&, ||, !

		System.out.println(!(1 <= x && x <= 10));

		System.out.println(1 > x || x > 10);

		// Operadores a nivel de bits: &, |, ~, ^
		x = 5 | 2; // XOR

		System.out.println(x);

		// Operadores de asignaci�n: =, +=, -=, *=, /= ...

		int y = x = 2;

		y += 5; // y = y + 5

		// Incremento decremento (--, ++)
		y = 1;

		System.out.println(++y); // PREincremento
		System.out.println(y++); // POSTincremento

		// Sentencias de control

		boolean estaArrancado = false;

		if (estaArrancado) {
			System.out.println("Verdadero");
		} else {
			System.out.println("Falso");
		}

		// if, switch, while, do while, for, break, continue
		bucleprincipal: for (int veces = 1; veces <= 2; veces++) {
			for (int indice = 1; indice <= 10; indice++) {
				if (indice % 3 == 0) {
					continue bucleprincipal; // break;
				}
				System.out.println(indice);
			}
		}
		
		// Tipos de datos b�sicos
		String nombreCompleto = "Javier Lete";
		String nombre = "Javier";
		String apellido = "Lete";
		
		System.out.println("Mi nombre es " + nombreCompleto);
		
		String nombreCompuesto = nombre + " " + apellido;
		
		if(nombreCompleto.equals(nombreCompuesto)) { //NUNCA CON ==
			System.out.println("Bienvenido profesor");
		} else {
			System.out.println("Bienvenido desconocido");
		}
		
		System.out.println("hola".toUpperCase());
		
		nombre = null;
		
		System.out.println("Javier".equals(nombre));
		System.out.println(nombre != null && nombre.equals("Javier"));
		
		System.out.println("      �lajsd �lkah  �lkaj ds�l hasd      ".trim());
	}

}

// javase.HolaMundo.main()