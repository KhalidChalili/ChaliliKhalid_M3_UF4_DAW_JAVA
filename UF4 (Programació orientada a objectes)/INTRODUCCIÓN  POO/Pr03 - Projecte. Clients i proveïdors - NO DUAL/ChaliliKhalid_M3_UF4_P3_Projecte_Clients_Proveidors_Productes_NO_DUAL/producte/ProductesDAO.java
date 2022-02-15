package producte;
import java.util.HashMap;

// Clase que tiene el objetivo de almacenar, eliminar, reemplazar los objetos.

public class ProductesDAO {
	// Es un tipo de lista desatendida, como una tabla de una bbdd.
	private HashMap<Integer, ProducteAbstract> lista = new HashMap<Integer, ProducteAbstract>();

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
	
	// M�todo que imprime todos los objetos
	public void imprimirLista() {
		/* OTRA FORMA DE HACER
		for(Map.Entry<Integer, Producte > casilla : lista.entrySet()) {
			System.out.println("--------------------------------");
			casilla.getValue().imprimir();
			System.out.println("--------------------------------");
		}
		*/
		// Esta es la forma m�s simple y f�cil
		int nProducte = 1;
		for (ProducteAbstract prod : lista.values()) {
			System.out.println("--------------" + String.format("%04d", nProducte) + "--------------");
			prod.imprimir();
			nProducte++;
		}
	}
	
	
}
