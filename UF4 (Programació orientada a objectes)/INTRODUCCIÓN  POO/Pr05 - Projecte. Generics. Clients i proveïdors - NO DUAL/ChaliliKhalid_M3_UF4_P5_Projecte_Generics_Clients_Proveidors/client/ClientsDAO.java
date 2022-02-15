package client;

import java.util.HashMap;



public class ClientsDAO {
	// Es un tipo de lista desatendida, como una tabla de una bbdd.
	private HashMap<Integer, Client> listaClients = new HashMap<Integer, Client>();
	
	//getters and setters
	public HashMap<Integer, Client> getListaClients() {
		return listaClients;
	}

	public void setListaClients(HashMap<Integer, Client> listaClients) {
		this.listaClients = listaClients;
	}

	// Si la clave no est� en el listado retorna false.
	public boolean afegir(Client client) {
		if(listaClients.containsKey(client.getIdPersona())) {
			return false;
			
		} else { // Si no existe el id a�ade el Objeto en el HashMap (lista)
			listaClients.put(client.getIdPersona(), client);
			return true;			
		}

	}
	
	// M�todo que busca el objeto pasandole como par�metro el id.
	public Client buscar(int idBuscar) {
		// si existe el cliente el objeto, si no, retorna null
		return listaClients.get(idBuscar);
	}
	
	// M�todo que elimina el objeto pasandole el id.
	public Client eliminar(int idEliminar) {
		return listaClients.remove(idEliminar);
	}

}
