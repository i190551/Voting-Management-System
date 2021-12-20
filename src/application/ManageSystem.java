package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManageSystem {
	
	 private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();
	 Administrator admin=new Administrator("");
		
	  @FXML
	    private Button records;

	    @FXML
	    private Button addnewparty;

	    @FXML
	    private Button addnewcand;
	    
	    @FXML
	    private Button logout;


	    @FXML
	    void logoutAdmin(ActionEvent event) throws IOException {
	    	
	    	

	    	Main m=new Main();
            m.changeScene("Choice.fxml","Electronic Voting");
//	    	Stage votingproc=new Stage();
//			Parent root=FXMLLoader.load(getClass().getResource("Choice.fxml"));
//
//			Scene scene=new Scene(root);
//			votingproc.setScene(scene);
//			votingproc.show();
//			votingproc.setResizable(false);
//
//			votingproc.setTitle("Electronic Voting");
			

	    }
  
	    @FXML
	    void recordscandidates(ActionEvent event) throws IOException {
	    	
	    	Administrator administrator = new Administrator("");
			administrator.recordsofcandidates();	    }
    @FXML
    void managecandidate(ActionEvent event) throws IOException {
    	
    	admin.ManageCandidate();

    }




    @FXML
    void managevoter(ActionEvent event) throws IOException {
    	
    	admin.ManageVoter();
    }
 
    @FXML
    void recordsvotes(ActionEvent event) throws IOException {
    	Administrator administrator = new Administrator("");
		administrator.recordofvoters();		

    }
    


}
