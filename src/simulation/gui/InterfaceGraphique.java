/*
 * Interface.java		27 nov. 2019
 * Pas de droits, ni copyright ni copyleft
 */
package simulation.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import simulation.lois.Binomiale;
import simulation.lois.Discrete;
import simulation.lois.Exponentielle;
import simulation.lois.Normale;
import simulation.lois.UniformeDiscrete;

/**
 * 
 * @author Alban Olive
 */
public class InterfaceGraphique {

	private Scene scene;
	private Button simuler;
	private Button enregistrer;
	private ComboBox<String> lois;

	private TextArea valeurs;
	private TextArea probas;
	private TextArea liste;
	private Spinner<Double> lambda;
	private Spinner<Double> esperance;
	private Spinner<Double> ecartType;
	private Spinner<Double> succes;
	private Spinner<Integer> nbExperiences;
	private Spinner<Integer> nbSimu;

	private LineChart<Number, Number> courbe;

	private FileChooser fileChooser;

	private double[] tabValeurs;
	private double[] tabValeursN;
	private double[] tabValeursD;
	private double[] tabValeursP;

	/**
	 * 
	 */
	public InterfaceGraphique() {
		BorderPane root = new BorderPane();
		VBox left = new VBox();
		left.setPrefSize(205.0, 550.0);
		left.setPadding(new Insets(10, 0, 0, 10));
		left.setSpacing(10);
		BorderPane.setAlignment(left, Pos.CENTER);

		VBox boxLois = new VBox();
		boxLois.setPrefSize(195.0, 79.0);
		boxLois.setBackground(new Background(
				new BackgroundFill(Color.GRAY, new CornerRadii(5), null)));
		boxLois.setAlignment(Pos.CENTER);
		VBox.setMargin(boxLois, new Insets(10, 0, 10, 0));

		Label lblLoi = new Label("Loi à simuler");
		VBox.setMargin(lblLoi, new Insets(5));

		lois = new ComboBox<>();
		lois.getItems().addAll("Loi binomiale", "Loi uniforme discrète",
				"Loi exponentielle", "Loi normale", "Loi discrète");

		boxLois.getChildren().addAll(lblLoi, lois);

		VBox boxChoix = new VBox();
		boxChoix.setBackground(new Background(
				new BackgroundFill(Color.GRAY, new CornerRadii(5), null)));
		boxChoix.setPadding(new Insets(10));
		boxChoix.setAlignment(Pos.CENTER);
		boxChoix.setSpacing(10);
		VBox.setVgrow(boxChoix, Priority.ALWAYS);
		VBox.setMargin(boxChoix, new Insets(10, 0, 10, 0));

		// Loi discrète
		valeurs = new TextArea();
		valeurs.setPrefSize(175.0, 111.0);

		probas = new TextArea();
		probas.setPrefSize(175.0, 111.0);

		// Loi uniforme discrète

		liste = new TextArea();
		liste.setPrefSize(175.0, 111.0);

		// Loi exponentielle

		lambda = new Spinner<>(
				new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,
						Double.MAX_VALUE));
		lambda.setEditable(true);

		// Loi normale

		esperance = new Spinner<>(
				new SpinnerValueFactory.DoubleSpinnerValueFactory(-100000000,
						1000000000, 0.0));
		esperance.setEditable(true);
		ecartType = new Spinner<>(
				new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,
						Double.MAX_VALUE));
		ecartType.setEditable(true);

		// Loi Binomiale

		succes = new Spinner<>(
				new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1, 0.5,
						0.01));
		succes.setEditable(true);

		nbExperiences = new Spinner<>(
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50000));
		nbExperiences.setEditable(true);

		nbSimu = new Spinner<>();
		nbSimu.setValueFactory(
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50000,
						30));
		nbSimu.setEditable(true);

		Region blanc = new Region();
		VBox.setVgrow(blanc, Priority.ALWAYS);

		simuler = new Button("Simuler");
		simuler.setPrefSize(184.0, 32.0);

		enregistrer = new Button("Enregistrer");
		enregistrer.setPrefSize(184.0, 32.0);

		lois.valueProperty().addListener(l -> {
			boxChoix.getChildren().clear();
			enregistrer.setDisable(true);
			switch (lois.getValue()) {
			case "Loi binomiale":
				boxChoix.getChildren().addAll(
						new Label("Probabilité du succès"), succes,
						new Label("Nombre d'expériences"), nbExperiences);
				break;
			case "Loi uniforme discrète":
				boxChoix.getChildren().addAll(new Label("Valeurs possibles"),
						liste);
				break;
			case "Loi exponentielle":
				boxChoix.getChildren().addAll(new Label("Lambda"), lambda);
				break;
			case "Loi normale":
				boxChoix.getChildren().addAll(new Label("Esperance"), esperance,
						new Label("Ecart-type"), ecartType);
				break;
			case "Loi discrète":
				boxChoix.getChildren().addAll(new Label("Valeurs possibles"),
						valeurs, new Label("Probabilités associées"), probas);
			}
			boxChoix.getChildren().addAll(new Label("Nombre de simulations"),
					nbSimu, blanc, simuler, enregistrer);
		});

		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();

		courbe = new LineChart<Number, Number>(xAxis, yAxis);
		courbe.setCreateSymbols(false);
		courbe.setAnimated(false);
		courbe.getStylesheets().add("simulation/style.css");

		left.getChildren().addAll(boxLois, boxChoix);
		root.setLeft(left);
		root.setCenter(courbe);
		scene = new Scene(root);

		lois.getSelectionModel().select(0);

		events();
	}

	/**
	 * 
	 */
	private void events() {
		simuler.setOnAction(e -> {
			courbe.getData().clear();
			courbe.setLegendVisible(true);
			boolean enr = true;
			switch (lois.getValue()) {
			case "Loi binomiale":
				loiBinomiale();
				break;
			case "Loi uniforme discrète":
				enr = loiUniformeDiscrete();
				break;
			case "Loi exponentielle":
				loiExponentielle();
				break;
			case "Loi normale":
				loiNormale(esperance.getValue(), ecartType.getValue());
				break;
			case "Loi discrète":
				enr = loiDiscrete();
			}
			if (enr) {
				enregistrer.setDisable(false);
			}
		});

		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters()
				.add(new FileChooser.ExtensionFilter("CSV", "*.csv"));
		enregistrer.setOnAction(e -> {
			File csv;
			if ((csv = fileChooser.showSaveDialog(scene.getWindow())) != null) {
				try {
					PrintWriter fichier = new PrintWriter(new FileWriter(csv));
					if (lois.getValue() == "Loi normale") {
						fichier.println("Simulation d'une loi normale");
						fichier.println("Esperance : ;" + esperance.getValue());
						fichier.println(
								"Ecart-type : ;" + ecartType.getValue());
						for (double d : tabValeursN) {
							fichier.println(d);
						}
					} else {
						switch (lois.getValue()) {
						case "Loi binomiale":
							fichier.println("Simulation d'une loi binomiale");
							fichier.println("Proba de succès : ;"
									+ virgule(succes.getValue()));
							fichier.println("Nb d'exprériences : ;"
									+ nbExperiences.getValue());
							break;
						case "Loi uniforme discrète":
							fichier.println(
									"Simulation d'une loi uniforme discrète");
							fichier.print("Valeurs");
							for (double d : tabValeursD) {
								fichier.print(";" + virgule(d));
							}
							fichier.println();
							fichier.print("Probas");
							for (int i = 0; i < tabValeursD.length; i++) {
								fichier.print(";"
										+ virgule(1.0 / tabValeursD.length));
							}
							fichier.println();
							break;
						case "Loi exponentielle":
							fichier.println(
									"Simulation d'une loi exponentielle");
							fichier.println(
									"Lambda : ;" + virgule(lambda.getValue()));
							break;
						case "Loi discrète":
							fichier.println("Simulation d'une loi discrète");
							fichier.print("Valeurs");
							for (double d : tabValeursD) {
								fichier.print(";" + virgule(d));
							}
							fichier.println();
							fichier.print("Probas");
							for (double d : tabValeursP) {
								fichier.print(";" + virgule(d));
							}
							fichier.println();
						}

						for (double d : tabValeurs) {
							fichier.println(virgule(d));
						}
					}
					fichier.close();
				} catch (IOException e1) {
					// Erreur d'acces au fichier
				}
			}
		});

	}

	private String virgule(double d) {
		return Double.toString(d).replace(".", ",");
	}

	/**
	 * 
	 */
	private void loiBinomiale() {

		Binomiale bn = new Binomiale(nbExperiences.getValue(),
				succes.getValue(), nbSimu.getValue());
		double esperance = bn.esperance();
		double ecartType = Math.sqrt(bn.variance());
		tabValeurs = bn.simuler();

		Series<Number, Number> gauss = new Series<>();

		double v;

		for (double x = 0.0; x < ecartType * 4.0 + esperance; x += 0.01) {
			v = (x - esperance) / ecartType;
			gauss.getData()
					.add(new Data<Number, Number>(x, Math.exp(-0.5 * v * v)
							/ (ecartType * Math.sqrt(2 * Math.PI))));
		}

		courbe.setLegendVisible(false);
		courbe.getData().add(gauss);

		for (int x = 0; x < (int) (ecartType * 4.0 + esperance); x += 1) {
			if (x > esperance && bn.proba(x + 1) > bn.proba(x)) {
				break;
			}
			Series<Number, Number> probas = new Series<>();
			probas.getData().add(new Data<Number, Number>(x, 0));
			probas.getData().add(new Data<Number, Number>(x, bn.proba(x)));
			courbe.getData().add(probas);
			Node line = probas.getNode().lookup(".chart-series-line");
			line.setStyle("-fx-stroke: red;");
		}
	}

	/**
	 * 
	 */
	private boolean loiUniformeDiscrete() {
		String[] valeursTexte = liste.getText().split(";");
		double[] valeursDouble = new double[valeursTexte.length];

		try {
			for (int i = 0; i < valeursTexte.length; i++) {
				valeursDouble[i] = Double.parseDouble(valeursTexte[i]);
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Valeurs au mauvais format");
			alert.setContentText("Format correct : 3.2;5.9;-6.2");
			alert.show();
			return false;
		}
		tabValeursD = valeursDouble;

		UniformeDiscrete ud = new UniformeDiscrete(valeursDouble,
				nbSimu.getValue());
		double[] resultat = ud.simuler();
		loiNormale(ud.esperance(), Math.sqrt(ud.variance()));
		tabValeurs = resultat;

		Series<Number, Number> serieUD = new Series<>();
		serieUD.setName("Loi uniforme discrète");

		double somme = 0;
		for (int i = 0; i < resultat.length; i++) {
			somme += resultat[i];
			serieUD.getData()
					.add(new Data<Number, Number>(i + 1, somme / (i + 1)));
		}

		courbe.getData().add(serieUD);
		return true;
	}

	/**
	 * 
	 */
	private void loiExponentielle() {

		Exponentielle ex = new Exponentielle(lambda.getValue(),
				nbSimu.getValue());
		double[] resultatExp = ex.simuler();
		loiNormale(ex.esperance(), Math.sqrt(ex.variance()));
		tabValeurs = resultatExp;

		Series<Number, Number> serieEX = new Series<>();
		serieEX.setName("Loi exponentielle");

		double somme = 0;
		for (int i = 0; i < resultatExp.length; i++) {
			somme += resultatExp[i];
			serieEX.getData()
					.add(new Data<Number, Number>(i + 1, somme / (i + 1)));
		}

		courbe.getData().add(serieEX);

	}

	/**
	 * 
	 */
	private void loiNormale(double esperance, double ecartType) {

		Normale n = new Normale(esperance, ecartType, nbSimu.getValue());
		double[] resultatNormal = n.simuler();
		tabValeursN = resultatNormal;

		Series<Number, Number> serieN = new Series<>();
		serieN.setName("Loi normale");

		double somme = 0;
		for (int i = 0; i < resultatNormal.length; i++) {
			somme += resultatNormal[i];
			serieN.getData()
					.add(new Data<Number, Number>(i + 1, somme / (i + 1)));
		}

		courbe.getData().add(serieN);
	}

	/**
	 * 
	 */
	private boolean loiDiscrete() {
		String[] valeursTexte = valeurs.getText().split(";");
		double[] valeursDouble = new double[valeursTexte.length];

		String[] probasTexte = probas.getText().split(";");
		double[] probasDouble = new double[probasTexte.length];

		if (valeursTexte.length != probasTexte.length) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Mauvais nombre d'arguments");
			alert.setContentText(
					"Une et une seule proba doit être associée à une valeur");
			alert.show();
			return false;
		}

		try {
			for (int i = 0; i < valeursTexte.length; i++) {
				valeursDouble[i] = Double.parseDouble(valeursTexte[i]);
			}

			for (int i = 0; i < probasTexte.length; i++) {
				probasDouble[i] = Double.parseDouble(probasTexte[i]);
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Valeurs au mauvais format");
			alert.setContentText("Format correct : 3.2;5.9;-6.2");
			alert.show();
			return false;
		}

		tabValeursD = valeursDouble;
		tabValeursP = probasDouble;
		double sommeVerif = 0; // Initialisation de la somme des probas a 0

		// Fait la somme des probas
		for (int i = 0; i < probasDouble.length; i++) {
			sommeVerif += probasDouble[i];
		}

		if (sommeVerif != 1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Somme des probabilités");
			alert.setContentText(
					"La somme des probabilités doit être égale à 1");
			alert.show();
			return false;
		}

		Discrete dis = new Discrete(valeursDouble, probasDouble,
				nbSimu.getValue());
		double[] resultatDis = dis.simuler();
		loiNormale(dis.esperance(), Math.sqrt(dis.variance()));
		tabValeurs = resultatDis;

		Series<Number, Number> serieDIS = new Series<>();
		serieDIS.setName("Loi discrète");

		double somme = 0;
		for (int i = 0; i < resultatDis.length; i++) {
			somme += resultatDis[i];
			serieDIS.getData()
					.add(new Data<Number, Number>(i + 1, somme / (i + 1)));
		}

		courbe.getData().add(serieDIS);
		return true;

	}

	/**
	 * @return scene
	 */
	public Scene getScene() {
		return scene;
	}

}
