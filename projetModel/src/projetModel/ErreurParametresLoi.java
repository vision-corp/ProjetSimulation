/*
 * ErreurParametresLoi.java                                                                                 20/11/2019
 * Pas de copyright
 */
package projetModel;
/**
 * Erreur lev�e lorsque des param�tres incorrrectes sont plac�s
 *
 * @author tommargalejo
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ErreurParametresLoi extends Exception {

    /**
     * classe d'erreur
     * @param loi
     */
    public ErreurParametresLoi(String loi) {
        super("Impossible de simuler une loi " + loi + "avec ces param�tres");
    }
}