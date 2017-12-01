import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OpeningWindow {
	
	public OpeningWindow() {
		
	}
	public void Display() {
		
		
		Stage primaryStage = new Stage();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.getStyleClass().add("backGroundColorOW");
		//Defining the Name text field
		final TextField name = new TextField();
		name.setPromptText("Enter your first name and last name.");
		name.setPrefColumnCount(10);
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name);
		//Defining the Submit button
		Button submit = new Button("Submit");
		submit.getStyleClass().add("submitButton");
		GridPane.setConstraints(submit, 1, 0);
		grid.getChildren().add(submit);
		
		
      	 
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
	           @Override      
	           public void handle(ActionEvent event) {
	        	   
	        	   		if (name.getText() == null || name.getText().trim().isEmpty()) {
	        	   			Text direction4 = new Text("You must enter a name");
	       		    		direction4.setFill(Color.BLACK);
	       		    		direction4.setFont(Font.font(java.awt.Font.SANS_SERIF, 15));
	       		    		grid.add(direction4, 0, 5);
	        	   		}else{
	        	   
	        				Player gamePlayer = new Player();
	        				gamePlayer.setName(name.getText());
	        				primaryStage.close();
	        				TableDriver driver = new TableDriver(gamePlayer);
	        				driver.Display();
	        	   		}	
	        		  
	        }  
	    });
		
		//Defining the Clear button
		Button clear = new Button("Clear");
		clear.getStyleClass().add("clearButton");
		GridPane.setConstraints(clear, 1, 1);
		grid.getChildren().add(clear);
		clear.setOnAction(new EventHandler<ActionEvent>() {
			 
	           @Override
	            public void handle(ActionEvent event) {
	        	  name.clear();
	            }
	        });
		Text directions = new Text("Enter your first and last name         ");
		Text directions2 = new Text("Submit to enter the game");
		Text directions3 = new Text("Clear to clear the name field");
		directions.setFill(Color.BLACK);
		directions.setFont(Font.font(java.awt.Font.SANS_SERIF, 15));
		directions2.setFill(Color.BLACK);
		directions2.setFont(Font.font(java.awt.Font.SANS_SERIF, 15));
		directions3.setFill(Color.BLACK);
		directions3.setFont(Font.font(java.awt.Font.SANS_SERIF, 15));
		grid.add(directions, 0, 1);
		grid.add(directions2, 3, 0);
		grid.add(directions3, 3, 1);
		Scene scene = new Scene(grid,550,200);
		scene.getStylesheets().add("stylesheet.css");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}

