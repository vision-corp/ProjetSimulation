/*
 * Uniforme.java                                                                                 20/11/2019
 * Pas de copyright
 */
package projetModel;

/**
 * Simule une loi uniforme
 *
 * @author tommargalejo
 * @version 1.0
 */
public class Discrete extends Loi{
    /** Ensemble de valeurs*/
    private double[] valeurs;

    /**
     * Nouvelle loi discrète
     * @param valeurs 
     * @param nbSimulations nombre de simulations à effectuer
     * @throws ErreurParametresLoi jetée lors d'une erreur de paramètres
     */
    public Discrete(double[] valeurs, int nbSimulations) throws ErreurParametresLoi {
        if (valeurs.length < 1|| nbSimulations < 1) {
            throw new ErreurParametresLoi("UniformeDiscrete");
        }
        this.valeurs = valeurs;
        this.nbSimulations = nbSimulations;
        this.simulations = new double[nbSimulations];
    }

    @Override
    public void simuler() throws ErreurParametresLoi {
        for(int i = 0; i < this.nbSimulations; i++) {
            this.simulations[i] = Math.round((Math.random() * valeurs.length));
        }
        
        this.esperence = (1.0/(double)valeurs.length) * somme(valeurs);
        this.ecartType = Math.sqrt((1.0/(double)valeurs.length) * sommeCarre(valeurs) - (this.esperence * this.esperence));

        
    }
    
    /**
     * Fait la somme des éléments d'un tableau
     * @param val valeurs dont on veut faire la somme
     * @return somme des valeurs
     */
    private static double somme (double[] val) {
        double somme = 0;
        
        for(int i = 0; i < val.length; i++) {
            somme += val[i];
        }
        
        return somme;
    }
    
    /**
     * Fait la somme des éléments d'un tableau au carré
     * @param val valeurs dont on veut faire la somme au carré
     * @return somme des valeurs au carré
     */
    private static double sommeCarre (double[] val) {
        double somme = 0;
        
        for(int i = 0; i < val.length; i++) {
            somme += val[i] * val[i];
        }
        
        return somme;
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