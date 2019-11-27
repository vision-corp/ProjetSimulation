/**
 * Uniforme.java						20 nov. 2019
 * IUT info1 2018-2019 TD2, no copyright, no copyleft
 */
package projetModel;

/**
 * Simule une loi uniforme
 *
 * @author tommargalejo
 * @version 1.0
 */
public class Uniforme extends Loi{

    /** Borne inférieur */
    private int a;
    /** Borne supérieur */
    private int b;

    /**
     * commenter l'etat initial atteint
     * @param a
     * @param b
     * @param nbSimulations
     * @throws ErreurParametresLoi
     */
    public Uniforme(int a, int b, int nbSimulations) throws ErreurParametresLoi {
        if (b < a || nbSimulations < 1) {
            throw new ErreurParametresLoi("UniformeDiscrete");
        }
        this.a = a;
        this.b = b;
        this.nbSimulations = nbSimulations;
        this.simulations = new double[nbSimulations];
    }

    @Override
    public double[] simuler() throws ErreurParametresLoi {
        for(int i = 0; i < this.nbSimulations; i++) {
            this.simulations[i] = Math.round((a + (b - a) * Math.random()));
        }
        
        this.esperence = (double)(a + b) / 2;
        
        this.ecartType = Math.sqrt((double)((b - a) * (b - a)) / 12);
        
        return this.simulations;
    }

}
