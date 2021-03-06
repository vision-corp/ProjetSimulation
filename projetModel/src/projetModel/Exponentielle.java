/*
 * Exponentielle.java                07/11/19
 * Pas de copyright ou de copyleft
 */

/*
    Simulation de la loi exponentielle :
    Si X suit une loi uniforme sur [0,1], alors (-1/lambda)*ln(1 - X) suit une loi de paramètre lambda

 */

package projetModel;

import static java.lang.Math.log;
import static java.lang.Math.random;

/**
 * Classe modélisant une loi exponentielle
 * Permettant de calculer ses indicateurs
 * Choix du paramètre lambda
 * Sur l'ensemble des réels strictement positif
 */
public class Exponentielle extends Loi {

    /** Paramètre lambda de la loi exponentielle */
    private double lambda;

    /**
     * Constructeur de la loi exponentielle
     * @param newLambda paramètre lambda de la loi exponentielle a créer
     */
    public Exponentielle(double newLambda, int newNbSimulation) {
        this.lambda = newLambda;
        this.nbSimulations = newNbSimulation;
        this.simulations = new double[nbSimulations];
    }

    /**
     * Simule la loi exponentielle
     */
    @Override
    public void simuler() throws ErreurParametresLoi {

        double variable; // Variable aléatoire dans [0,1]
        for (int i=0; i<this.nbSimulations; i++) {
            variable = random();
            simulations[i] = (-1/this.lambda)*log(1-variable);
        }
    }

    /**
     * @return la variance
     */
    @Override
    public double variance() {
        return 1/(lambda*lambda);
    }

	@Override
	public double esperance() throws ErreurParametresLoi {
		return 1/lambda;
	}
}
