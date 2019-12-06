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

    /* (non-Javadoc)
     * @see projetModel.Loi#simuler()
     */
    @Override
    public double[] simuler() throws ErreurParametresLoi {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public double variance() throws ErreurParametresLoi {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double esperance() throws ErreurParametresLoi {
		// TODO Auto-generated method stub
		return 0;
	}
    
    

}
