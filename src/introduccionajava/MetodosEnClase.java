package introduccionajava;

public class MetodosEnClase {

	public static void main(String[] args) {
		// Llamamos a imprimirSuma
		imprimirSuma(5, 2); // vemos por pantalla 7
		
		// Usamos sumatoria para sumar hasta 5, 1 + 2 + 3 + 4 + 5 = 15
		int resultado = sumatoria(5);
		System.out.println("La sumatoria hasta 5 es: " + resultado);
		
		// Llamamos a reversa
		String resultadoReversa = reversa("hola");
		System.out.println(resultadoReversa);
		
		// Usamos suma para sumar todos los números de un arreglo
		int[] arregloDeNumeros = {1,2,3,4};
		int resultadoSumaArreglo = suma(arregloDeNumeros);
		System.out.println("El resultado de la suma del arreglo [1,2,3,4] es: " + resultadoSumaArreglo );
	
		// Dia laborable (ejercicio en clases), devuelve si un dia de la semana es laborable (true o false)
		boolean esLaborable = diaLaborable("lunes");
		System.out.println("El dia lunes es laborable --> " + esLaborable);
		System.out.println("El dia lunes es laborable --> " + diaLaborable("domingo"));

	}

	static void imprimirSuma(int a, int b) {
		System.out.println(a + b);
	}
	
	
	/*
	 * 1° --> i = 1, acumulador = 1
	 * 2° --> i = 2, acumulador = 3
	 * ..
	 * ..
	 * n° --> i = n ...
	 */
	static int sumatoria(int n) {
		int acumulador = 0;
		for (int i = 1; i <= n; i++) {
			acumulador = acumulador + i; 
		}
		
		return acumulador;
	}
	
	
	/*
	 * Ejemplo:
	 * entrada --> "hola"
	 * salida  --> "aloh"
	 */
	static String reversa(String cadena) {
		String cadenaEnReversa = "";
		for(int i =  cadena.length() - 1; i >= 0; i--) {
			cadenaEnReversa = cadenaEnReversa + cadena.charAt(i);
		}
		
		return cadenaEnReversa;
	}
	
	/*
	 * Ejemplo:
	 * entrada --> [1,2,3,4]
	 * salida  --> 10
	 */
	static int suma(int[] a) {
		int sumaTotal = 0;
		for(int i = 0; i <= a.length - 1; i++) {
			sumaTotal = sumaTotal + a[i];
		}
		
		return sumaTotal;
	}
	
	/*
	 * Ejemplo:
	 * entrada --> "lunes"
	 * salida  --> true
	 */
	static boolean diaLaborable(String dia) {
		String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes"};
		
		for(int i = 0; i <= dias.length - 1; i++) {
			
			// Comparamos uno a uno con los dias que definimos en el arreglo de String's
			// Si uno es igual al dia ingresado, inmediatamente retornamos el valor true y salimos de la función
			if(dias[i].equals(dia)) {
				return true;      
			}
		}
		
		// Si despues de recorrer todos los dias, no hubo ninguna coincidencia 
		// retornamos false
		return false;
	}
	
}
