/*
 * TestClasses          22/11/19
 * Pas de copyright ou de copyleft
 */
package tests;

import projetModel.Binomiale;
import projetModel.ErreurParametresLoi;
import projetModel.Exponentielle;
import projetModel.Normale;



/**
 * Classe de test des classes Exponentielle.java et Normale.java
 */
public class TestClasses {

    public static void testExpo(double lambda, int nbSimulations) {

        double[] aAfficher;

        Exponentielle aTester = new Exponentielle(lambda, nbSimulations);
        aAfficher = aTester.simulations;
        for (int i=0; i<aAfficher.length; i++) {
            System.out.println(aAfficher[i]);
        }
    }

    public static void testNormale(double esperence, double ecartType, int nbSimulations) {

        double[] aAfficher;

        Normale aTester = new Normale(esperence, ecartType, nbSimulations);
        aAfficher = aTester.simulations;
        for (int i=0; i<aAfficher.length; i++) {
            System.out.println(aAfficher[i]);
        }
    }
    
    public static void testBinomiale(int n, double p, int nbSimulations) throws ErreurParametresLoi {
    	double[] afficher ;
    	
    	Binomiale aTester = new Binomiale(n, p, nbSimulations);
    	aTester.simuler();
    	afficher = aTester.simulations;
    	for (int i = 0; i<afficher.length; i++) {
    		System.out.print(afficher[i] + " ");
    	}
    	System.out.println("");
    	System.out.println("variance =" + aTester.variance());
    	System.out.println("esperance = " + aTester.esperance());
    }

    /**
     * Lancement des tests
     * @param args non utilisé
     * @throws ErreurParametresLoi 
     */
    public static void main(String[] args) throws ErreurParametresLoi {
        //testExpo(0.1,10);
        //testNormale();
    	testBinomiale(5, 0.1 ,10);
    }
}
