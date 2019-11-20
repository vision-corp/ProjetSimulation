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
    private double[] simulations;
    /** nombre de simulations */
    private int nbSimulations;
    
    /** esperence de la loi */
    private double esperence;
    
    /** ecar-type */
    private double ecartType;


    /**
     * M�thode � d�finir pour chaque loie simul�e
     * @return tableau contenant toutes les simulations effectu�es
     * @throws ErreurParametresLoi 
     */
    public abstract double[] simuler() throws ErreurParametresLoi;

}