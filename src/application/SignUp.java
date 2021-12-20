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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUp {
	
	@FXML
    private TextField username;

    @FXML
    private TextField cnic;

    @FXML
    private TextField place;

    @FXML
    private PasswordField password;
    

    @FXML
    private TextField Age;
    
    
    Voter voter;
    
    private Connection connection;
    private PreparedStatement pst;
    private dbhandler handler=new dbhandler();

    @FXML
    void backtologin(ActionEvent event) throws IOException {
    	

    	Main m=new Main();
        m.changeScene("LoginPageVoter.fxml","Login");
//    	Stage votingproc=new Stage();
//		Parent root=FXMLLoader.load(getClass().getResource("LoginPageVoter.fxml"));
//
//		Scene scene=new Scene(root);
//		votingproc.setScene(scene);
//		votingproc.show();
//		votingproc.setResizable(false);
//
//		votingproc.setTitle("Login");

    }

    @FXML
    void signupdone(ActionEvent event) throws IOException {
        
    
   
    	
    	
    	
    	voter=new Voter(username.getText(),cnic.getText(),place.getText(),password.getText(),Age.getText());
    	
    	voter.signup();
    	
    
		
//		Stage votingproc=new Stage();
//		Parent root=FXMLLoader.load(getClass().getResource("LoginPageVoter.fxml"));
//
//		Scene scene=new Scene(root);
//		votingproc.setScene(scene);
//		votingproc.show();
//		votingproc.setResizable(false);
//
//		votingproc.setTitle("Login");

    }

}
