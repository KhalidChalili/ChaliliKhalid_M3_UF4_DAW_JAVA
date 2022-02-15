package persona;


public class Adreca {
	private String poblacio, provincia, cp, domicili;

	// constructores
	public Adreca() {
		this("", "", "", "");
	}

	public Adreca(String poblacio, String provincia, String cp, String domicili) {
		this.poblacio = poblacio;
		this.provincia = provincia;
		this.cp = cp;
		this.domicili = domicili;
	}

	// getters & setters
	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getDomicili() {
		return domicili;
	}

	public void setDomicili(String domicili) {
		this.domicili = domicili;
	}

	public void imprimirAdreca() {
		System.out.println("    Població    :" + poblacio);
		System.out.println("    Provincia   :" + provincia);
		System.out.println("    Códi postal :" + cp);
		System.out.println("    Domicili    :" + domicili);
	}
}
