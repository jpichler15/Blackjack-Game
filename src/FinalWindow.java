import javax.swing.SwingConstants;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FinalWindow {
	Player gamePlayer;
	public FinalWindow(Player gamePlayer){
		this.gamePlayer=gamePlayer;
	}
	public void display(){
		Stage closing = new Stage();
		Pane yeah = new Pane();
		Scene scene = new Scene(yeah,250,250);
		Button close = new Button("Close");
		scene.getStylesheets().add("stylesheet.css");
		close.getStyleClass().add("closeButton");
		close.setLayoutY(150);
		close.setLayoutX(45);
		close.setAlignment(Pos.CENTER);
		Text score = new Text("You earned: $" + gamePlayer.Money);
		score.setLayoutX(50);
		score.setLayoutY(100);
		score.setTextAlignment(TextAlignment.CENTER);
		score.setFill(Color.BLACK);
    	score.setFont(Font.font(java.awt.Font.SANS_SERIF, 20));
    	yeah.getChildren().add(close);
    	yeah.getChildren().add(score);
    	close.setOnAction(new EventHandler<ActionEvent>() {
	           @Override      
	           public void handle(ActionEvent event) {
	        	  closing.close();
				
	           }  
     	});
    	closing.setScene(scene);
    	closing.show();
	}
}
