/**
 * Binomiale.java						20 nov. 2019
 * IUT info1 2018-2019 TD2, no copyright, no copyleft
 */
package simulation.lois;

/**
 * Simule une loi binomiale
 * 
 * @author florian hyver
 *
 */
public class Binomiale extends Loi {

	/** nb de simulation de bernouilli */
	private int n;
	/** la probabilité de succés */
	private double p;

	/**
	 * Simule une loi de Bernouilli
	 * 
	 * @param p la probabilité de succés
	 * @return une simulation de la loi
	 */
	public static boolean loiBernouilli(double p) {
		return Math.random() < p;
	}

	/**
	 * Simule une loi Binomiale
	 * 
	 * @param n nombre de répétition de l'expérience
	 * @param p probabilité de succés
	 * @return une simulation de la loi
	 */
	public Binomiale(int n, double p, int nbSimulations) {
		this.n = n;
		this.p = p;
		this.simulations = new double[nbSimulations];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projetModel.Loi#simuler()
	 */
	@Override
	public double[] simuler() {
		int nbVrai;
		for (int j = 0; j < simulations.length; j++) {
			// simulation d'une seule loi binoiale grace a Bernouilli
			nbVrai = 0;
			for (int i = 0; i < n; i++) {
				if (loiBernouilli(p)) {
					nbVrai++;
				}
			}
			simulations[j] = nbVrai;
		}
		return simulations;
	}

	@Override
	public double variance() {
		return n * p * (1.0 - p);
	}

	@Override
	public double esperance() {
		return n * p;
	}

	public int Cnk(int n, int k) {

		int C[][] = new int[n + 1][k + 1];
		int i, j;

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0 || j == i) {
					C[i][j] = 1;
				} else {
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
				}
			}
		}

		return C[n][k];
	}

	public double proba(int k) {
		return Cnk(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
	}

}
