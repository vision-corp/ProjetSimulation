package simulation.lois;

/*
 * Loi.java                                                                                 20/11/2019
 * Pas de copyright
 */

/**
 * Classe à implémenter pour chaque loi simulée
 *
 * @author tommargalejo
 * @version 1.0
 */
public abstract class Loi {
	protected double[] simulations;
	protected int nbSimulations;

	/**
	 * Méthode à définir pour chaque loie simulée
	 * 
	 * @return tableau contenant toutes les simulations effectuées
	 */
	public abstract double[] simuler();

	/**
	 * Calcule l'espérance d'une loi en fonction des ses paramètres
	 * 
	 * @return valeur de l'espérance
	 * @t
	 */
	public abstract double esperance();

	/**
	 * Calcule la variance d'une loi en fonction des ses paramètres
	 * 
	 * @return valeur de la variance
	 * @t
	 */
	public abstract double variance();
}
