import java.text.DecimalFormat;
import java.util.*;

import javax.swing.JOptionPane;

public class sintaxi {

	public static void main(String[] args) {

		ej4(args);
	}

	public static void ej1(String[] argumento) {
		/* Nuestro objeto escaner va a tomar información del origen el sistema
		 * (introducción de información
		 */
		Scanner entrada = new Scanner(System.in);
		
		// consegumos que la consola del sistema pida el dato de tipo Int
		System.out.println("Por favor, introduce un valor de tip Integer: ");
		int argumento1 = entrada.nextInt();
		
		/* nextDouble, nextInt, nextLine
		 * no son estáticos, por lo tanto necesitan un objeto, en nuestro caso es Scanner.
		 */
		int factorial = 1;
		int sumaFactorial = 0;
		for (int contadorFactorial = argumento1; contadorFactorial > 0; contadorFactorial--) {
			int numero = contadorFactorial;
			while (numero != 0) {
				factorial *= numero;
				numero--;
			}
			sumaFactorial += factorial;

		}
		System.out.println("Suma factorial: " + sumaFactorial);
	}
	
	public static void ej2() {
		// pedir numero por pantalla y convertirlo en Integer directamente
		String entrada = JOptionPane.showInputDialog("Introduce un numero entero: ");
		int valor = Integer.parseInt(entrada) + 1;
		
		//bucle for que recorre de menor a mayor
		for (int i = 0; i < valor; i++) {
			
			//variable integer para ser utilizado como contador
			int max = 0;
			/* i será un numero incremental por el for, y max será un 0 inicialmente, 
			 * cuando coincida es igual, y no diferente
			 */
			while (i != max) {
				System.out.print("*");
				max++;
			}
			// el salto de linea
			System.out.println("");
			
		}
	}
	
	public static void ej3() {
		int matrizA [][] = {{2,0,1},{3,0,0},{5,1,1}};
		int matrizB [][] = {{1,0,1},{1,2,1},{1,1,0}};
		int matrizC [][] = new int [3][3];
		// guardamos en variables la cantidad de filas y columnas de cada array
		int filaMatrizA = matrizA.length;		
		int columnaMatrizA = matrizA[0].length;

		int filaMatrizB = matrizB.length;		
		int columnaMatrizB = matrizB[0].length;
		
		int filaMatrizC = matrizC.length;		
		int columnaMatrizC = matrizC[0].length;
		
		// verificamos si la fila de una matriz y la columna de la otra matriz se puedan multiplicar
		if (columnaMatrizA != filaMatrizB) {
			System.out.println("No se pueden multiplicar las matrices");
		} else {
			// print de las dos matrices.
			System.out.println("|MatrizA|");
			for (int i = 0; i < filaMatrizA; i++) {
				for (int j = 0; j < columnaMatrizA; j++) {
					System.out.print("|" + matrizA[i][j] + "|");
				}
				System.out.println("");
			}
			
			System.out.println("|MatrizB|");
			for (int i = 0; i < filaMatrizB; i++) {
				for (int j = 0; j < columnaMatrizB; j++) {
					System.out.print("|" + matrizB[i][j] + "|");
				}
				System.out.println("");
			}
			
			// variables de reconocimiento de filas y columnas
			/* EXPLICACIÓN
			 * i (fila) j (columna) de la matriz C,
			 * con la k especificamos la posición a utilizar
			 */
			
			for (int i = 0; i < filaMatrizC; i++) {
				for (int j = 0; j < columnaMatrizC; j++) {
					for (int k = 0; k < columnaMatrizA; k++) {
						matrizC[i][j] += matrizA[i][k]*matrizB[k][j];
					}
				}
			}
			
			
			// print del resultado
			System.out.println("|matrizC|");
			for (int i = 0; i < filaMatrizC; i++) {
				for (int j = 0; j < columnaMatrizC; j++) {
					System.out.print("|" + matrizC[i][j] + "|");
				}
				System.out.println("");
			}
		}
		
	}
	
	public static void ej4(String[] argumento) {
		// la variable numero es el argumento que le damos (no importa si es int o no)
		double numero = Double.parseDouble(argumento[0]);

		//dividimos el numero por 10, para que tengamos el cociente de la divison.
		double valor = numero / 10;
		
		// redoneamos el valor, en este caso lo pasamos en una variable
		int proporcion = (int)valor;
		for (int i = 1; i < 11 ; i++) {
			int cociente = proporcion * i;
			for (int j = 0; j <= numero; j++) {
				if (j == cociente) {
					System.out.print(" * ");
					
					
				}
				
			}
						
		}
		
	}
	

}
