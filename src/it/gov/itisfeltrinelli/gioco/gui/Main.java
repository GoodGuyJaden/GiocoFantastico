package it.gov.itisfeltrinelli.gioco.gui;

import it.gov.itisfeltrinelli.gioco.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("GiocoView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
			
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("ProvaView.fxml"));   //creo il loader per la view
//			BorderPane root = loader.load();												//creo lo stage caricando il loader
//			GiocoController gController = loader.getController();							//creo il controller passandogli il loader??
//			GiocoModel model = new prova.Prova();											//creo l'oggetto del nostro modello
//			gController.setModel(model);													//passo l'oggetto del modello al controller
//			
//			
//			//Scene scene = new Scene(root,400,400);
//			Scene scene = new Scene(root);													//copiato dall'esempio, chiedere approfondimenti
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
