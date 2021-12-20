package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import connectiondb.dbhandler;
public class LoginPageVoter {
	
	  @FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;
	 @FXML
	    private Button loginvoter;

	    @FXML
	    private Button signup;

	    
	    private dbhandler handler=new dbhandler();
	    private Connection connection;
	    private PreparedStatement pst;
	    
	    Voter voter;
	    
	    @FXML
	    void loginvoter(ActionEvent event) throws IOException 
	    {
	    	

	    	voter = new Voter(username.getText(),username.getText(),"",password.getText(),"");
	    	
	    	voter.login();
	    	
	    }

	    @FXML
	    void signup(ActionEvent event) throws IOException 
	    {
	    	

	    	Main m=new Main();
	        m.changeScene("SignUp.fxml","SignUp");
//	    	Stage votingproc=new Stage();
//			Parent root=FXMLLoader.load(getClass().getResource("SignUp.fxml"));
//
//			Scene scene=new Scene(root);
//			votingproc.setScene(scene);
//			votingproc.show();
//			votingproc.setResizable(false);
//
//			votingproc.setTitle("SignUp");
			

	    }

}
