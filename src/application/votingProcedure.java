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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class votingProcedure {


	private Connection connection;
  	 private PreparedStatement pst;
  	 private dbhandler handler=new dbhandler();
 	Voter v=new Voter("","","","","");
	
    @FXML
    private Button castvote;

    @FXML
    private Button help;

    @FXML
    private Button logoutvoter;

    @FXML
    private Button viewresult;

    @FXML
    private TextField searchbar;
    @FXML
    void castvote(ActionEvent event) throws IOException {
    	
    	Main m=new Main();
        m.changeScene("Cast_Vote.fxml","Casting Vote");
    	
//    	Stage votingproc=new Stage();
//    	Parent root=FXMLLoader.load(getClass().getResource("Cast_Vote.fxml"));
//
//    	Scene scene=new Scene(root);
//    	votingproc.setScene(scene);
//    	votingproc.show();
//    	votingproc.setResizable(false);
//
//    	votingproc.setTitle("Casting Vote");
    	
    }

    @FXML
    void help(ActionEvent event) throws IOException {
    
    	v.HELP();
    }

    @FXML
    void logoutvoter(ActionEvent event) throws IOException {
    	v.logoutvoter();
    }

    @FXML
    void viewresult(ActionEvent event) throws IOException 
    {
    	
    	v.viewreport();
   	
      }

    @FXML
    void viewcand(ActionEvent event) {

    	
    	v.viewcandidates();
    }
    
    @FXML
    void searchcandidate(ActionEvent event) throws IOException {
    	
    	Main m=new Main();
        m.changeScene("SearchingCandidate.fxml","Search");
//    	Stage votingproc=new Stage(); 
//    	Parent root=FXMLLoader.load(getClass().getResource("SearchingCandidate.fxml"));
//		  
//		  Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
//		  votingproc.setResizable(false);
//		  
//		  votingproc.setTitle("Search Candidate");
    }
    


    @FXML
    void back(ActionEvent event) throws IOException {
    	
    	Main m=new Main();
        m.changeScene("votingProcedure.fxml","Options");
    	
//    	Stage votingproc=new Stage(); 
//    	Parent root=FXMLLoader.load(getClass().getResource("votingProcedure.fxml"));
//		  
//		  Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
//		  votingproc.setResizable(false);
//		  
//		  votingproc.setTitle("Voting Procedure");

    }

    @FXML
    void searchcand(ActionEvent event) {
    	
    	v.searchcandidates(searchbar.getText());
    	

    }

   

}
