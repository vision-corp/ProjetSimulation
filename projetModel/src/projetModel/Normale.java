/**
 * Normale.java						20 nov. 2019
 * IUT info1 2018-2019 TD2, no copyright, no copyleft
 */
package projetModel;

/**
 * TODO commenter les responsabilités de cette classe
 * @author flori
 *
 */
public class Normale extends Loi{

    /**
     * Simule une loi Normale
     * @param esperance
     * @param ecartTtype
     * @return une simulation de la loi
     */
    public static double loiNormale(double esperance, double ecartTtype) {
        return ecartTtype; //STUB
        
    }

    /* (non-Javadoc)
     * @see projetModel.Loi#simuler()
     */
    @Override
    public double[] simuler() throws ErreurParametresLoi {
        // TODO Auto-generated method stub
        return null;
    }

}
