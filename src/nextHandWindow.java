import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class nextHandWindow {
	public void Display(Player gamePlayer,Text result,Stage oldStage){
		Stage quitStage = new Stage();
		quitStage.setTitle("Play Next Hand");
		Pane yeah = new Pane();
    	Scene scene = new Scene(yeah,500,500);
    	scene.getStylesheets().add("stylesheet.css");
    	Text directions = new Text("Would you like to Play another Hand");
    	directions.setFill(Color.BLACK);
    	directions.setFont(Font.font(java.awt.Font.SANS_SERIF, 20));
    	Button yes = new Button("Yes");
    	Button no = new Button("No");
    	result.setLayoutX(205);
    	result.setLayoutY(100);
    	yes.setLayoutX(100);
    	yes.setLayoutY(250);
    	no.setLayoutX(300);
    	no.setLayoutY(250);
    	directions.setLayoutX(105);
    	directions.setLayoutY(175);
    	yes.getStyleClass().add("yesButton");
    	no.getStyleClass().add("noButton");
    	yeah.getChildren().add(yes);
    	yeah.getChildren().add(no);
    	yeah.getChildren().add(directions);
    	yeah.getChildren().add(result);
    	quitStage.setScene(scene);
    	yes.setOnAction(new EventHandler<ActionEvent>() {
	           @Override      
	           public void handle(ActionEvent event) {
	        	   //going to access highscore sheet load into arraylist and then if the score/money is bigger than the any of the scores place it on the highscore sheet at the correct spot
	        	   oldStage.close();
	        	   quitStage.close();
  	        	   TableDriver newDriver = new TableDriver(gamePlayer);
  	        	   newDriver.Display();
	        	   
	          }  
	    });
    	no.setOnAction(new EventHandler<ActionEvent>() {
	           @Override      
	           public void handle(ActionEvent event) {
	        	   //going to access highscore sheet load into arraylist and then if the score/money is bigger than the any of the scores place it on the highscore sheet at the correct spot
	        	   oldStage.close();
	        	   quitStage.close();
	        	   System.out.println(gamePlayer.Name+" : "+ gamePlayer.Money);
	          }  
	    });
    	quitStage.show();
	}
}
