import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//import sun.awt.image.PNGImageDecoder.Chromaticities;

//la clase tiene x metodos
public class Persona {
	private String dni, nom, cognom1, cognom2, eMail;
	private LocalDate naixament;
	private int tel;
	// se comporta como una variable global pero en diferentes metodos
	static private int numPersonas = 0;

	// Constructor, es decir, construimos la persona
	// Los atributos de una persona nueva no tendrá nada en este último caso.
	public Persona() {
		this("", "", "", 0);
	}
	
	public Persona(String dni) {
		this(dni, "", "", 0);
	}

	public Persona(String dni, String nom) {
		this(dni, nom, "", 0);
	}

	/*
	 * en los anteriores constructores llaman a esta, así reutilizamos código, 
	 * además aquí sumamos la nueva persona.
	 */
	public Persona(String dni, String nom, String eMail, int tel) {
		this.dni = dni;
		this.nom = nom;
		this.eMail = eMail;
		this.tel = tel;
		numPersonas++;
	}

	// metodos set y get
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public LocalDate getNaixament() {
		return naixament;
	}

	public void setNaixament(LocalDate naixament) {
		this.naixament = naixament;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	// metodos
	// retorna numeros
	public static int getNumPersonas() { //gett
		return numPersonas;
	}
	public static void setNumPersonas(int numPersonas) { //set
		Persona.numPersonas = numPersonas;
	}
	
	//retorna la edad en años, 
	public long getEdad() {
		LocalDate dataActual = LocalDate.now();
		long diferencia = ChronoUnit.YEARS.between(naixament, dataActual);
		return diferencia;
		

	}

	// imprimir por pantalla
	public void imprimir() { //SETTER

		 System.out.println("Nom                   : " + nom);
		 System.out.println("Primer cognom         : " + cognom1);
		 System.out.println("Segon cognom          : " + cognom2);
		 System.out.println("DNI                   : " + dni);
		 System.out.println("Correu electrònic     : " + eMail);
		 System.out.println("Telèfon mòbil         : " + tel);
		 if(naixament != null) {
			 /*
			  * llamamos al getEdad para mostrar los años de esa persona
			  * convertimos la fecha en toString
			  */
			 System.out.println("Data de naixament : " + naixament.toString());
			 System.out.println("L'edat actual és  : " + getEdad() + "anys");
		 }
		 
	}
	/*
	 * Comparamos la diferencia entre dos personas. y la retorna
	 * Aquí podemos mejorarlo poniendo un if para ver cuál es el menor y así 
	 * no importará cuál es el pequeño...
	 */
	public static long diferenciaEdad(Persona p1, Persona p2) {
		
		long betweenEdad = ChronoUnit.YEARS.between(p1.getNaixament(), p2.getNaixament());
		return betweenEdad;
	}
	
	//si dni y nomre es falso entonces no podrá añadir esa persona.
	public boolean validar() { //GETTER
		if ((dni == null || dni.equals("")) && (nom == null || dni.equals(""))) {
			return false;
		} else {
			return true;
		}
	}
	
		

}
