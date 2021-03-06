package proveidor;
import java.util.HashMap;


public class ProveidorsDAO {
	// Es un tipo de lista desatendida, como una tabla de una bbdd.
	private HashMap<Integer, Proveidor> listaProveidors = new HashMap<Integer, Proveidor>();
	//getters and setters	
	public HashMap<Integer, Proveidor> getListaProveidors() {
		return listaProveidors;
	}

	public void setListaProveidors(HashMap<Integer, Proveidor> listaProveidors) {
		this.listaProveidors = listaProveidors;
	}

	// Si la clave no est? en el listado retorna false.
	public boolean afegir(Proveidor proveidor) {
		if(listaProveidors.containsKey(proveidor.getIdPersona())) {
			return false;
			
		} else { // Si no existe el id a?ade el Objeto en el HashMap (lista)
			listaProveidors.put(proveidor.getIdPersona(), proveidor);
			return true;			
		}
	}
	
	// M?todo que busca el objeto pasandole como par?metro el id.
	public Proveidor buscar(int idBuscar) {
		// si existe el cliente el objeto, si no, retorna null
		return listaProveidors.get(idBuscar);
	}
	
	// M?todo que elimina el objeto pasandole el id.
	public Proveidor eliminar(int idEliminar) {
		return listaProveidors.remove(idEliminar);
	}
	
}