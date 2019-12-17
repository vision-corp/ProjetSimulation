
/*
 * Normale.java                07/11/19
 * Pas de copyright ou de copyleft
 */
package simulation.lois;

import static java.lang.Math.*;

/*
    Simulation de la loi normale :
    Si U1 et U2 sont deux variable de aléatoire indépendante de la loi uniforme sur l'intervale [0,1]
    alors la variable aléatoire Y = sqrt(-2ln(U1))*cos(2*PI*U2) suit une loi normale centrée et réduite
    T = ecartType*Y + esperance
 */

/**
 * Classe modélisant une loi normale Choix des indicateurs : espérance et écart
 * type
 */
public class Normale extends Loi {

	/** Espérance de la loi normale */
	private double esperence;

	/** Ecart type de la loi normale */
	private double ecartType;

	/**
	 * Constructeur de la loi normale
	 * 
	 * @param newEsperence espérance
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
	 * Simule une loi normale avec son espérance et son écart-type
	 * 
	 * @return les simulations de la loi @
	 */
	@Override
	public double[] simuler() {

		double variable1, // Premiere variable a simuler
				variable2, // Deuxième variable a simuler
				normaleCentree;

		for (int i = 0; i < this.nbSimulations; i++) {

			variable1 = random(); // Génération de la premiere valeur dans [0,1]
			variable2 = random(); // Génération de la deuxième valeur dans [0,1]

			// Calcul de la loi normale centrée
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