
/*
 * Normale.java                07/11/19
 * Pas de copyright ou de copyleft
 */
package simulation.lois;

import static java.lang.Math.*;

/*
    Simulation de la loi normale :
    Si U1 et U2 sont deux variable de al�atoire ind�pendante de la loi uniforme sur l'intervale [0,1]
    alors la variable al�atoire Y = sqrt(-2ln(U1))*cos(2*PI*U2) suit une loi normale centr�e et r�duite
    T = ecartType*Y + esperance
 */

/**
 * Classe mod�lisant une loi normale Choix des indicateurs : esp�rance et �cart
 * type
 */
public class Normale extends Loi {

	/** Esp�rance de la loi normale */
	private double esperence;

	/** Ecart type de la loi normale */
	private double ecartType;

	/**
	 * Constructeur de la loi normale
	 * 
	 * @param newEsperence esp�rance
	 * @param newEcartType
	 */
	public Normale(double newEsperence, double newEcartType,
			int newNbSimulation) {
		this.ecartType = newEcartType;
		this.esperence = newEsperence;
		this.nbSimulations = newNbSimulation;
		this.simulations = new double[nbSimulations];
	}

	/**
	 * Simule une loi normale avec son esp�rance et son �cart-type
	 * 
	 * @return les simulations de la loi @
	 */
	@Override
	public double[] simuler() {

		double variable1, // Premiere variable a simuler
				variable2, // Deuxi�me variable a simuler
				normaleCentree;

		for (int i = 0; i < this.nbSimulations; i++) {

			variable1 = random(); // G�n�ration de la premiere valeur dans [0,1]
			variable2 = random(); // G�n�ration de la deuxi�me valeur dans [0,1]

			// Calcul de la loi normale centr�e
			normaleCentree = sqrt(-2 * log(variable1))
					* cos(2 * PI * variable2);

			// Calcul de la loi selon les paramettre choisis
			simulations[i] = ecartType * normaleCentree + esperence;
		}
		return simulations;
	}

	/**
	 * @return l'esperance
	 */
	public double esperance() {
		return esperence;
	}

	/**
	 * @return la variance
	 */
	public double variance() {
		return ecartType * ecartType;
	}
}