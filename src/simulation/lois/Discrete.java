/*
 * Uniforme.java                                                                                 20/11/2019
 * Pas de copyright
 */

package simulation.lois;

/**
 * Simule une loi uniforme Contient un tableau de probas qui est assosciÃ© a un
 * tableau de valeur par son index
 *
 * @author J-Charles Luans
 * @version 1.0
 */
public class Discrete extends Loi {

	/** Tableau des valeurs et tableaux des probas */
	double[] valeur, proba;

	/**
	 * Construit une loi discrete en suivant en assossiant chaque case du table
	 * au valeur a une proba du tableau proba.
	 * 
	 * @param newValeurs      tableau de valeurs
	 * @param newProba        tableau de proba associÃ© au tableau de valeur
	 * @param newNbSimulation nombre de fois ou on simule la classe
	 */
	public Discrete(double[] newValeurs, double[] newProba,
			int newNbSimulation) {
		this.valeur = newValeurs;
		this.proba = newProba;
		this.nbSimulations = newNbSimulation;
		this.simulations = new double[nbSimulations];
	}

	@Override
	public double[] simuler() {

		boolean estFini; // Indique si une simulation est terminer

		double tirage, // Variable aléatire
				sommeProba; // Somme des probabilité

		for (int i = 0; i < this.nbSimulations; i++) {

			tirage = Math.random(); // Tirage aléatoire

			sommeProba = 0;

			estFini = false;

			for (int j = 0; j < proba.length && !estFini; j++) {

				sommeProba += proba[j]; // Somme des probabilité a comparer

				if (tirage <= sommeProba) {
					this.simulations[i] = this.valeur[j];
					estFini = true;
				}
			}

		}
		return this.simulations;
	}

	@Override
	public double variance() {

		double variance, // Variance a retourner
				esperance; // Esperance de la simulation

		variance = 0.0;
		esperance = this.esperance();

		for (int i = 0; i < proba.length; i++) {
			variance += proba[i] * Math.pow(valeur[i] - esperance, 2);
		}

		return variance;

	}

	@Override
	public double esperance() {

		double esperance; // Esperance a retourner

		esperance = 0;

		// Somme des valeurs par les proba qui leurs sont associé
		for (int i = 0; i < valeur.length; i++) {
			esperance += valeur[i] * proba[i];
		}

		return esperance;
	}
}