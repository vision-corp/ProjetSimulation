/*
 * Loi.java                                                                                 20/11/2019
 * Pas de copyright
 */

package projetModel;

/**
 * Classe à implémenter pour chaque loi simulée
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
     * Méthode à définir pour chaque loie simulée
     * @return tableau contenant toutes les simulations effectuées
     * @throws ErreurParametresLoi 
     */
    public abstract double[] simuler() throws ErreurParametresLoi;

}