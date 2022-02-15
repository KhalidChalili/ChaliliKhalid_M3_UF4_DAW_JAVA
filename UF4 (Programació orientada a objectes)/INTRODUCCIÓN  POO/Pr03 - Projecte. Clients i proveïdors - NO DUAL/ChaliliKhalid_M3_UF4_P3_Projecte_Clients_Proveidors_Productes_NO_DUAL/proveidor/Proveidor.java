package proveidor;
import persona.Adreca;
import persona.Persona;

public class Proveidor extends Persona {
	double descompteProntoPago;
	
	// constructores
	
	public Proveidor() {
		super();
	}
	public Proveidor(int idPersona, String nom, String dni, Adreca adreca,
			double descompteProntoPago) {
		super(idPersona, nom, dni, adreca);
		this.descompteProntoPago = descompteProntoPago;
	}

	// getters & setters
	public double isDescompteProntoPago() {
		return descompteProntoPago;
	}
	public void setDescompteProntoPago(double descompteProntoPago) {
		this.descompteProntoPago = descompteProntoPago;
	}
	
	public void imprimir() { //SETTER
		super.imprimir();
		System.out.println("-----Desdes del proveïdor-----");
		System.out.println("Descompte pronto pago :" + descompteProntoPago);
		System.out.println("--------------------------------");
	}
	
}
