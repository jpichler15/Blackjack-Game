import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.Random;
public class TableDriver {
	Player gamePlayer;
	int keepPlaying=1;

	public TableDriver(Player gamePlayer) {
		this.gamePlayer=gamePlayer;
		
	}
	public void Display(){
			Stage gameStage = new Stage();
			gameStage.setTitle("BlackJackGame");
		if(gamePlayer.Money>=1&&keepPlaying==1){
			Pane yeah = new Pane();
        	Scene scene = new Scene(yeah,800,700);
        	scene.getStylesheets().add("stylesheet.css");
        	yeah.getStyleClass().add("backGroundImage");
        	Text playerMoney = new Text(gamePlayer.getName() + " has: $" + gamePlayer.Money);
	    	playerMoney.setFill(Color.BLACK);
	    	playerMoney.setFont(Font.font(java.awt.Font.SANS_SERIF, 20));
	    	Text directions = new Text("Hit bet to Play");
	    	directions.setFill(Color.BLACK);
	    	directions.setFont(Font.font(java.awt.Font.SANS_SERIF, 20));
        	Button bet = new Button("Bet");
        	Button hit = new Button("Hit");
        	Button quit = new Button("Quit");
        	Button stay = new Button("Stay");
        	bet.setLayoutX(50);
        	bet.setLayoutY(575);
        	hit.setLayoutX(250);
        	hit.setLayoutY(575);
        	quit.setLayoutX(650);
        	quit.setLayoutY(575);
        	stay.setLayoutX(450);
        	stay.setLayoutY(575);
        	playerMoney.setLayoutX(50);
        	playerMoney.setLayoutY(525);
        	directions.setLayoutX(600);
        	directions.setLayoutY(525);
        	hit.getStyleClass().add("hitButton");
        	bet.getStyleClass().add("betButton");
        	quit.getStyleClass().add("quitButton");
        	stay.getStyleClass().add("stayButton");
        	yeah.getChildren().add(bet);
        	yeah.getChildren().add(hit);
        	yeah.getChildren().add(quit);
        	yeah.getChildren().add(stay);
        	yeah.getChildren().add(playerMoney);
        	yeah.getChildren().add(directions);
        	gameStage.setScene(scene);
        	quit.setOnAction(new EventHandler<ActionEvent>() {
 	           @Override      
 	           public void handle(ActionEvent event) {
 	        	   gameQuitWindow quit = new gameQuitWindow();
					quit.Display(gameStage, gamePlayer);
				
 	           }  
        	});
        		bet.setOnAction(new EventHandler<ActionEvent>() {
        		@Override      
  	           		public void handle(ActionEvent event) {
  	        	   		yeah.getChildren().remove(directions);
  	        	   		betWindow placeBet = new betWindow(gamePlayer,gameStage,yeah,stay,hit);
  	        	   		placeBet.Display();
  	        	   		
  	        	   	
  	           		}  
  	           
        		});
        		
        	gameStage.show();
		}else{
			gameStage.close();
		}
	}

	
}
