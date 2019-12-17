package simulation.lois;
/*
 * Uniforme.java                                                                                 20/11/2019
 * Pas de copyright
 */

/**
 * Simule une loi uniforme
 *
 * @author tommargalejo
 * @version 1.0
 */
public class UniformeDiscrete extends Loi {
	private double[] valeurs;

	/**
	 * Initialisaiton d'une nouvelle loi uniforme discrete
	 * 
	 * @param valeurs       liste des valeurs possibles uniformément réparties
	 * @param nbSimulations nombre de simulations à effectuer @
	 */
	public UniformeDiscrete(double[] valeurs, int nbSimulations) {
		this.valeurs = valeurs;
		this.nbSimulations = nbSimulations;
		this.simulations = new double[nbSimulations];
	}

	/**
	 * Simule n fois une loi uniforme discrete
	 * 
	 * @return résultats des différentes simulation @
	 */
	@Override
	public double[] simuler() {

		for (int i = 0; i < this.nbSimulations; i++) {
			this.simulations[i] = this.valeurs[arrondiInf(
					Math.random() * valeurs.length)];
		}

		return this.simulations;
	}

	/**
	 *
	 * @return @
	 */
	@Override
	public double esperance() {
		return sommeTab(this.valeurs) * (1.0 / this.valeurs.length);
	}

	@Override
	public double variance() {
		return ((1.0 / this.valeurs.length) * sommeCar(this.valeurs))
				- (((1.0 / this.valeurs.length) * sommeTab(this.valeurs))
						* ((1.0 / this.valeurs.length)
								* sommeTab(this.valeurs)));
	}

	private double sommeTab(double[] tab) {
		double somme = 0;

		for (int i = 0; i < tab.length; i++) {
			somme += tab[i];
		}

		return somme;
	}

	private double sommeCar(double[] tab) {
		double somme = 0;

		for (int i = 0; i < tab.length; i++) {
			somme += tab[i] * tab[i];
		}

		return somme;
	}

	public static int arrondiInf(double val) {
		if (Math.round(val) - val < 0) {
			return (int) Math.round(val);
		}
		return (int) Math.round(val) - 1;
	}

	public static int arrondiSup(double val) {
		if (Math.round(val) - val < 0) {
			return (int) Math.round(val) + 1;
		}
		return (int) Math.round(val);
	}
}