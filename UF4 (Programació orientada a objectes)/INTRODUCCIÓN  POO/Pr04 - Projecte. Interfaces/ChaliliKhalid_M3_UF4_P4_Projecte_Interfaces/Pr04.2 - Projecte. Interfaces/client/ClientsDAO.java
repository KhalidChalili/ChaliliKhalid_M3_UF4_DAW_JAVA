package client;

import java.util.HashMap;



public class ClientsDAO {
	// Es un tipo de lista desatendida, como una tabla de una bbdd.
	private HashMap<Integer, Client> listaClients = new HashMap<Integer, Client>();
	
	
	public HashMap<Integer, Client> getListaClients() {
		return listaClients;
	}

	public void setListaClients(HashMap<Integer, Client> listaClients) {
		this.listaClients = listaClients;
	}

	// Si la clave no está en el listado retorna false.
	public boolean afegir(Client client) {
		if(listaClients.containsKey(client.getIdPersona())) {
			return false;
			
		} else { // Si no existe el id añade el Objeto en el HashMap (lista)
			listaClients.put(client.getIdPersona(), client);
			return true;			
		}

	}
	
	// Método que busca el objeto pasandole como parámetro el id.
	public Client buscar(int idBuscar) {
		// si existe el cliente el objeto, si no, retorna null
		return listaClients.get(idBuscar);
	}
	
	/* public void imprimirLista() {
		int nClient = 1;
		for (Client client : listaClients.values()) {
			System.out.println("--------------" + String.format("%04d", nClient) + "--------------");
			client.imprimir();
			nClient++;
		}
	} */
	
	// Método que elimina el objeto pasandole el id.
	public Client eliminar(int idEliminar) {
		return listaClients.remove(idEliminar);
	}
	


}
