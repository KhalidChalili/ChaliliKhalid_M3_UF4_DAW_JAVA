package producte;
import java.util.ArrayList;

public final class Pack extends ProducteAbstract {
	// ArrayList de valores int con el nombre packProducte
	private ArrayList<Integer> packProducte = new ArrayList<Integer>();
	private int descompte;
	//Constructor sin valores a excepci�n de ProducteAbstract
	public Pack() {
		super();
	}
	// Constructor completo de Pack
	public Pack(int idProducte, String nom, int preuVenda, int descompte) {
		super(idProducte,nom,preuVenda);
		this.setDescompte(descompte);
	}
	// get de array packProducte
	public ArrayList<Integer> getPackProducte() {
		return packProducte;
	}
	
	public int getDescompte() {
		return descompte;
	}

	public void setDescompte(int descompte) {
		this.descompte = descompte;
	}
	// a�adimos producto, retorna true si ha a�adido el producto
	public boolean afegirProducte(Integer idProd) {
		packProducte.add(idProd);
		return true;
	}
	
	// elimina el producto, retorna true si est� ok.
	public boolean esborrarProducte(Integer idProd) {
		packProducte.remove(idProd);
		return true;
	}
	// Imprime los atributos de Pack y el super de ProducteAbstract.
	public void imprimir() { //SETTER
		super.imprimir();
		System.out.println("--------Desdes del pack--------");
		System.out.println("Llista de productes   :" + packProducte);
		System.out.println("Descompte del pack    :" + descompte);
		System.out.println("--------------------------------");
	}
}
