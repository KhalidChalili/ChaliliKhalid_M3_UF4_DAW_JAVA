// Esta clase es el constructor de la aplicación.
public class Producte {
	// Características del objeto
	private int idProducte, preuVenda, stock;
	private String nom;

	
	// Constructores
	public Producte() {
		this(0,"", 0, 0);
	}
	
	public Producte(int idProducte) {
		this(idProducte,"", 0, 0);
	}
		
	public Producte(int idProducte, String nom) {
		this(idProducte, nom, 0, 0);
	}
	
	public Producte(int idProducte, String nom, int preuVenda) {
		this(idProducte, nom, preuVenda, 0);
	}
	
	public Producte(int idProducte, String nom, int preuVenda, int stock) {
		this.idProducte = idProducte;
		this.preuVenda = preuVenda;
		this.stock = stock;
		this.nom = nom;
	}

	// Getters y setters
	public int getIdProducte() {
		return idProducte;
	}

	public void setIdProducte(int idProducte) {
		this.idProducte = idProducte;
	}

	public int getPreuVenda() {
		return preuVenda;
	}

	public void setPreuVenda(int preuVenda) {
		this.preuVenda = preuVenda;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Método imprimir, imprime el this en ese momento del objeto.
	public void imprimir() { //SETTER
		System.out.println("ID del producte:      " + idProducte);
		System.out.println("Nom del producte:     " + nom);
		System.out.println("Preu de venda:        " + preuVenda);
		System.out.println("Stock en el magatzem: " + stock);
	}
	

}
