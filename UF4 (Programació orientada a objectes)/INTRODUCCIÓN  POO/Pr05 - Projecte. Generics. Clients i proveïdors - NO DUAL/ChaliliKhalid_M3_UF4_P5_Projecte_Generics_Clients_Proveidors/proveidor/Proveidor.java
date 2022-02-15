package proveidor;
import persona.Adreca;
import persona.PersonaAbstract;

public class Proveidor extends PersonaAbstract {
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


	@Override
	public String toString() {
		return  super.toString() +  "Proveidor [descompteProntoPago=" + descompteProntoPago + "]";
	}
	
}
