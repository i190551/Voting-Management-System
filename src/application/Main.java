package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage stg;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("Choice.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			stg=primaryStage;
			primaryStage.setTitle("Electronic Voting");
			
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void changeScene(String fxml,String title) throws IOException {
		  
		  
		  BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
		  Scene scene = new Scene(root,700,500);
		  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
		  stg.setScene(scene); 
		  stg.show(); 
		  stg.setTitle(title);
		  }
	
	
}
