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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateProfile {
	private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();
	 
Candidate candidate;

    @FXML
    private TextField cnic;

    @FXML
    private TextField newusername;

    @FXML
    private TextField newpassword;

    @FXML
    void cancel(ActionEvent event) throws IOException {
    	

    	Main m=new Main();
        m.changeScene("CandidateProcedure.fxml","Options");

    	
//    	Stage votingproc=new Stage(); Parent
//		  root=FXMLLoader.load(getClass().getResource("CandidateProcedure.fxml"));
//		  
//		  Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
//		  votingproc.setResizable(false);
//		  
//		  votingproc.setTitle("Options");
    }

    @FXML
    void submit(ActionEvent event) throws IOException {
    	
    
    
    	
    	candidate=new Candidate(newusername.getText(),"","",cnic.getText(), newpassword.getText());
    	
    	candidate.updateprofile();
    	
    			
//		Stage votingproc=new Stage(); Parent
//		  root=FXMLLoader.load(getClass().getResource("CandidateProcedure.fxml"));
//		  
//		  Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
//		  votingproc.setResizable(false);
//		  
//		  votingproc.setTitle("Options");

    }

}
