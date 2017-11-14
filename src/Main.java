import javafx.*;
import java.util.*;
import java.io.*;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage Stage) throws Exception { 
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Opening Window");
	        Button btn = new Button();
	        btn.setText("Click if you would like to enter the game");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	           @Override
	            public void handle(ActionEvent event) {
	                primaryStage.close();
	                Stage gameStage = new Stage();
	                gameStage.setTitle("BlackJackGame");
	                StackPane yeah = new StackPane();
	                Image img = new Image("images.PNG");
	                BackgroundImage bgImg = new BackgroundImage(img, 
	                		BackgroundRepeat.NO_REPEAT, 
	                		BackgroundRepeat.NO_REPEAT,
	                		BackgroundPosition.DEFAULT, 
	                		new BackgroundSize(800, 
	                		700, false, false, true, false));
	                Background newBackground = new Background(bgImg);
	                yeah.setBackground(newBackground);
	                Scene scene = new Scene(yeah,800,700);
	                gameStage.setScene(scene);
	                
	                gameStage.show();
	                
	            }
	        });
	        
	        StackPane root = new StackPane();
	        root.getChildren().add(btn);
	        primaryStage.setScene(new Scene(root, 300, 250));
	        primaryStage.show();
		
		
	}
	public static void loadDeck(){
		Deck<Card> theDeck = new Deck<Card>();
		Card AceSpades = new Card("Spades","Ace",11,"AceSpades.PNG");
		theDeck.addCard(AceSpades);
		Card AceDiamond = new Card("Diamond","Ace",11,"AceDiamonds.PNG");
		theDeck.addCard(AceDiamond);
		Card AceHeart = new Card("Hearts","Ace",11,"AceHearts.PNG");
		theDeck.addCard(AceHeart);
		Card AceClub = new Card("Clubs","Ace",11,"AceClubs.PNG");
		theDeck.addCard(AceClub);
		Card KingSpades = new Card("Spades","King",10,"KingSpades.PNG");
		theDeck.addCard(KingSpades);
		Card KingDiamond = new Card("Diamond","King",10,"KingDiamond.PNG");
		theDeck.addCard(KingDiamond);
		Card KingClub = new Card("Clubs","King",10,"KingClubs.PNG");
		theDeck.addCard(KingClub);
		Card KingHeart = new Card("Hearts","King",10,"KingHearts.PNG");
		theDeck.addCard(KingHeart);
		
	}


	
}
