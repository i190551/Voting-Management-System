package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectiondb.dbhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageCandidate {
    
    private dbhandler handler=new dbhandler();
    private Connection connection;
    private PreparedStatement pst;
    
    Candidate candidate=new Candidate("", "", "", "", "");

    @FXML
    public TextField candidatecnic;

    @FXML
    private PasswordField candidatepassword;

    @FXML
    private Button logincand;
    
    public String n;
    
    @FXML
    void SignupCandidate(ActionEvent event) throws IOException {
    	
    	

    	Main m=new Main();
        m.changeScene("newcandidate.fxml","Add new Candidate");
//    	Stage votingproc=new Stage();
//		Parent root=FXMLLoader.load(getClass().getResource("newcandidate.fxml"));
//
//		Scene scene=new Scene(root);
//		votingproc.setScene(scene);
//		votingproc.show();
//		votingproc.setResizable(false);
//
//		votingproc.setTitle("Add new Candidate");
		

    }

    @FXML
    void logincandidate(ActionEvent event) throws IOException {
    	
    	
    	
    	n=candidatepassword.getText();
    	candidate=new Candidate("","","",candidatecnic.getText(),candidatepassword.getText());
    	candidate.login();
    	
    	
    	
    	
    	
    }
    
    

  
    
}
