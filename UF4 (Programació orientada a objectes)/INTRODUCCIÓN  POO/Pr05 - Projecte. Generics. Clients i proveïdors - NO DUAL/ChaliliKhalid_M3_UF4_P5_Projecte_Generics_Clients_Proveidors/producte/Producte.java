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

	@Override
	public String toString() {
		return  super.toString() + "Producte [stock=" + stock + ", idProveidor=" + idProveidor + "]";
	}
	
}
