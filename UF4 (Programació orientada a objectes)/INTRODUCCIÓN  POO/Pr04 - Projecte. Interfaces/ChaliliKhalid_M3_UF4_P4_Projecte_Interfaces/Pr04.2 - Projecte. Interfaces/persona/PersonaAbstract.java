package persona;
import java.util.ArrayList;
import interfaces.Imprimible;


public abstract class PersonaAbstract implements Imprimible {
	private int idPersona;
	private String nom;
	private String dni;
	private Adreca adreca;
	private ArrayList<String> telefons = new ArrayList<String>();
	
	public PersonaAbstract() {
		this(0, "", "", null);

	}	
	
	public PersonaAbstract(int idPersona, String nom, String dni, Adreca adreca) {
		this.idPersona = idPersona;
		this.nom = nom;
		this.dni = dni;
		this.adreca = adreca;
	}
	
	//getters & setters
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Adreca getAdreca() {
		return adreca;
	}
	public void setAdreca(Adreca adreca) {
		this.adreca = adreca;
	}
	public ArrayList<String> getTelefons() {
		return telefons;
	}
	public void setTelefons(ArrayList<String> telefons) {
		this.telefons = telefons;
	}
	
	
	public void imprimir() { //SETTER
		System.out.println("---------Dades generals---------");
		System.out.println("Id de de persona      :" + idPersona);
		System.out.println("Nom de la persona     :" + nom);
		System.out.println("Document d'identitat  :" + dni);
		System.out.println("-------------Adreça-------------");
		adreca.imprimirAdreca();
		System.out.println("--------------------------------");
		System.out.println("telèfons              :" + telefons);
		System.out.println("--------------------------------");
	}

	public boolean afegirTel(String tel) {
		return telefons.add(tel);
	}
	
	public boolean eliminarTel(String tel) {
		return telefons.remove(tel);
	}
}


