package proveidor;
import java.util.HashMap;


public class ProveidorsDAO {
	// Es un tipo de lista desatendida, como una tabla de una bbdd.
	private HashMap<Integer, Proveidor> listaProveidors = new HashMap<Integer, Proveidor>();
	// Si la clave no está en el listado retorna false.
	public boolean afegir(Proveidor proveidor) {
		if(listaProveidors.containsKey(proveidor.getIdPersona())) {
			return false;
			
		} else { // Si no existe el id añade el Objeto en el HashMap (lista)
			listaProveidors.put(proveidor.getIdPersona(), proveidor);
			return true;			
		}
	}
	
	// Método que busca el objeto pasandole como parámetro el id.
	public Proveidor buscar(int idBuscar) {
		// si existe el cliente el objeto, si no, retorna null
		return listaProveidors.get(idBuscar);
	}
	
	// Método que elimina el objeto pasandole el id.
	public Proveidor eliminar(int idEliminar) {
		return listaProveidors.remove(idEliminar);
	}
	
	public void imprimirLista() {
		int nProveidor = 1;
		for (Proveidor proveidor : listaProveidors.values()) {
			System.out.println("--------------" + String.format("%04d", nProveidor) + "--------------");
			proveidor.imprimir();
			nProveidor++;
		}
	}
	
}