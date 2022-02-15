package persona;
import java.util.ArrayList;


public abstract class PersonaAbstract {
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
	

	public boolean afegirTel(String tel) {
		return telefons.add(tel);
	}
	

	public boolean eliminarTel(String tel) {
		return telefons.remove(tel);
	}
	
	
	@Override
	public String toString() {
		return "PersonaAbstract [idPersona=" + idPersona + ", nom=" + nom + ", dni=" + dni + ", adreca=" + adreca
				+ ", telefons=" + telefons + "]";
	}
	
}


