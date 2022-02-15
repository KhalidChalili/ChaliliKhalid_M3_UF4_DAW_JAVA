package producte;

public final class Producte extends ProducteAbstract {
	private int stock, idProveidor;
	
	public Producte() {
		super();
	}
	// constructor completo.
	public Producte(int idProducte, String nom, int preuVenda, int stock, int idProveidor) {
		super(idProducte,nom,preuVenda);
		this.setStock(stock);
		this.setIdProveidor(idProveidor);
	}
	// getters & setters
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdProveidor() {
		return idProveidor;
	}

	public void setIdProveidor(int idProveidor) {
		this.idProveidor = idProveidor;
	}
	// Lo mismo que Pack.
	public void imprimir() { //SETTER
		super.imprimir();
		System.out.println("------Desdes del producte------");
		System.out.println("Stock del producte    : " + stock);
		System.out.println("Id del proveidor      : " + idProveidor);
		System.out.println("--------------------------------");

	}
}
