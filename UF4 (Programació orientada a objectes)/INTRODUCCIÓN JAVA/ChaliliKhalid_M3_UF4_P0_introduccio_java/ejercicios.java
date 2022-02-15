public class ejercicios {

	public static void main(String[] args) {
		ej1();
	}
	
	/* 1. Imprimeix per pantalla �Estic estudiant a L�Institut de 
	 * Badia del Vall�s i estic executant amb eclipse�.
	 */
	public static void ej1()  {
		System.out.println("Estic estudiant a L�Institut de Badia del Vall�s i estic executant amb eclipse");
	}
	
	/* 2. Recorre i imprimeix la llista d�arguments (array) que es passa 
	 * a una aplicaci� Java pel m�tode main.
	 */
	// array son los parametros que recibe, en nuestro caso un array.
	// NO IMPORTA QU� NOMBRE PONER, LO QUE IMPORTA ES LA POSICI�N DE LOS DATOS QUE RECIBE.
	public static void ej2(String [] array) {
		/* Bucle for donde i vale 0 inicialmente para despu�s recorrer 
		 * la cantidad de valores que hay en el array. Dentro del bucle imprime el
		 * valor de la del array dependiendo de la posicion que recorre el bucle. valor 0
		 * es la pisic�n 1 del aray.
		 */
		for (int i=0; i< array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	/* 3. Mostrar per pantalla la suma de tots els n�meros senars 
	 * compresos entre dos n�meros enters emmagatzemats en variables.
	 */
	public static void ej3() {
		// Guardamos los valores de tipo Integer en variables de tipo Integer:
		int var1 = 1;
		int var2 = 14;
		int sum = 0;
		
		// Bucle for parecida a la pr�ctica anterior
		for (int i = var1 ; i <= var2; i++) {
			// si el resultado es igual a 1 en el c�lculo matematico, quiere decir que es impar.
			if ((i%2) == 1) {
				//Tambi�n podemos sumar de esta manera: sum += i;
				sum = sum + i;
			  }
		}
		System.out.println("suma de n�meros impares " + sum);
	}
	
	/* 4. A partir d�una cadena de la classe String, recorre-la 
	 * caracter a caracter i retorna o mostra per pantalla la cadena girada.
	 */
	public static void ej4() {
		String cadena = "Hola";
		String invertida = "";
		
		// length() lee cuantas letras tiene el string
		System.out.println(cadena.length());
		
		/* Restamos -1 ya que la posicion H es el 0. y el 4 no existe.
		 * Empezamos el bucle de mayor a menro para que pueda recorrer la palabra
		 * de derecha a izquierda.
		 */
		for (int longitud = cadena.length() -1; longitud >= 0; longitud--) {
			// con -charAt(incremento del bucle) concatena los Strings.
			invertida += cadena.charAt(longitud);
		}
		
		System.out.println("Cadena original: " + cadena);
		System.out.println("Cadena invertida: " + invertida);
	
	}
	
	/* 5. Fes el mateix que al punt anterior per� amb una cadena 
	 * de la classe StringBuilder.
	 */
	public static void ej5() {
		/* Convertimos el String en StringBuilder. 
		 * con .reverse() recorremos el string.
		 * Podemos crearlo en una sola linea:
		 * StringBuilder cadena=new StringBuilder("Hola".toString()).reverse();
		 */
		StringBuilder cadena=new StringBuilder("Hola");
		String cadenaInvertida=cadena.reverse().toString();
		System.out.println(cadenaInvertida);
				
		
	}
	
	/* 6. A partir d�un array de n�meros sencers sense ordre, calcula 
	 * la suma de tots els n�meros emmagatzemats mostrant a m�s el 
	 * major i el menor dels n�meros.
	 */
	public static void ej6() {
		int[] array = { 4, 3, 2, 5, 1};
		int numMenor = array[0];
		int numMayor = array[0];
		int suma = 0;
		
		for(int posicion = array.length -1; posicion >=0; posicion-- ) {
			int numero = array[posicion];
			suma += numero;
			if (numero > numMayor) {
				numMayor = numero;
			} if (numero < numMenor) {
				numMenor = numero;
			}		
		}
		
		System.out.println("numero Mayor " + numMayor);
		System.out.println("numero Menor " + numMenor);
		System.out.println("suma " + suma);
	}
	
	/* 7. A partir d�un array format per 5 n�meros sencers, ordena de menor 
	 * a major els n�meros dins de l�array i posteriorment mostra l�array 
	 * per pantalla. Utilitza l�algoritme de la bombolla.
	 */
	public static void ej7() {
		int array[] = {5,3,2,7,6};
		
		for (int i = 0; i <= array.length -1; i++) {
			for (int j = 0; j <= array.length -2; j++) {
				/*se compara la posici�n j con la siguiente, si es mayor entonces 
				 * se guarda una variable temporal de la posici�n siguiente (j+1) 
				 * para luego escribirla en la posici�n inicial.
				 */
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j +1] = array[j];
					array[j] = temp;
				}
			}
		
		}
		
		// Resultado
		for (int x = 0; x <= array.length -1; x++) {
		System.out.println(array[x]);
		}
	}
	
	/*
	 * 8. Mostra per pantalla el resultat de calcular el factorial d�un n�mero
	 * passat com a argument de l�aplicaci�.
	 */
	public static void ej8(String[] args8) {
		//pasamos la variable de String a Integer
		int numero = Integer.parseInt(args8[0]);
		//El valor factorial es 1 para que se pueda multiplicar
		int factorial = 1;
		System.out.println("integer: " + numero);
		/* Un bucle while donde compara si el numero es diferente a 0 
		 * por que hay un contador que va restando menos uno cada vez 
		 * acaba cuando est� dentro del bucle, restamos numero,
		 * que es el argumento que pasamos. 
		 */
		while (numero != 0) {
			factorial *= numero;
			numero--;
		}
		System.out.println("factorial: " + factorial);
	}
}
