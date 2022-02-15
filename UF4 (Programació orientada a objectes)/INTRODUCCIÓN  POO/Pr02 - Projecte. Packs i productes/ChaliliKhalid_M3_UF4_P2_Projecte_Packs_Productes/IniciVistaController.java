import java.util.Scanner;

/* Clase donde contiene el main. no elimina ni borra
 * esa tarea se encarga de la clase DAO, simplemente
 * se encarga de interactuar con el usuario.
 */
public class IniciVistaController {

	public static void main(String[] args) {
		// Inicializamos la clase ProductesDAO.
		ProductesDAO dao = new ProductesDAO();
		
		// Iniciamos un escaner para recoger los datos por terminal.
		Scanner sc = new Scanner(System.in);
		
		// Creamos la variable otion que será el encargado de elegir la opción del menú.
		int option;
		do {
			System.out.println("0. Sortir");
			System.out.println("1. Afegir producte");
			System.out.println("2. Buscar producte");
			System.out.println("3. Modificar producte");
			System.out.println("4. Esborrar producte");
			System.out.println("5. Mostrar tots els productes");
			System.out.print("Opció: ");
			
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				// Creamos un nuevo objeto producte.
				System.out.print("Introduir Producte = 0 :: introduir Pack = 1: ");
				int tipusProducte = sc.nextInt();

				if (tipusProducte == 0) {
					Producte producte = new Producte();
					// Recojemos por consola los valores de cada característica del objeto
					System.out.print("Introdueix l'id del producte          : ");
					producte.setIdProducte(sc.nextInt());

					System.out.print("Introdueix el nom del producte        : ");
					producte.setNom(sc.next());

					System.out.print("Introdueix el preu de venda           : ");
					producte.setPreuVenda(sc.nextInt());
					
					System.out.print("Introdueix el Stock                   : ");
					producte.setStock(sc.nextInt());
					System.out.print("Introdueix l'id del proveïdor         : ");
					producte.setIdProveidor(sc.nextInt());	
					
					/* Llamamos al método afegir de dao para añadir el producto. 
					 * En ese método retorna false o true:
					 */
					if(dao.afegir(producte)) {
						System.out.println("EL producte ha sigut afegit correctament.\n ");
					} else {
						System.out.println("L'id del producte ja existeix.\n ");
					}
				} else if (tipusProducte == 1) {
					Pack pack = new Pack();
					// Recojemos por consola los valores de cada característica del objeto
					System.out.print("Introdueix l'id del pack              : ");
					pack.setIdProducte(sc.nextInt());

					System.out.print("Introdueix el nom del pack            : ");
					pack.setNom(sc.next());

					System.out.print("Introdueix el preu de venda           : ");
					pack.setPreuVenda(sc.nextInt());
					
					System.out.print("introdueix el descompte               : ");
					pack.setDescompte(sc.nextInt());
					
					int switchBucle = 1;					
					while (switchBucle != 0) {
						System.out.print("Introdueix el id del productes existents a afegir en el pack: ");
						int idProducte = sc.nextInt();
						pack.afegirProducte(idProducte);
						System.out.print("Vols seguir afegint productes en el pack? (0=no / 1=si): ");
						switchBucle = sc.nextInt();
					}

					/* Llamamos al método afegir de dao para añadir el producto. 
					 * En ese método retorna false o true:
					 */
					if(dao.afegir(pack)) {
						System.out.println("EL pack ha sigut afegit correctament.\n ");
					} else {
						System.out.println("L'id del producte ja existeix.\n ");
					}

				} else {
					System.out.println("No has introduït el valor correcte");
					break;
				}
				


				

				
				break;

			case 2:
				System.out.print("introdueix l'id del producte: ");
				int idBuscar = sc.nextInt();
				// Llamamos al método buscar de ProductesDAO
				ProducteAbstract prodBuscar = dao.buscar(idBuscar);
				
				// Si retorna null es porque no existe.
				if (prodBuscar == null) {
					System.out.println("El producte indicat no existeix.\n ");
				} else { // Si no retorna el objeto, llamamos imprimir de Producte para mostrarlo.
					prodBuscar.imprimir();
					System.out.println("");
				}
				break;
				
			case 3:
				System.out.print("introdueix l'id del producte a modificar  : ");
				// La búsqueda del producto es como en el caso anterior.
				int idModificar = sc.nextInt();
				ProducteAbstract prodModificar = dao.buscar(idModificar);

				if (prodModificar == null) {
					System.out.println("El producte indicat no existeix.");
				} else {

					System.out.println("-Els valors actuals són els seguents- ");
					prodModificar.imprimir();
					
					/* prodModificar es un objeto, como expliqué en el caso anterior de la búsqueda
					 * por lo tanto podemos sobreescribir el datos llamando el setXXXX del objeto
					 * ** DE ESTA FORMA NO HARÁ FALTA PASAR NINGÚN VALOR AL MÉTODO ELIMINAR, YA QUE 
					 * TENEMOS LOS SETTERS **
					 */
					System.out.println("\n-Introdueix els nous valors-");
					System.out.print("Introdueix el nom del producte        : ");
					String nouNom = sc.next();
					prodModificar.setNom(nouNom);

					System.out.print("Introdueix el preu de venda           : ");
					int nouPreuVenda = sc.nextInt();
					prodModificar.setPreuVenda(nouPreuVenda);
					
					if(prodModificar instanceof Producte) {
						
						System.out.print("Introdueix el stock                : ");
						int nouStock = sc.nextInt();
						((Producte) prodModificar).setStock(nouStock);
					} else if (prodModificar instanceof Pack) {
						System.out.print("Introdueix el descompte            : ");
						int nouDescompte = sc.nextInt();				
						((Pack) prodModificar).setDescompte(nouDescompte);
						
						int switchBucle = 1;					
						while (switchBucle != 0) {
							System.out.print("Introdueix el id a reemplaçar: ");
							int idProducte = sc.nextInt();
							((Pack) prodModificar).esborrarProducte(idProducte);
							System.out.print("Introdueix el nou valor: ");
							idProducte = sc.nextInt();
							((Pack) prodModificar).afegirProducte(idProducte);
							System.out.print("Vols seguir reempaçant productes en el pack? (0=no / 1=si): ");
							switchBucle = sc.nextInt();
						}
					} else {
						System.out.println("Hi ha un error");
					}

					dao.modificar(prodModificar);
					System.out.println("\n-Els nous valors són els seguents-");
					prodModificar.imprimir();
					System.out.println("");
				
				}
				
				
				break;
				
			case 4:
				System.out.print("introdueix l'id del producte a eliminar: ");
				int idEliminar = sc.nextInt();
				ProducteAbstract prodEliminar = dao.eliminar(idEliminar);
				
				if (prodEliminar == null) {
					System.out.println("El producte indicat no existeix.");
				} else {
					System.out.println("S'ha eliminat correctament ");
					
				}
								
				break;
				
			case 5:
				// Llamamos el método imprimirLista del método ProductesDAO.
				dao.imprimirLista();
				
				break;
				
			default:
				break;
			}
			
		} while (option!= 0);
	}

}
