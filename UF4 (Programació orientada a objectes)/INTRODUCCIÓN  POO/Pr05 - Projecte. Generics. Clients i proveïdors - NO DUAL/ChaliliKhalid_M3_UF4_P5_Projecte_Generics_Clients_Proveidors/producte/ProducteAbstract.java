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

	@Override
	public String toString() {
		return "ProducteAbstract [idProducte=" + idProducte + ", preuVenda=" + preuVenda + ", nom=" + nom + "]";
	}
	
}
