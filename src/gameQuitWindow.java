import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;

public class gameQuitWindow {
	public gameQuitWindow(){
	
	}
	public void Display(Stage gameStage, Player gamePlayer){
		Stage quitStage = new Stage();
		quitStage.setTitle("QuitWindow");
		Pane yeah = new Pane();
    	Scene scene = new Scene(yeah,500,500);
    	scene.getStylesheets().add("stylesheet.css");
    	Text directions = new Text("Press yes to quit, or no not to go back to the game:");
    	directions.setFill(Color.BLACK);
    	directions.setFont(Font.font(java.awt.Font.SANS_SERIF, 20));
    	Button yes = new Button("Yes");
    	Button no = new Button("No");
    	yes.setLayoutX(100);
    	yes.setLayoutY(250);
    	no.setLayoutX(300);
    	no.setLayoutY(250);
    	directions.setLayoutX(25);
    	directions.setLayoutY(100);
    	yes.getStyleClass().add("yesButton");
    	no.getStyleClass().add("noButton");
    	yeah.getChildren().add(yes);
    	yeah.getChildren().add(no);
    	yeah.getChildren().add(directions);
    	quitStage.setScene(scene);
    	yes.setOnAction(new EventHandler<ActionEvent>() {
	           @Override      
	           public void handle(ActionEvent event) {
	        	   //going to access highscore sheet load into arraylist and then if the score/money is bigger than the any of the scores place it on the highscore sheet at the correct spot
	        	   quitStage.close();
	        	   gameStage.close();
	        	   System.out.println(gamePlayer.getName() + " : "+gamePlayer.Money);
	        	   
	          }  
	    });
    	no.setOnAction(new EventHandler<ActionEvent>() {
	           @Override      
	           public void handle(ActionEvent event) {
	        	   //going to access highscore sheet load into arraylist and then if the score/money is bigger than the any of the scores place it on the highscore sheet at the correct spot
	        	   quitStage.close();
	        	   gameStage.show();
	        	   
	          }  
	    });
    	quitStage.show();
	}
}
