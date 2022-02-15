package client;

import persona.Adreca;
import persona.Persona;

public class Client extends Persona{
	private boolean enviarPublicitat;
	
	public Client() {
		super();
	}
	// constructores
	public Client(int idPersona, String nom, String dni, Adreca adreca,
			boolean enviarPublicitat) {
		super(idPersona, nom, dni, adreca);
		this.setEnviarPublicitat(enviarPublicitat);
	}

	// getters & setters
	public boolean isEnviarPublicitat() {
		return enviarPublicitat;
	}
	public void setEnviarPublicitat(boolean enviarPublicitat) {
		this.enviarPublicitat = enviarPublicitat;
	}
	
	public void imprimir() { //SETTER
		super.imprimir();
		System.out.println("-------Desdes del client-------");
		System.out.println("Enviar publicitat     :" + enviarPublicitat);
		System.out.println("--------------------------------");
	}
	
	
}
