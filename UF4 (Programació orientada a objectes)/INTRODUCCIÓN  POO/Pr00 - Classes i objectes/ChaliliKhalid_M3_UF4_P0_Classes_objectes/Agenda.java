import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Agenda {

	public static void main(String[] args) {
		//array de 100 personas
		Persona[] llistaPersones = new Persona[100];

		// Inicializamos un escaner
		Scanner sc = new Scanner(System.in);
		
		//construir el formato de la fecha
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		/* 
		 * variable option es el de la lista, el contador es el de añadir una 
		 * persona en la posición del array siguiente (nunca pisa el dato guardado
		 * anteriormente
		 */
		
		int option;
		int contador = 0;
		do {
			System.out.println("Opció: ");
			System.out.println("1. Afegir");
			System.out.println("2. Eliminar");
			System.out.println("3. Imprimir totes les persones del array");
			System.out.println("4. Diferencia edad entre dos persones");
			System.out.println("5. Sortir del programa");
			System.out.print("Tria una opció: ");
			
			//recogemos la opción dada
			option = sc.nextInt();

			switch (option) {
			case 1:
				// creamos una nueva persona.
				Persona p = new Persona();
				
				//el set recoge los datos con el escaner creado anteriormente.
				System.out.print("Introdueix el nom: ");
				p.setNom(sc.next());

				System.out.print("Introdueix el Cognom1: ");
				p.setCognom1(sc.next());

				System.out.print("Introdueix el Cognom2: ");
				p.setCognom2(sc.next());

				System.out.print("Introdueix el DNI: ");
				p.setDni(sc.next());

				System.out.print("Introdueix el eMail: ");
				p.seteMail(sc.next());

				System.out.print("Introdueix el Teléfon: ");
				p.setTel(Integer.parseInt(sc.next()));
				
				//pasamos el dato fecha en el formato que requiere.
				System.out.print("Data (dd/mm/yyyy): ");
				LocalDate data = LocalDate.parse(sc.next(), dtf);
				p.setNaixament(data);

				// guardamos los valores en el array y incrementamos el contador
				llistaPersones[contador++] = p;
				break;

			case 2:
				//en el if verificamos si es diferente a null (que hay datos) y eliminamos.
				System.out.print("\nIntrodueix la posició de la persona a esborrar: ");
				int eliminar = sc.nextInt() - 1;
				if (llistaPersones[eliminar] != null) {
					llistaPersones[eliminar] = null;
					/*
					 * llamamos al getNumPersonas para saber las personas que hay actualmente
					 * y poder restar una persona eliminada pasandola al setNumPersonas.
					 */
					int restaPersonas = Persona.getNumPersonas();
					Persona.setNumPersonas(restaPersonas - 1);
					System.out.println("El contacte ha sigut eliminat");

				} else {
					System.out.println("Error, no hi ha cap element en aquesta posició de l'agenda");
				}
				break;

			case 3:
				// Bucle for para mostrar todos los elementos del array
				for (int i = 0; i < llistaPersones.length; i++) {
					// if para validar si tiene valores, si es así muestra
					if (llistaPersones[i] != null) {
						System.out.println("*****************************\n************* " + (i+1) + " *************");
						// llama a la función imprimir() para mostrar los elementos de la persona.
						llistaPersones[i].imprimir();

					}
				}
				System.out.println("Total de persones: " + Persona.getNumPersonas());
				break;
			
			case 4:
				System.out.print("Introdueix la persona 1: ");
				int persona1 = sc.nextInt() -1;
				System.out.println("Edat de naixement: " + llistaPersones[persona1].getNaixament());
				System.out.print("Introdueix la persona 2: ");
				int persona2 = sc.nextInt() -1;
				System.out.println("Edat de naixement: " + llistaPersones[persona2].getNaixament());
				
				/*
				 * Guardamos la diferencia de edad en una variable y pasamos los dos datos al 
				 * set para que nos retorne el la diferencia.
				 */
				long diferencia = Persona.diferenciaEdad(llistaPersones[persona1], llistaPersones[persona2]);
				System.out.println("La diferencia d'edat és de: " + diferencia);
				
				
			default:
				break;

			}
		} while (option != 5);
	}

}
