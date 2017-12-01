import java.awt.image.ImageFilter;
import java.util.function.UnaryOperator;

import javax.swing.JFormattedTextField;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class betWindow {
	Player gamePlayer;
	Stage gameStage;
	Pane pane;
	Button bet;
	Button hit;
	Button stay;
	public int value;
	public betWindow(Player gamePlayer,Stage gameStage,Pane pane,Button stay,Button hit){
		this.gamePlayer=gamePlayer;
		this.gameStage=gameStage;
		this.pane=pane;
		this.stay=stay;
		this.hit=hit;
	}
	public void Display(){
		Stage primaryStage = new Stage();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.getStyleClass().add("backGroundColorOW");
		//Defining the Name text field
		 	TextField integerField = new TextField();
	        UnaryOperator<Change> integerFilter = change -> {
	            String newText = change.getControlNewText();
	            if (newText.matches("-?([1-9][0-9]*)?")) { 
	                return change;
	            } else if ("-".equals(change.getText()) ) {
	                if (change.getControlText().startsWith("-")) {
	                    change.setText("");
	                    change.setRange(0, 1);
	                    change.setCaretPosition(change.getCaretPosition()-2);
	                    change.setAnchor(change.getAnchor()-2);
	                    return change ;
	                } else {
	                    change.setRange(0, 0);
	                    return change ;
	                }
	            }
	            return null;
	        };
	        //looked this up, but then I learned it on my own, it prevents the user from being able to enter anything but numbers and decimals
	        // modified version of standard converter that evaluates an empty string 
	        // as zero instead of null:
	        StringConverter<Integer> converter = new IntegerStringConverter() {
	            @Override
	            public Integer fromString(String s) {
	                if (s.isEmpty()) return 0 ;
	                return super.fromString(s);
	            }
	        };

	        TextFormatter<Integer> textFormatter = 
	                new TextFormatter<Integer>(converter, 0, integerFilter);
	        integerField.setTextFormatter(textFormatter);

	     // demo listener:
	    textFormatter.valueProperty().addListener((obs, oldValue, newValue) -> System.out.println(newValue));
		integerField.setPromptText("Enter a bet");
		integerField.setPrefColumnCount(10);
		GridPane.setConstraints(integerField, 0, 0);
		grid.getChildren().add(integerField);
		//Defining the Submit button
		Button submit = new Button("Submit");
		submit.getStyleClass().add("submitButton");
		GridPane.setConstraints(submit, 1, 0);
		grid.getChildren().add(submit);
		
		
      	 
		
		submit.setOnAction(new EventHandler<ActionEvent>(){
	           @Override      
	           public void handle(ActionEvent event) {
	        	   		
	        	   	
	        	   		
	        	   
	        	   		if(integerField.getText() == null||integerField.getText().trim().isEmpty()){
	        	   			Text direction4 = new Text("You must enter a valid bet");
	       		    		direction4.setFill(Color.BLACK);
	       		    		direction4.setFont(Font.font(java.awt.Font.SANS_SERIF, 15));
	       		    		grid.add(direction4, 0, 5);
	        	   		}else{
	        	   			value = Integer.parseInt(integerField.getText());
	        	   			if(value>=0&&gamePlayer.Money>=value){
	        	   				gamePlayer.Money=gamePlayer.Money-value;
	        	   				primaryStage.close();
	        	   				gameStage.close();
	        	   				SecondTableDriver second = new SecondTableDriver(gamePlayer,value);
								second.Display();
								second.loadDeck();
								second.play();
	        	   			}else{
	        	   				Text direction4 = new Text("You must enter a valid bet");
		       		    		direction4.setFill(Color.BLACK);
		       		    		direction4.setFont(Font.font(java.awt.Font.SANS_SERIF, 15));
		       		    		grid.add(direction4, 0, 5);
	        	   			}
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
	        	  integerField.clear();
	        	  value = 0;
	            }
	        });
		Text directions = new Text("Enter a bet");
		Text directions2 = new Text("			Submit to play hand");
		Text directions3 = new Text("			Clear to clear the bet field ");
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
