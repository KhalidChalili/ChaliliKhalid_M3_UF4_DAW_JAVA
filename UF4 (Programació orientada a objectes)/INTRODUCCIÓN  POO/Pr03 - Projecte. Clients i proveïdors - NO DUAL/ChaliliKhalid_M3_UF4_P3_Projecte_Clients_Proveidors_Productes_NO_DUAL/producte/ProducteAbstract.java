package producte;
// Esta clase es el constructor de la aplicación.
public abstract class ProducteAbstract {
	// Características del objeto
	private int idProducte, preuVenda;
	private String nom;

	
	// Constructores
	public ProducteAbstract() {
		this(0,"", 0);
	}
	
	public ProducteAbstract(int idProducte) {
		this(idProducte,"", 0);
	}
		
	public ProducteAbstract(int idProducte, String nom) {
		this(idProducte, nom, 0);
	}
	
	
	public ProducteAbstract(int idProducte, String nom, int preuVenda) {
		this.idProducte = idProducte;
		this.preuVenda = preuVenda;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Método imprimir, imprime el this en ese momento del objeto.
	public void imprimir() { //SETTER
		System.out.println("---------Dades generals---------");
		System.out.println("Id del producte       :" + idProducte);
		System.out.println("Nom del producte      :" + nom);
		System.out.println("Preu de venda         :" + preuVenda);
		System.out.println("--------------------------------");
	}
	

}
