package producte;
import java.util.HashMap;

// Clase que tiene el objetivo de almacenar, eliminar, reemplazar los objetos.

public class ProductesDAO {
	// Es un tipo de lista desatendida, como una tabla de una bbdd.
	private HashMap<Integer, ProducteAbstract> lista = new HashMap<Integer, ProducteAbstract>();

	//getters and setters
	public HashMap<Integer, ProducteAbstract> getLista() {
		return lista;
	}
	public void setLista(HashMap<Integer, ProducteAbstract> lista) {
		this.lista = lista;
	}
	// Si la clave no est� en el listado retorna false.
	public boolean afegir(ProducteAbstract prod) {
		if(lista.containsKey(prod.getIdProducte())) {
			return false;
			
		} else { // Si no existe el id a�ade el Objeto en el HashMap (lista)
			lista.put(prod.getIdProducte(), prod);
			return true;			
		}

	}
	// M�todo que busca el objeto pasandole como par�metro el id.
	public ProducteAbstract buscar(int idBuscar) {
		// si existe retorna el objeto, si no, retorna null
		return lista.get(idBuscar);
	}
	
	// M�todo que reemplaza las caracter�sticas del objeto.
	public void modificar(ProducteAbstract prod) {
		lista.replace(prod.getIdProducte(), prod);
		
	}
	
	// M�todo que elimina el objeto pasandole el id.
	public ProducteAbstract eliminar(int idEliminar) {
		return lista.remove(idEliminar);
	}
	
}
