/*
 * package application;
 * 
 * import java.io.IOException; import java.net.URL; import java.sql.Connection;
 * import java.sql.PreparedStatement; import java.sql.SQLException; import
 * java.util.ResourceBundle;
 * 
 * import connectiondb.dbhandler; import javafx.collections.FXCollections;
 * import javafx.collections.ObservableList; import javafx.event.ActionEvent;
 * import javafx.fxml.FXML; import javafx.fxml.FXMLLoader; import
 * javafx.fxml.Initializable; import javafx.scene.Parent; import
 * javafx.scene.Scene; import javafx.scene.control.Button; import
 * javafx.scene.control.ComboBox; import javafx.stage.Stage;
 * 
 * public class CastingVote implements Initializable {
 * 
 * private Connection connection; private PreparedStatement pst; private
 * dbhandler handler=new dbhandler();
 * 
 * @FXML private Button bat;
 * 
 * @FXML private Button lion;
 * 
 * @FXML private Button kite;
 * 
 * @FXML private Button arrow;
 * 
 * @FXML private ComboBox<String> combobox;
 * 
 * @FXML void arrow(ActionEvent event) throws IOException {
 * 
 * System.out.println("Voted"); String
 * update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Arrow'";
 * 
 * connection = handler.getConnection(); try {
 * pst=connection.prepareStatement(update); }catch (SQLException e) {
 * e.printStackTrace(); }
 * 
 * try {
 * 
 * 
 * pst.executeUpdate();
 * 
 * }catch(SQLException e) { e.printStackTrace(); }
 * 
 * 
 * Stage votingproc=new Stage(); Parent
 * root=FXMLLoader.load(getClass().getResource("Voted.fxml"));
 * 
 * Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
 * votingproc.setResizable(false);
 * 
 * votingproc.setTitle("Vote Done");
 * 
 * }
 * 
 * @FXML void bat(ActionEvent event) throws IOException {
 * System.out.println("Voted"); String
 * update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Bat'";
 * 
 * connection = handler.getConnection(); try {
 * pst=connection.prepareStatement(update); }catch (SQLException e) {
 * e.printStackTrace(); }
 * 
 * try {
 * 
 * 
 * pst.executeUpdate();
 * 
 * }catch(SQLException e) { e.printStackTrace(); }
 * 
 * Stage votingproc=new Stage(); Parent
 * root=FXMLLoader.load(getClass().getResource("Voted.fxml"));
 * 
 * Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
 * votingproc.setResizable(false);
 * 
 * votingproc.setTitle("Vote Done");
 * 
 * }
 * 
 * @FXML void kite(ActionEvent event) throws IOException {
 * System.out.println("Voted"); String
 * update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Kite'";
 * 
 * connection = handler.getConnection(); try {
 * pst=connection.prepareStatement(update); }catch (SQLException e) {
 * e.printStackTrace(); }
 * 
 * try {
 * 
 * 
 * pst.executeUpdate();
 * 
 * }catch(SQLException e) { e.printStackTrace(); }
 * 
 * Stage votingproc=new Stage(); Parent
 * root=FXMLLoader.load(getClass().getResource("Voted.fxml"));
 * 
 * Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
 * votingproc.setResizable(false);
 * 
 * votingproc.setTitle("Vote Done");
 * 
 * }
 * 
 * @FXML void lion(ActionEvent event) throws IOException {
 * 
 * System.out.println("Voted"); String
 * update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE symbol='Lion'";
 * 
 * connection = handler.getConnection(); try {
 * pst=connection.prepareStatement(update); }catch (SQLException e) {
 * e.printStackTrace(); }
 * 
 * try {
 * 
 * 
 * pst.executeUpdate();
 * 
 * }catch(SQLException e) { e.printStackTrace(); }
 * 
 * Stage votingproc=new Stage(); Parent
 * root=FXMLLoader.load(getClass().getResource("Voted.fxml"));
 * 
 * Scene scene=new Scene(root); votingproc.setScene(scene); votingproc.show();
 * votingproc.setResizable(false);
 * 
 * votingproc.setTitle("Vote Done");
 * 
 * 
 * }
 * 
 * 
 * @FXML void combobox(ActionEvent event) {
 * 
 * 
 * 
 * combobox.getSelectionModel().getSelectedItem().toString();
 * 
 * }
 * 
 * 
 * @Override public void initialize(URL arg0, ResourceBundle arg1) {
 * ObservableList<String> list =
 * FXCollections.observableArrayList("Saddar","Marrir Chowk","Liaquat Bagh"
 * ,"Committee Chowk","Waris Khan","Chandni Chawk",
 * "Rehamnabad","6th Road","Shamsabad","Faizabad","IJP","Pothohar",
 * "Khayaban-e-Johar","Faiz Ahmed Faiz","Kashmir Highway","Chaman","Ibn-e-Sina",
 * "Katchery","PIMS","Stock Exchange","7th Avenue"
 * ,"Shaheed-e-Milat","Parade Ground","Pak Secretariat");
 * combobox.setItems(list); }
 * 
 * }
 */

package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connectiondb.dbhandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CastingVote implements Initializable {

	private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();
	 Voter V;
	 
private String s;
	 
    @FXML
    private ComboBox<String> combobox;
    
    

    @FXML
    void combobox(ActionEvent event) {
    	
    	   s=combobox.getSelectionModel().getSelectedItem().toString();
    	  
    	  }
    	 
    	  
    	  @Override 
    	  public void initialize(URL arg0, ResourceBundle arg1) {
    		  int count=0;
    		  try {
  	       		connection=handler.getConnection();
  	           	String result="SELECT * FROM candidates WHERE approval=1";
  	           	pst = connection.prepareStatement(result);
  	           	
  	          ResultSet rss=pst.executeQuery();
  	        		 while (rss.next()) {
  	          count++;
  	        } 
				
    		  }catch(Exception e)
  	       	{
  	       		System.out.println(e);
  	       	}
	           	String[] ar=new String[count];
    		  try {
    	       		connection=handler.getConnection();
    	           	String results="SELECT candidatename FROM candidates WHERE approval = 1 ";
    	           	pst = connection.prepareStatement(results);
    	           	
    	           	ResultSet rs=pst.executeQuery();
    	           	int i=0;
    	           	while (rs.next())
    	    		{
    	           		System.out.println("\n"  + rs.getString(1) );
        	    		
    	           		String var=rs.getString(1);
    	           		ar[i]=var;
    	           		
        	    		
    	    		
    	           		i++;
    	           		
    	    		}
    	    		
    	        	
	           		ObservableList<String> list =
	           	    	  FXCollections.observableArrayList(ar);
	           	    	  combobox.setItems(list);
	    			
	        
    	       		pst.close();	
    	       	}catch(Exception e)
    	       	{
    	       		System.out.println(e);
    	       	}
    	       	
    		
    	
    		  
    		  
    		  
    		  }
    	  
    	    @FXML
    	    void vote(ActionEvent event) throws IOException {
    	    	
    	  	  V=new Voter("","","","","");
       			V.castvote(s);
       			
       			

    	    	Main m=new Main();
                m.changeScene("votingProcedure.fxml","Voter Options");
//       			Stage votingproc=new Stage();
//     		   	Parent root=FXMLLoader.load(getClass().getResource("votingProcedure.fxml"));
//
//     		   	Scene scene=new Scene(root);
//     		   	votingproc.setScene(scene);
//     		   	votingproc.show();
//     		   	votingproc.setResizable(false);
//
//     		   	votingproc.setTitle("Voter Options");
   			 
    	    }
    		  
    	  
    	  }
    	  



