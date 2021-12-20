package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginPageAdmin {
	

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
    private TextField adminusername;

    @FXML
    private PasswordField adminpassword;

    @FXML
    void LoginAdmin(ActionEvent event) throws IOException {
    	
    	if((adminusername.getText()).equals("usama")&&(adminpassword.getText()).equals("uk1234"))
    	{
    	Administrator administrator = new Administrator("");
		administrator.loginadmin();
	

    }
    	
    
    	else
    	{
    		
    		showAlert1(Alert.AlertType.ERROR,null, "Error",
                "Invalid Username or Password!");
    		
    		try {

    		throw new InvalidAdminCredentialsException();
    		}catch(InvalidAdminCredentialsException e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
}
