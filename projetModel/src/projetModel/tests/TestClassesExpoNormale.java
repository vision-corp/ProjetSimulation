/*
 * TestClasses          22/11/19
 * Pas de copyright ou de copyleft
 */

/**
 * Classe de test des classes Exponentielle.java et Normale.java
 */
public class TestClassesExpoNormale {

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

    /**
     * Lancement des tests
     * @param args non utilisé
     */
    public static void main(String[] args) {
        //STUB
    }
}
