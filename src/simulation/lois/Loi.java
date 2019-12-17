package simulation.lois;

/*
 * Loi.java                                                                                 20/11/2019
 * Pas de copyright
 */

/**
 * Classe � impl�menter pour chaque loi simul�e
 *
 * @author tommargalejo
 * @version 1.0
 */
public abstract class Loi {
	protected double[] simulations;
	protected int nbSimulations;

	/**
	 * M�thode � d�finir pour chaque loie simul�e
	 * 
	 * @return tableau contenant toutes les simulations effectu�es
	 */
	public abstract double[] simuler();

	/**
	 * Calcule l'esp�rance d'une loi en fonction des ses param�tres
	 * 
	 * @return valeur de l'esp�rance
	 * @t
	 */
	public abstract double esperance();

	/**
	 * Calcule la variance d'une loi en fonction des ses param�tres
	 * 
	 * @return valeur de la variance
	 * @t
	 */
	public abstract double variance();
}
