package producte;
import java.util.HashMap;

// Clase que tiene el objetivo de almacenar, eliminar, reemplazar los objetos.

public class ProductesDAO {
	// Es un tipo de lista desatendida, como una tabla de una bbdd.
	private HashMap<Integer, ProducteAbstract> lista = new HashMap<Integer, ProducteAbstract>();

	// Si la clave no está en el listado retorna false.
	public boolean afegir(ProducteAbstract prod) {
		if(lista.containsKey(prod.getIdProducte())) {
			return false;
			
		} else { // Si no existe el id añade el Objeto en el HashMap (lista)
			lista.put(prod.getIdProducte(), prod);
			return true;			
		}

	}
	// Método que busca el objeto pasandole como parámetro el id.
	public ProducteAbstract buscar(int idBuscar) {
		// si existe retorna el objeto, si no, retorna null
		return lista.get(idBuscar);
	}
	
	// Método que reemplaza las características del objeto.
	public void modificar(ProducteAbstract prod) {
		lista.replace(prod.getIdProducte(), prod);
		
	}
	
	// Método que elimina el objeto pasandole el id.
	public ProducteAbstract eliminar(int idEliminar) {
		return lista.remove(idEliminar);
	}
	
	// Método que imprime todos los objetos
	public void imprimirLista() {
		/* OTRA FORMA DE HACER
		for(Map.Entry<Integer, Producte > casilla : lista.entrySet()) {
			System.out.println("--------------------------------");
			casilla.getValue().imprimir();
			System.out.println("--------------------------------");
		}
		*/
		// Esta es la forma más simple y fácil
		int nProducte = 1;
		for (ProducteAbstract prod : lista.values()) {
			System.out.println("--------------" + String.format("%04d", nProducte) + "--------------");
			prod.imprimir();
			nProducte++;
		}
	}
	
	
}
