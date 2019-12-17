/*
 * Enregistrer.java		17 déc. 2019
 * Pas de droits, ni copyright ni copyleft
 */
package simulation.gui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Alban Olive
 */
public class Enregistrer {

	private static int nbBn = 0;
	private static int nbUd = 0;
	private static int nbEx = 0;
	private static int nbN = 0;
	private static int nbDis = 0;

	public static void enregistrer(double[] valeurs, char type) {
		String nomFichier = "Loi";
		switch (type) {
		case 'B':
			nomFichier += "binomiale_" + nbBn;
			nbBn++;
			break;
		case 'U':
			nomFichier += "uniforme_discrete_" + nbUd;
			nbUd++;
			break;
		case 'E':
			nomFichier += "exponentielle_" + nbEx;
			nbEx++;
			break;
		case 'N':
			nomFichier += "normale_" + nbN;
			nbN++;
			break;
		case 'D':
			nomFichier += "discrete_" + nbDis;
			nbDis++;
		}
		nomFichier += ".csv";

		try {
			PrintWriter fichier = new PrintWriter(
					new FileWriter("src/simulation/fichiers/" + nomFichier));
			for (Double d : valeurs) {
				fichier.println(d);
			}

			fichier.close();
		} catch (IOException e) {
			System.out.println("Erreur d'acces au fichier");
		}
	}

}
