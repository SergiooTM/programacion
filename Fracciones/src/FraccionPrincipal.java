import java.util.Scanner;

import mates.MisFuncionesMatematicasException;

public class FraccionPrincipal {

	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numerador, denominador, opcion;
		Fraccion fraccion1 = null;
		Fraccion fraccion2 = null;
		boolean error = true;

		do {
			try {
				System.out.println("Escribe el numerador");
				numerador = Integer.parseInt(teclado.nextLine());
				System.out.println("Escribe el denominador");
				denominador = Integer.parseInt(teclado.nextLine());

				fraccion1 = new Fraccion(numerador, denominador);

				System.out.println("Escribe el numerador");
				numerador = Integer.parseInt(teclado.nextLine());
				System.out.println("Escribe el denominador");
				denominador = Integer.parseInt(teclado.nextLine());

				fraccion2 = new Fraccion(numerador, denominador);
				error = false;
			} catch (FraccionException e) {
				System.out.println(e.getMessage());
			}
		} while (error);

		do {
			System.out.println("Selecciiona una opción");
			opcion = Integer.parseInt(teclado.nextLine());

			menu(fraccion1, fraccion2, opcion);
		} while (opcion != 7);

	}

	public static void menu(Fraccion fraccion1, Fraccion fraccion2, int opcion) {

		boolean error = true;

		System.out.println(
				"---- \n1.Equals \n2.Sumar \n3.Restar \n4.Multiplicar \n5.Dividir \n6.Simplificar \n7.Salir \n----");

		try {
			switch (opcion) {
			case 1:
				if (fraccion1.equals(fraccion2)) {
					System.out.println("Son iguales");
				} else {
					System.out.println("Son diferentes");
				}
				error = false;
				break;
			case 2:
				fraccion1.sumar(fraccion2);
				
				error = false;
				break;
			case 3:
				fraccion1.restar(fraccion2);
				error = false;
				break;
			case 4:
				fraccion1.multiplicar(fraccion2);
				error = false;
				break;
			case 5:
				fraccion1.dividir(fraccion2);
				error = false;
				break;
			case 6:
				fraccion1.simplificar();
				error = false;
				break;
			}
		} catch (FraccionException e) {
			System.out.println(e.getMessage());
		} catch (MisFuncionesMatematicasException e) {
			System.out.println(e.getMessage());
		}
	}
}
