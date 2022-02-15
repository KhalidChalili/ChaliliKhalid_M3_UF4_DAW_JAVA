package client;

import persona.Adreca;
import persona.PersonaAbstract;

public class Client extends PersonaAbstract{
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

	@Override
	public String toString() {
		return super.toString() + "\nClient [enviarPublicitat=" + enviarPublicitat + "]";
	}
	
}
