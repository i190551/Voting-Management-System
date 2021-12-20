package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connectiondb.dbhandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;


public class newcandidate implements Initializable {
	
	 private Connection connection;
	    private PreparedStatement pst;
	    private dbhandler handler=new dbhandler();

	    
	    Candidate candidate;

	    String party,Symbol;
    @FXML
    private TextField candname;

  

    
    @FXML
    private TextField candcnic;

    @FXML
    private Button submit;
    @FXML
    private PasswordField passwordcand;
    
    @FXML
    private ComboBox<String> candparty;
    
    @FXML
    private ComboBox<String> candsymbol;
    
  

    @FXML
    void candparty(ActionEvent event) {
    	
    	party=candparty.getSelectionModel().getSelectedItem().toString();

    }
    

    @FXML
    void candsymbol(ActionEvent event) {
    	
    	Symbol=candsymbol.getSelectionModel().getSelectedItem().toString();


    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	    ObservableList<String> list =
	 	    	  FXCollections.observableArrayList("PTI","PMLN","PPP","MQM","TLP","JUI");
	 	    	  candparty.setItems(list);
	

	 	 	    ObservableList<String> list1 =
	 	 	 	    	  FXCollections.observableArrayList("Bat","Lion","Arrow","Kite","Crane","Flag");
	 	 	 	    	  candsymbol.setItems(list1);
	
	}
    
    @FXML
    void submit(ActionEvent event) throws IOException {
    	
    	
    	
    	
    	candidate=new Candidate(candname.getText(),Symbol,party,candcnic.getText(),passwordcand.getText());
    	    	
    	candidate.signup();
    	
    	
    }


}
