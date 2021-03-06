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
		
		// Creamos la variable otion que ser? el encargado de elegir la opci?n del men?.
		int option;
		do {
			System.out.println("0. Sortir");
			System.out.println("1. Afegir producte");
			System.out.println("2. Buscar producte");
			System.out.println("3. Modificar producte");
			System.out.println("4. Esborrar producte");
			System.out.println("5. Mostrar tots els productes");
			System.out.print("Opci?: ");
			
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				// Creamos un nuevo objeto producte.
				Producte p = new Producte();
				// Recojemos por consola los valores de cada caracter?stica del objeto
				System.out.print("Introdueix l'id del producte          : ");
				p.setIdProducte(sc.nextInt());

				System.out.print("Introdueix el nom del producte        : ");
				p.setNom(sc.next());

				System.out.print("Introdueix el preu de venda           : ");
				p.setPreuVenda(sc.nextInt());
				
				System.out.print("Introdueix l'estoc del nou producte   : ");
				p.setStock(sc.nextInt());
				
				/* Llamamos al m?todo afegir de dao para a?adir el producto. 
				 * En ese m?todo retorna false o true:
				 */
				if(dao.afegir(p)) {
					System.out.println("EL producte ha sigut afegit correctament.\n ");
				} else {
					System.out.println("L'id del producte ja existeix.\n ");
				}

				break;

			case 2:
				System.out.print("introdueix l'id del producte: ");
				int idBuscar = sc.nextInt();
				// Llamamos al m?todo buscar de ProductesDAO
				Producte prodBuscar = dao.buscar(idBuscar);
				
				// Si retorna null es porque no existe.
				if (prodBuscar == null) {
					System.out.println("El producte indicat no existeix.\n ");
				} else { // Si no retorna el objeto, llamamos imprimir de Producte para mostrarlo.
					prodBuscar.imprimir();
					System.out.println("");
				}
				break;
				
			case 3:
				System.out.print("introdueix l'id del producte a modificar: ");
				// La b?squeda del producto es como en el caso anterior.
				int idModificar = sc.nextInt();
				Producte prodModificar = dao.buscar(idModificar);
				
				if (prodModificar == null) {
					System.out.println("El producte indicat no existeix.");
				} else {
					System.out.println("-Els valors actuals s?n els seguents- ");
					prodModificar.imprimir();
					
					/* prodModificar es un objeto, como expliqu? en el caso anterior de la b?squeda
					 * por lo tanto podemos sobreescribir el datos llamando el setXXXX del objeto
					 * ** DE ESTA FORMA NO HAR? FALTA PASAR NING?N VALOR AL M?TODO ELIMINAR, YA QUE 
					 * TENEMOS LOS SETTERS **
					 */
					System.out.println("\n-Introdueix els nous valors-");
					System.out.print("Introdueix el nom del producte        : ");
					String nouNom = sc.next();
					prodModificar.setNom(nouNom);

					System.out.print("Introdueix el preu de venda           : ");
					int nouPreuVenda = sc.nextInt();
					prodModificar.setPreuVenda(nouPreuVenda);
					
					System.out.print("Introdueix l'estoc del nou producte   : ");
					int nouStock = sc.nextInt();
					prodModificar.setStock(nouStock);
					
					dao.modificar(prodModificar);
					System.out.println("\n-Els nous valors s?n els seguents-");
					prodModificar.imprimir();
					System.out.println("");
					
				}
				
				
				break;
				
			case 4:
				System.out.print("introdueix l'id del producte a eliminar: ");
				int idEliminar = sc.nextInt();
				Producte prodEliminar = dao.eliminar(idEliminar);
				
				if (prodEliminar == null) {
					System.out.println("El producte indicat no existeix.");
				} else {
					System.out.println("S'ha eliminat correctament ");
					
				}
				
				
				break;
				
			case 5:
				// Llamamos el m?todo imprimirLista del m?todo ProductesDAO.
				dao.imprimirLista();
				
				break;
				
			default:
				break;
			}
			
		} while (option!= 0);
	}

}
