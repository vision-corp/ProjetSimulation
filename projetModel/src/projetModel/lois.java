/**
 * lois.java						13 nov. 2019
 * IUT info1 2018-2019 TD2, no copyright, no copyleft
 */
package projetModel;

/**
 * TODO commenter les responsabilités de cette classe
 * @author Florian Hyver
 *      Tom Margalejo
 *      Alban Olive
 *      Jean-Charles Luans
 */
public class lois {

    /**
     * Simule une loi Normale
     * @param esperance
     * @param ecartTtype
     * @return une simulation de la loi
     */
    public static double loiNormale(double esperance, double ecartTtype) {
        return ecartTtype; //STUB
        
    }
    
    /**
     * Simule une loi de Bernouilli
     * @param p la probabilité de succés
     * @return une simulation de la loi
     */
    public static boolean loiBernouilli(double p) {
        return Math.random() < p;
    }
    
    /**
     * Simule une loi Binomiale
     * @param n nombre de répétition de l'expérience
     * @param p probabilité de succés
     * @return une simulation de la loi
     */
    public static double loiBinomiale(int n, double p) {
        int nbVrai = 0;
        for (int i = 0; i < n; i++) {
            if(loiBernouilli(p)) {
                nbVrai++;
            }
        }
        return nbVrai/p;        
    }
    
    /**
     * Simule une loi Exponantielle
     * @param lambda
     * @return une simulation de la loi
     */
    public static double Exponentielle(double lambda) {
        return lambda; //STUB
        
    }
    
    /**
     * Simule une loi Uniforme
     * @param a borne inferieur de l'intervalle
     * @param b borne supérieur de l'intervalle
     * @return  une simulation de la loi
     */
    public static double loiUniforme(int a, int b) {
        return b; //STUB
        
    }
    
    /**
     * Simule une loi Dicrete
     * @param valeur , uniforme sur l'ensemble de ces valeurs
     * @return  une simulation de la loi
     */
    public static int loiDiscrete(int[] valeur) {
        return 0; // STUB
        
    }
}
