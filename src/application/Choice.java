package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Choice {
	
	   @FXML
	    private Button choicevoter;
	   @FXML
	    private Button choiceadmin;
	    @FXML
	    void voterchoice(ActionEvent event) throws IOException {
	    	
	    	
	    	Main m=new Main();
            m.changeScene("LoginPageVoter.fxml","Login");
	    	
			/*
			 * Stage votingproc=new Stage(); Parent
			 * root=FXMLLoader.load(getClass().getResource("LoginPageVoter.fxml"));
			 * 
			 * Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
			 * votingproc.setResizable(false);
			 * 
			 * votingproc.setTitle("Login");
			 */
			

	    }
	    
	    @FXML
	    void candidatechoice(ActionEvent event) throws IOException {
	    	

	    	Main m=new Main();
            m.changeScene("LoginPageCandidate.fxml","Login");
	    	
//	    	Stage votingproc=new Stage();
//			Parent root=FXMLLoader.load(getClass().getResource("LoginPageCandidate.fxml"));
//
//			
//			Scene scene=new Scene(root);
//			votingproc.setScene(scene);
//			votingproc.show();
//			votingproc.setResizable(false);
//
//			votingproc.setTitle("LoginAsCandidate");
			

	    }
	    
	    @FXML
	    void adminchoice(ActionEvent event) throws IOException {
	    	

	    	Main m=new Main();
            m.changeScene("LoginPageAdmin.fxml","Login");
//	    	Stage votingproc=new Stage();
//			Parent root=FXMLLoader.load(getClass().getResource("LoginPageAdmin.fxml"));
//
//			Scene scene=new Scene(root);
//			votingproc.setScene(scene);
//			votingproc.show();
//			votingproc.setResizable(false);
//
//			votingproc.setTitle("Login");
			
	    	

	    }


}
