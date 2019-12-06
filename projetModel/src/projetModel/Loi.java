/*
 * Loi.java                                                                                 20/11/2019
 * Pas de copyright
 */

package projetModel;

/**
 * Classe � impl�menter pour chaque loi simul�e
 *
 * @author tommargalejo
 * @version 1.0
 */
public abstract class Loi{

    /** tableau de resultat de la simulation */
    public double[] simulations;
    /** nombre de simulations */
    protected int nbSimulations;

    /** esperence de la loi */
    protected double esperence;

    /** ecar-type */
    protected double ecartType;


    /**
     * M�thode � d�finir pour chaque loie simul�e
     * @return tableau contenant toutes les simulations effectu�es
     * @throws ErreurParametresLoi
     */
    public abstract void simuler() throws ErreurParametresLoi;

    /**
     * Calcule la variance d'une loi en fonction des ses paramètres
     * @return valeur de la variance
     * @throws ErreurParametresLoi
     */
    public abstract double variance() throws ErreurParametresLoi;

    /**
     * Calcule l'espérance d'une loi en fonction des ses paramètres
     * @return valeur de l'espérance
     * @throws ErreurParametresLoi
     */
    public abstract double esperance() throws ErreurParametresLoi;


}