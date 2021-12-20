package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CandidateProcedure {
	
	private Connection connection;
 	 private PreparedStatement pst;
 	 private dbhandler handler=new dbhandler();
 	 

 	 
 	 Candidate candidate;
 	 
 	
 	   @FXML
 	    void viewreport(ActionEvent event) throws IOException {
 		   
 		   candidate=new Candidate(null, null, null,"", null);
 		
 		   System.out.println("\n***********************Results***********************");
 		   candidate.viewreport();
 		   

 	    }
 

    @FXML
    void checkstatus(ActionEvent event) throws IOException {
    	
    	
    	
    	
    	
    	candidate=new Candidate(null, null, null,"", null);
    	candidate.checkstatus();
       	


        }
    


    	

    

    @FXML
    void logout(ActionEvent event) throws IOException {
    	
    	

    	Main m=new Main();
        m.changeScene("Choice.fxml","Electronic Voting");
    	
		
//		  Stage votingproc=new Stage(); Parent
//		  root=FXMLLoader.load(getClass().getResource("Choice.fxml"));
//		  
//		  Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
//		  votingproc.setResizable(false);
//		  
//		  votingproc.setTitle("Electronic Voting");
//		 
    }

    @FXML
    void updateprofile(ActionEvent event) throws IOException {
    	
    	

    	Main m=new Main();
        m.changeScene("UpdateProfile.fxml","Update Profile");

//		  Stage votingproc=new Stage(); Parent
//		  root=FXMLLoader.load(getClass().getResource("UpdateProfile.fxml"));
//		  
//		  Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
//		  votingproc.setResizable(false);
//		  
//		  votingproc.setTitle("Update Profile");
//    	
    	

    }

}
