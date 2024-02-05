import mates.MisFuncionesMatematicas;
import mates.MisFuncionesMatematicasException;

public class Fraccion {

	private int numerador;
	private int denominador;

	public Fraccion(int numerador, int denominador) throws FraccionException {
		setNumerador(numerador);
		setDenominador(denominador);
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) throws FraccionException {
		if (denominador <= 0) {
			throw new FraccionException("El denominador nunca puede ser cero");
		}
		this.denominador = denominador;
	}

	@Override
	public String toString() {
		return "Fraccion [numerador=" + numerador + ", denominador=" + denominador + "]";
	}

	public boolean equals(Fraccion fraccion) {
		if (this.numerador * this.denominador == fraccion.numerador * fraccion.denominador) {
			return true;
		}
		return false;
	}

	public Fraccion sumar(Fraccion fraccion) throws MisFuncionesMatematicasException, FraccionException {

		Fraccion fraccionSumada;

		if (this.denominador == fraccion.denominador) {
			return fraccionSumada = new Fraccion(this.numerador + fraccion.numerador, this.denominador);
		} else {
			return fraccionSumada = new Fraccion(numerador + fraccion.numerador,
					MisFuncionesMatematicas.mcm(denominador, fraccion.denominador));
		}
	}

	public Fraccion restar(Fraccion fraccion) throws MisFuncionesMatematicasException, FraccionException {

		Fraccion fraccionRestada;

		if (this.denominador == fraccion.denominador) {
			return fraccionRestada = new Fraccion(this.numerador - fraccion.numerador, this.denominador);
		} else {
			return fraccionRestada = new Fraccion(numerador - fraccion.numerador,
					MisFuncionesMatematicas.mcm(denominador, fraccion.denominador));
		}
	}

	public Fraccion multiplicar(Fraccion fraccion) throws FraccionException {

		Fraccion fraccionSumada;

		return fraccionSumada = new Fraccion(this.numerador * fraccion.numerador,
				this.denominador * fraccion.denominador);
	}

	public Fraccion dividir(Fraccion fraccion) throws FraccionException {

		Fraccion fraccionSumada;

		return fraccionSumada = new Fraccion(this.numerador * fraccion.denominador,
				fraccion.numerador * this.denominador);
	}

	public void simplificar() throws MisFuncionesMatematicasException {

		int divisorComun;
		
		divisorComun = MisFuncionesMatematicas.mcd(this.numerador, this.denominador);
		numerador /= divisorComun;
		denominador /= divisorComun;
	}
}
