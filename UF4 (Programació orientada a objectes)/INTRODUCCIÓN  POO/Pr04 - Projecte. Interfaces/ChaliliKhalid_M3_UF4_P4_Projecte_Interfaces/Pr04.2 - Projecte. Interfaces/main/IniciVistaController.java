package main;

import java.util.HashMap;
import java.util.Scanner;

import client.*;
import interfaces.*;
import persona.*;
import producte.*;
import proveidor.*;

public class IniciVistaController {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}
	
	public static void imprimirLista(HashMap<?, ?> lista) {
		//polimorfismo de interfaces
		int nObj= 1;
		for (Object objeto : lista.values()) {
			System.out.println("--------------" + String.format("%04d", nObj) + "--------------");
			Imprimible imprimirObjeto = (Imprimible)objeto;
			imprimirObjeto.imprimir();
		}
	}

	public static void menu() {
		// Iniciamos un escaner para recoger los datos por terminal.
		ProductesDAO daoProductes = new ProductesDAO();
		ClientsDAO daoClients = new ClientsDAO();
		ProveidorsDAO daoProveidors = new ProveidorsDAO();

		int menuInicial;
		do {
			System.out.println("\n1. Productes");
			System.out.println("2. Clients");
			System.out.println("3. Proveïdors");
			System.out.println("4. Sortir");
			System.out.print("Opció: ");

			menuInicial = sc.nextInt();

			switch (menuInicial) {

			case 1:
				// Inicializamos la clase ProductesDAO.

				// Iniciamos un escaner para recoger los datos por terminal.

				// Creamos la variable otion que será el encargado de elegir la opción del menú.
				int menuProductes;
				do {
					System.out.println("\n1. Afegir producte");
					System.out.println("2. Buscar producte");
					System.out.println("3. Modificar producte");
					System.out.println("4. Esborrar producte");
					System.out.println("5. Mostrar tots els productes");
					System.out.println("6. Tornar");
					System.out.print("Opció: ");

					menuProductes = sc.nextInt();

					switch (menuProductes) {

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

							/*
							 * Llamamos al método afegir de dao para añadir el producto. En ese método
							 * retorna false o true:
							 */
							if (daoProductes.afegir(producte)) {
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

							/*
							 * Llamamos al método afegir de dao para añadir el producto. En ese método
							 * retorna false o true:
							 */
							if (daoProductes.afegir(pack)) {
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
						ProducteAbstract prodBuscar = daoProductes.buscar(idBuscar);

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
						ProducteAbstract prodModificar = daoProductes.buscar(idModificar);

						if (prodModificar == null) {
							System.out.println("El producte indicat no existeix.");
						} else {

							System.out.println("-Els valors actuals són els seguents- ");
							prodModificar.imprimir();

							/*
							 * prodModificar es un objeto, como expliqué en el caso anterior de la búsqueda
							 * por lo tanto podemos sobreescribir el datos llamando el setXXXX del objeto **
							 * DE ESTA FORMA NO HARÁ FALTA PASAR NINGÚN VALOR AL MÉTODO ELIMINAR, YA QUE
							 * TENEMOS LOS SETTERS **
							 */
							System.out.println("\n-Introdueix els nous valors-");
							System.out.print("Introdueix el nom del producte        : ");
							String nouNom = sc.next();
							prodModificar.setNom(nouNom);

							System.out.print("Introdueix el preu de venda           : ");
							int nouPreuVenda = sc.nextInt();
							prodModificar.setPreuVenda(nouPreuVenda);

							if (prodModificar instanceof Producte) {

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

							daoProductes.modificar(prodModificar);
							System.out.println("\n-Els nous valors són els seguents-");
							prodModificar.imprimir();
							System.out.println("");

						}
						break;

					case 4:
						System.out.print("introdueix l'id del producte a eliminar: ");
						int idEliminar = sc.nextInt();
						ProducteAbstract prodEliminar = daoProductes.eliminar(idEliminar);

						if (prodEliminar == null) {
							System.out.println("El producte indicat no existeix.");
						} else {
							System.out.println("S'ha eliminat correctament ");

						}

						break;

					case 5:
						// polimorfismo
						imprimirLista(daoProductes.getLista());

						break;

					default:
						break;
					}

				} while (menuProductes != 6);

				break;

			case 2:

				int menuClients;

				do {
					System.out.println("\n1. Afegir client");
					System.out.println("2. Buscar client");
					System.out.println("3. Modificar client");
					System.out.println("4. Esborrar client");
					System.out.println("5. Mostrar tots els clients");
					System.out.println("6. Tornar");
					System.out.print("Opció: ");
					menuClients = sc.nextInt();
					// Inicializamos la clase ProductesDAO.

					switch (menuClients) {
					case 1:
						Client client = new Client();
						// Recojemos por consola los valores de cada característica del objeto
						System.out.print("Introdueix l'id del client            : ");
						client.setIdPersona(sc.nextInt());

						System.out.print("Introdueix el nom del client          : ");
						client.setNom(sc.next());

						System.out.print("Introdueix el document d'identitat    : ");
						client.setDni(sc.next());

						Adreca adreca = pedirAdreca();
						// añadimos la dirección en cliente
						client.setAdreca(adreca);
						System.out.println("--------Introdueix els telfèfons--------");
						int swTel = 1;
						int cantTel = 0;
						while (swTel != 0) {
							cantTel++;
							System.out.print("Introdueix el telèfon " + cantTel + "                : ");
							client.afegirTel(sc.next());
							System.out.print("Vols seguir afegint telèfons? (0=no / 1=si): ");
							swTel = sc.nextInt();
						}
						System.out.println("----------------------------------------");
						System.out.print("Enviar publicitat (si = 1 / no = 0)   : ");
						int enviarPublicitat = sc.nextInt();
						if (enviarPublicitat == 1) {
							client.setEnviarPublicitat(true);
						} else if (enviarPublicitat == 0) {
							client.setEnviarPublicitat(false);
						} else {
							System.out.println(
									"No has triat una opció correcta, " + "el valor per defecte es enviar publicitat");
							client.setEnviarPublicitat(true);
						}
						/*
						 * Llamamos al método afegir de dao para añadir el cliente. En ese método
						 * retorna false o true:
						 */
						if (daoClients.afegir(client)) {
							System.out.println("La persona s'ha afegit correctament.\n ");
						} else {
							System.out.println("L'id de la persona ja existeix.\n ");
						}
						break;

					case 2:
						System.out.print("introdueix l'id del client: ");

						int idBuscar = sc.nextInt();
						// Llamamos al método buscar de ProductesDAO
						Client clientBuscar = daoClients.buscar(idBuscar);

						// Si retorna null es porque no existe.
						if (clientBuscar == null) {
							System.out.println("El client indicat no existeix.\n ");
						} else { // Si no retorna el objeto, llamamos imprimir de Producte para mostrarlo.
							clientBuscar.imprimir();
							System.out.println("");
						}
						break;

					case 3:
						System.out.print("introdueix l'id del client a modificar     : ");

						int idModificar = sc.nextInt();
						Client clientModificar = daoClients.buscar(idModificar);
						if (clientModificar == null) {
							System.out.println("El client indicat no existeix.");
						} else {
							System.out.println("-Els valors actuals són els seguents- ");
							clientModificar.imprimir();

							System.out.print("Introdueix el nom del client          : ");
							clientModificar.setNom(sc.next());

							System.out.print("Introdueix el document d'identitat    : ");
							clientModificar.setDni(sc.next());

							Adreca adrecaModificar = pedirAdreca();
							// añadimos la dirección en cliente
							clientModificar.setAdreca(adrecaModificar);

							System.out.println("--------Introdueix els telfèfons--------");
							swTel = 1;
							while (swTel != 0) {
								System.out.print("Introdueix el telèfon a eliminar: ");
								if (clientModificar.eliminarTel(sc.next())) {
									System.out.print("Introdueix el telèfon nou       : ");
									clientModificar.afegirTel(sc.next());
									System.out.print("Vols seguir modificant telèfons? (0=no / 1=si): ");
									swTel = sc.nextInt();

								} else {
									System.out.println("El telèfon no existeix.");
								}
							}
							System.out.println("----------------------------------------");

							System.out.print("Enviar publicitat (si = 1 / no = 0)   : ");
							enviarPublicitat = sc.nextInt();
							if (enviarPublicitat == 1) {
								clientModificar.setEnviarPublicitat(true);
							} else if (enviarPublicitat == 0) {
								clientModificar.setEnviarPublicitat(false);
							} else {
								System.out.println("No has triat una opció correcta, "
										+ "el valor per defecte es enviar publicitat");
								clientModificar.setEnviarPublicitat(true);
							}

						}
						break;

					case 4:
						System.out.print("introdueix l'id del client a eliminar: ");
						int idEliminar = sc.nextInt();
						Client clientEliminar = daoClients.eliminar(idEliminar);

						if (clientEliminar == null) {
							System.out.println("El client indicat no existeix.");
						} else {
							System.out.println("S'ha eliminat correctament ");

						}
						break;

					case 5:
						// Llamamos el método imprimirLista del método ProductesDAO.
						imprimirLista(daoClients.getListaClients());
						break;
					}

				} while (menuClients != 6);

				break;

			case 3:
				int menuProveidors;
				do {
					System.out.println("\n1. Afegir proveïdor");
					System.out.println("2. Buscar proveïdor");
					System.out.println("3. Modificar proveïdor");
					System.out.println("4. Esborrar proveïdor");
					System.out.println("5. Mostrar tots els proveïdors");
					System.out.println("6. Tornar");
					System.out.print("Opció: ");
					menuProveidors = sc.nextInt();

					switch (menuProveidors) {
					case 1:
						Proveidor proveidor = new Proveidor();
						// Recojemos por consola los valores de cada característica del objeto
						System.out.print("Introdueix l'id del proveïdor         : ");
						proveidor.setIdPersona(sc.nextInt());

						System.out.print("Introdueix el nom del proveïdor       : ");
						proveidor.setNom(sc.next());

						System.out.print("Introdueix el document d'identitat    : ");
						proveidor.setDni(sc.next());

						Adreca adreca = pedirAdreca();
						// añadimos la dirección en cliente
						proveidor.setAdreca(adreca);

						System.out.println("--------Introdueix els telfèfons--------");
						int swTel = 1;
						int cantTel = 0;
						while (swTel != 0) {
							cantTel++;
							System.out.print("Introdueix el telèfon " + cantTel + "                : ");
							proveidor.afegirTel(sc.next());
							System.out.print("Vols seguir afegint telèfons? (0=no / 1=si): ");
							swTel = sc.nextInt();
						}
						System.out.println("----------------------------------------");

						System.out.print("Descompte a aplicar al Proveïdor      : ");
						proveidor.setDescompteProntoPago(sc.nextDouble());

						/*
						 * Llamamos al método afegir de dao para añadir el Proveïdor. En ese método
						 * retorna false o true:
						 */
						if (daoProveidors.afegir(proveidor)) {
							System.out.println("El proveïdor s'ha afegit correctament.\n ");
						} else {
							System.out.println("L'id del proveïdor ja existeix.\n ");
						}
						break;
					case 2:
						System.out.print("introdueix l'id del proveïdor: ");
						int idBuscar = sc.nextInt();
						// Llamamos al método buscar de ProductesDAO
						Proveidor ProveidorBuscar = daoProveidors.buscar(idBuscar);

						// Si retorna null es porque no existe.
						if (ProveidorBuscar == null) {
							System.out.println("El proveïdor indicat no existeix.\n ");
						} else { // Si no retorna el objeto, llamamos imprimir de Producte para mostrarlo.
							ProveidorBuscar.imprimir();
							System.out.println("");
						}
						break;

					case 3:
						System.out.print("introdueix l'id del proveïdor a modificar  : ");
						int idModificar = sc.nextInt();
						Proveidor proveidorModificar = daoProveidors.buscar(idModificar);
						if (proveidorModificar == null) {
							System.out.println("El proveïdor indicat no existeix.");
						} else {
							System.out.println("-Els valors actuals són els seguents- ");
							proveidorModificar.imprimir();

							System.out.print("Introdueix el nom del proveïdor       : ");
							proveidorModificar.setNom(sc.next());

							System.out.print("Introdueix el document d'identitat    : ");
							proveidorModificar.setDni(sc.next());

							Adreca adrecaModificar = pedirAdreca();
							// añadimos la dirección en cliente
							proveidorModificar.setAdreca(adrecaModificar);

							System.out.println("--------Introdueix els telfèfons--------");
							swTel = 1;
							while (swTel != 0) {
								System.out.print("Introdueix el telèfon a eliminar: ");
								if (proveidorModificar.eliminarTel(sc.next())) {
									System.out.print("Introdueix el telèfon nou       : ");
									proveidorModificar.afegirTel(sc.next());
									System.out.print("Vols seguir modificant telèfons? (0=no / 1=si): ");
									swTel = sc.nextInt();

								} else {
									System.out.println("El telèfon no existeix.");
								}
							}
							System.out.println("----------------------------------------");

							System.out.print("Descompte a aplicar al Proveïdor      : ");
							proveidorModificar.setDescompteProntoPago(sc.nextDouble());

						}
						break;
					case 4:
						System.out.print("introdueix l'id del proveïdor a eliminar: ");
						int idEliminar = sc.nextInt();
						Proveidor proveidorEliminar = daoProveidors.eliminar(idEliminar);

						if (proveidorEliminar == null) {
							System.out.println("El proveïdor indicat no existeix.");
						} else {
							System.out.println("S'ha eliminat correctament ");

						}
						break;

					case 5:
						// Llamamos el método imprimirLista del método ProductesDAO.
						imprimirLista(daoProveidors.getListaProveidors());
						break;
					}
				} while (menuProveidors != 6);

				break;

			default:
				break;
			}

		} while (menuInicial != 4);

	}

	public static Adreca pedirAdreca() {

		System.out.println("----------Introdueix l'adreça----------");
		Adreca adreca = new Adreca();
		System.out.print("Introdueix la població                : ");
		adreca.setPoblacio(sc.next());
		System.out.print("Introdueix la provincia               : ");
		adreca.setProvincia(sc.next());
		System.out.print("Introdueix el codi postal             : ");
		adreca.setCp(sc.next());
		System.out.print("Introdueix el domicili                : ");
		adreca.setDomicili(sc.next());
		System.out.println("---------------------------------------");

		return adreca;
	}
}
