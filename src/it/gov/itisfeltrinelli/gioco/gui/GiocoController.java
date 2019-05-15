/**
 * Sample Skeleton for 'GiocoView.fxml' Controller Class
 */

package it.gov.itisfeltrinelli.gioco.gui;

import it.gov.itisfeltrinelli.gioco.model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class GiocoController {

//	private GiocoModel model;
//	
//	public void setModel(GiocoModel model)
//	{
//		this.model = model;
//	}
//	
//	@FXML
//	private TextArea txtNome;
//	//
//	@FXML
//	private Button btn;
//	
//	@FXML
//	void scrivi(ActionEvent event)
//	{
//		txtNome.setText(String.valueOf("Ciao"));
//	}//
	
	
	private GiocoModel model = new GiocoModel();
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnStart"
    private Button btnStart; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumero"
    private TextField txtNumero; // Value injected by FXMLLoader

    @FXML // fx:id="btnIndovina"
    private Button btnIndovina; // Value injected by FXMLLoader

    @FXML // fx:id="txtStatus"
    private TextField txtStatus; // Value injected by FXMLLoader

    @FXML
    void onIndovina(ActionEvent event) {
    	
    	int numero;
    	try
    	{
    		numero = Integer.parseInt(txtNumero.getText().replaceAll("\\D+", ""));
    		
    		int ris;
    		ris = model.controlla(numero);
    		
    		//numero fuori range
    		if(ris == -2)		txtStatus.setText("Il numero inserito è fuori range. Inserisci numeri compresi tra 1 e " + model.getMAXNUMERO());
    		
    		//num troppo piccolo, ma nel range
    		else if(ris == 1)	txtStatus.setText("Il numero da indovinare è maggiore del numero inserito");
    		
    		//num troppo grande, ma nel range
    		else if(ris == 2)	txtStatus.setText("Il numero da da indovinare è minore del numero inserito");	
    		
    		//ris giusto
    		else
    		{
    			txtStatus.setText("HAI INDOVINATO!!!");
    			btnIndovina.setDisable(true);
    			btnStart.setDisable(false);
    			btnStart.setDefaultButton(true);	//il bottone start dovrebbe tornare ad essere il predefinito, ma non va con "INVIO"
    		}
    		    		
    	}catch(NumberFormatException e)
    	{
    		txtStatus.setText("Inserisci solo numeri grazie!");
    	}
    	
    	txtTentativi.setText(model.getTentativi());
    	txtNumero.setText("");
    	
    }

    @FXML
    void onStart(ActionEvent event) {
    	btnIndovina.setDisable(false);
    	btnStart.setDisable(true);
    	btnIndovina.setDefaultButton(true);
    	model.startGame();
    	txtTentativi.setText(model.getTentativi());
    	txtStatus.setText("");
    	txtNumero.setText("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'GiocoView.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'GiocoView.fxml'.";
        assert txtNumero != null : "fx:id=\"txtNumero\" was not injected: check your FXML file 'GiocoView.fxml'.";
        assert btnIndovina != null : "fx:id=\"btnIndovina\" was not injected: check your FXML file 'GiocoView.fxml'.";
        assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'GiocoView.fxml'.";

        btnStart.setDefaultButton(true);	//serve per impostare il tasto come predefinito in modo tale da poter essere cliccato anche con "INVIO", ma funziona solo se c'è un solo tasto di default
        btnIndovina.setDisable(true);
    }

	public void setModel(GiocoModel model) {
		this.model= model;
	}
}
