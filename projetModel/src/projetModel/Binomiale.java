/**
 * Binomiale.java						20 nov. 2019
 * IUT info1 2018-2019 TD2, no copyright, no copyleft
 */
package projetModel;

/**
 * TODO commenter les responsabilités de cette classe
 * @author flori
 *
 */
public class Binomiale extends Loi{

	/** nb de simulation de bernouilli */
	private int n;
	/** la probabilité de succés */
	private double p;

	/**
	 * Simule une loi de Bernouilli
	 * @param p la probabilité de succés
	 * @return une simulation de la loi
	 */
	public static boolean loiBernouilli(double p) throws ErreurParametresLoi {
		if (p < 0 || p > 1) {
			throw new ErreurParametresLoi("Bernouilli");
		}
		return Math.random() < p;
	}

	/**
	 * Simule une loi Binomiale
	 * @param n nombre de répétition de l'expérience
	 * @param p probabilité de succés
	 * @return une simulation de la loi
	 */
	public Binomiale(int n, double p, int nbSimulations) throws ErreurParametresLoi {
		if (p < 0 || p > 1 || n < 0) {
			throw new ErreurParametresLoi("Binomiale");
		}
		this.n = n;
		this.p = p;
		this.simulations = new double[nbSimulations];
	}

	/* (non-Javadoc)
	 * @see projetModel.Loi#simuler()
	 */
	@Override
	public double[] simuler() throws ErreurParametresLoi {
		int nbVrai;
		for(int j = 0; j < simulations.length ;j++) {
			//simulation d'une seule loi binoiale grace a Bernouilli
			nbVrai = 0;
			for (int i = 0; i < n; i++) {
				if(loiBernouilli(p)) {
					nbVrai++;
				}
			}
			simulations[j] = nbVrai/p;
		}
		return this.simulations;
	}

	@Override
	public double variance() throws ErreurParametresLoi {
		return n*p*(1-p);
	}

	@Override
	public double esperance() throws ErreurParametresLoi {
		return n*p;
	}



}
