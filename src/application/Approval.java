package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Approval {

	 Administrator admin;
	 

     private void showAlert1(AlertType error, Window owner, String string, String string2) {
 		// TODO Auto-generated method stub
 		 Alert alert = new Alert(error);
 	        alert.setTitle(string);
 	        alert.setHeaderText(null);
 	        alert.setContentText(string2);
 	        alert.initOwner(owner);
 	        alert.show();
 		
 	}
    @FXML
    private TextField cnicvoter;
    
    @FXML
    private TextField cniccand;
    

    @FXML
    void approve(ActionEvent event) throws IOException {
    	


        admin=new Administrator(cnicvoter.getText());		
		
    	admin.approveVoter();;
		
    	  showAlert1(Alert.AlertType.CONFIRMATION,null, "Approved",
                  "Approved");

    }

    @FXML
    void disapprove(ActionEvent event) throws IOException {
    		


        admin=new Administrator(cnicvoter.getText());		
		
		
        admin.disapprovevoter();

        System.out.println("Status:Disapproved");
    	
        showAlert1(Alert.AlertType.CONFIRMATION,null, "Disapproved",
                "Disapproved");

    }
    

  

    @FXML
    void approvecand(ActionEvent event) throws IOException {
    	
    	
    	


        admin=new Administrator(cniccand.getText());		
		
    	admin.approvecandidate();
    	
    	  showAlert1(Alert.AlertType.CONFIRMATION,null, "Approved",
                  "Approved");

    }

    @FXML
    void disapprovecand(ActionEvent event) throws IOException {
    	


        admin=new Administrator(cniccand.getText());		
		
    	admin.disapprovecandidate();;
		
    	  showAlert1(Alert.AlertType.CONFIRMATION,null, "Disapproved",
                  "Disapproved");

    }

}
