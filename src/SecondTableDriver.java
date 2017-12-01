import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.Random;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
public class SecondTableDriver {
	public Deck<Card> theDeck = new Deck<Card>();
	public Player gamePlayer;
	int value;
	public Pane yeah = new Pane();
	public Button hit = new Button("Hit");
	public Button stay = new Button("Stay");
	public Scene scene = new Scene(yeah,800,700);
	public Dealer dealer = new Dealer();
	public HBox dealercards = new HBox();
	Stage gameStage = new Stage();
	public SecondTableDriver(Player gamePlayer,int value) {
		this.gamePlayer=gamePlayer;
		this.value=value;
		
	}
	public void Display(){
			gameStage.setTitle("BlackJackGame");
        	scene.getStylesheets().add("stylesheet.css");
        	yeah.getStyleClass().add("backGroundImage");
        	Text playerMoney = new Text(gamePlayer.getName() + " has: $" + gamePlayer.Money);
	    	playerMoney.setFill(Color.BLACK);
	    	playerMoney.setFont(Font.font(java.awt.Font.SANS_SERIF, 20));
        	Button bet = new Button("Bet");
        	Button quit = new Button("Quit");
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
        	hit.getStyleClass().add("hitButton");
        	bet.getStyleClass().add("betButton");
        	quit.getStyleClass().add("quitButton");
        	stay.getStyleClass().add("stayButton");
        	yeah.getChildren().add(bet);
        	yeah.getChildren().add(hit);
        	yeah.getChildren().add(quit);
        	yeah.getChildren().add(stay);
        	yeah.getChildren().add(playerMoney);

        	gameStage.setScene(scene);
        	quit.setOnAction(new EventHandler<ActionEvent>() {
 	           @Override      
 	           public void handle(ActionEvent event) {
 	        	   gameQuitWindow quit = new gameQuitWindow();
					quit.Display(gameStage, gamePlayer);
				
 	           }  
        	});
        	gameStage.show();
		
	}
	public void play(){
		
		for(int i=0;i<2;i++){
   		   gamePlayer.getHand().addCard(theDeck.Draw()); 
   	   	 }
		
		 HBox cards = new HBox();
		 cards.setLayoutX(0);
		 cards.setLayoutY(235);
		 cards.setPrefSize(800, 175);
		 
		 for(int cnt = 0; cnt<2;cnt++){ 
			cards.getChildren().add(new ImageView(gamePlayer.getHand().getCard(cnt).img));
			cards.setAlignment(Pos.CENTER);
		 }
		 yeah.getChildren().add(cards);
		 dealerHand();
		 
		 
		 
		 
		 if(gamePlayer.getHand().getValue()>21){
			gamePlayer.getHand().clearHand();
			gamePlayer.Money=gamePlayer.Money-value;
			nextHandWindow nextHand = new nextHandWindow();
			
			nextHand.Display(gamePlayer,Result("You busted"),gameStage);
			//gameStage.close();
	  	           
		 }else if(gamePlayer.getHand().getValue()<21){
			   Text directions = new Text("Hit stay to stay and hit to get another card");
        	   directions.setFill(Color.BLACK);
        	   directions.setFont(Font.font(java.awt.Font.SANS_SERIF, 20));
        	   directions.setLayoutX(400);
        	   directions.setLayoutY(525);
        	   yeah.getChildren().add(directions);
			 stay.setOnAction(new EventHandler<ActionEvent>() {
	  	           @Override      
	  	           public void handle(ActionEvent event) {
	  	        	     hit.disarm();
	  	        	     do{
	  	        	    	 dealer.getHand().addCard(theDeck.Draw());
	  	        	     }while(dealer.getHand().getValue()<16);
	  	        	     dealercards.getChildren().remove(1);
	  	        	     dealercards.getChildren().remove(0);
	  	        	     for(int dealercard=0;dealercard<dealer.getHand().Hand.size();dealercard++){
	  	        	    	 dealercards.getChildren().add(new ImageView(dealer.getHand().getCard(dealercard).img));
	  	        	     }
	  	        	     if(dealer.dealerHand.getValue()>21){
	  	        	    	 gamePlayer.getHand().clearHand();
	  	        	    	 dealer.getHand().clearHand();
	  	        	    	 gamePlayer.Money = gamePlayer.Money+(value*2);
	 	  	        		 nextHandWindow nextHand = new nextHandWindow();
	 	  	        		 nextHand.Display(gamePlayer,Result("Dealer busted. You win"),gameStage);
	 	  	        		 //gameStage.close();
	  	        	     }else if(dealer.dealerHand.getValue()>gamePlayer.getHand().getValue()){
	  	        	    	 gamePlayer.getHand().clearHand();
	  	        	    	 dealer.getHand().clearHand();
	 	  	        		 nextHandWindow nextHand = new nextHandWindow();
	 	  	        		 nextHand.Display(gamePlayer,Result("Dealer won"),gameStage);
	 	  	        		 //gameStage.close();
	  	        	     }else if(dealer.dealerHand.getValue()<gamePlayer.getHand().getValue()){
	  	        	    	 gamePlayer.getHand().clearHand();
	  	        	    	 dealer.getHand().clearHand();
	  	        	    	 gamePlayer.Money = gamePlayer.Money+(value*2);
	 	  	        		 nextHandWindow nextHand = new nextHandWindow();
	 	  	        		 nextHand.Display(gamePlayer,Result("Dealer won"),gameStage);
	 	  	        		 //gameStage.close();
	  	        	     }
	  	        	    
	  	           }  
	  	           
	         	});
			 hit.setOnAction(new EventHandler<ActionEvent>() {
	  	           @Override      
	  	           public void handle(ActionEvent event) {
	  	        	 gamePlayer.getHand().addCard(theDeck.Draw());
	  	        	 cards.getChildren().add(new ImageView(gamePlayer.getHand().getCard(gamePlayer.getHand().Hand.size()-1).img));
	  	        	 cards.setAlignment(Pos.CENTER);
	  	        	 hit.disarm();
	  	        	 if(gamePlayer.getHand().getValue()<21){
	  	        		 hit.arm();
	  	        	 }else if(gamePlayer.getHand().getValue()==21){
	  	        		hit.disarm();
	  	        		gamePlayer.Money=gamePlayer.Money+(value*2);
	  	        		gamePlayer.getHand().clearHand();
	  				 	nextHandWindow nextHand = new nextHandWindow();
	  				 	nextHand.Display(gamePlayer,Result("Blackjack!!!!"),gameStage);
	  				 	//gameStage.close();
	  				 
	  	        	 }else if(gamePlayer.getHand().getValue()>21){
	  	        		 hit.disarm();
	  	        		 gamePlayer.getHand().clearHand();
	  	        		// gamePlayer.Money=gamePlayer.Money-value;
	  	        		 nextHandWindow nextHand = new nextHandWindow();
	  	        		 nextHand.Display(gamePlayer,Result("You busted"),gameStage);
	  	        		 //gameStage.close();
	  	  	  	           
	  	        	 }
	  	           }  
	  	           
	        });
		 }else if(gamePlayer.getHand().getValue()==21){
			 gamePlayer.Money=gamePlayer.Money+(value*2);
			 gamePlayer.getHand().clearHand();
			 nextHandWindow nextHand = new nextHandWindow();
			 nextHand.Display(gamePlayer,Result("BlackJack!!!!"),gameStage);
			 //gameStage.close();
			 
		 }
		 	
			
	}
	public Text Result(String x){
		Text result = new Text(x);
		return result;
	}
	public void dealerHand(){
		
		for(int i=0;i<2;i++){
	   	   dealer.getHand().addCard(theDeck.Draw());; 
	   	}
		
		dealercards.setLayoutX(0);
		dealercards.setLayoutY(55);
		dealercards.setPrefSize(800, 175);
		dealercards.getChildren().add(new ImageView(gamePlayer.getHand().getCard(0).img));
		Image turnedCard = new Image("faceDown.PNG",175,175,true,true);
		dealercards.getChildren().add(new ImageView(turnedCard));
		dealercards.setAlignment(Pos.CENTER);
		yeah.getChildren().add(dealercards);
		
	}
public void loadDeck(){
		
		Card AceSpades = new Card("Spades","Ace",11,"AceSpades.PNG");
		AceSpades.setImage();
		theDeck.addCard(AceSpades);
		
		Card AceDiamond = new Card("Diamond","Ace",11,"AceDiamond.PNG");
		AceDiamond.setImage();
		theDeck.addCard(AceDiamond);
		
		
		Card AceHeart = new Card("Hearts","Ace",11,"AceHearts.PNG");
		AceHeart.setImage();
		theDeck.addCard(AceHeart);
		
		Card AceClub = new Card("Clubs","Ace",11,"AceClub.PNG");
		AceClub.setImage();
		theDeck.addCard(AceClub);
		
		Card KingSpades = new Card("Spades","King",10,"KingSpades.PNG");
		KingSpades.setImage();
		theDeck.addCard(KingSpades);
		
		Card KingDiamond = new Card("Diamond","King",10,"KingDiamond.PNG");
		KingDiamond.setImage();
		theDeck.addCard(KingDiamond);
		
		Card KingClub = new Card("Clubs","King",10,"KingClub.PNG");
		KingClub.setImage();
		theDeck.addCard(KingClub);
		
		Card KingHeart = new Card("Hearts","King",10,"KingHeart.PNG");
		KingHeart.setImage();
		theDeck.addCard(KingHeart);
		
		
		Card QueenSpades = new Card("Spades","Queen",10,"QueenSpades.PNG");
		QueenSpades.setImage();
		theDeck.addCard(QueenSpades);
		
		Card QueenDiamond = new Card("Diamond","Queen",10,"QueenDiamond.PNG");
		QueenDiamond.setImage();
		theDeck.addCard(QueenDiamond);
		
		Card QueenClub = new Card("CLub","Queen",10,"QueenClub.PNG");
		QueenClub.setImage();
		theDeck.addCard(QueenClub);
		
		Card QueenHeart = new Card("Heart","Queen",10,"QueenHeart.PNG");
		QueenHeart.setImage();
		theDeck.addCard(QueenHeart);
		
		Card JackSpades = new Card("Spades","Jack",10,"JackSpades.PNG");
		JackSpades.setImage();
		theDeck.addCard(JackSpades);
		
		Card JackDiamond = new Card("Diamond","Jack",10,"JackDiamond.PNG");
		JackDiamond.setImage();
		theDeck.addCard(JackDiamond);
		
		Card JackClub = new Card("Club","Jack",10,"JackClub.PNG");
		JackClub.setImage();
		theDeck.addCard(JackClub);
		
		Card JackHeart = new Card("Heart","Jack",10,"JackHeart.PNG");
		JackHeart.setImage();
		theDeck.addCard(JackHeart);
		
		Card TenSpades = new Card("Spades","Ten",10,"TenSpades.PNG");
		TenSpades.setImage();
		theDeck.addCard(TenSpades);
		
		Card TenDiamond = new Card("Diamond","Ten",10,"TenDiamond.PNG");
		TenDiamond.setImage();
		theDeck.addCard(TenDiamond);
		
		Card TenClub = new Card("Club","Ten",10,"TenClub.PNG");
		TenClub.setImage();
		theDeck.addCard(TenClub);
		
		Card TenHeart = new Card("Heart","Ten",10,"TenHeart.PNG");
		TenHeart.setImage();
		theDeck.addCard(TenHeart);
		
		Card NineSpades = new Card("Spades","Nine",9,"NineSpades.PNG");
		NineSpades.setImage();
		theDeck.addCard(NineSpades);
		
		Card NineDiamond = new Card("Diamond","Nine",9,"NineDiamond.PNG");
		NineDiamond.setImage();
		theDeck.addCard(NineDiamond);
		
		Card NineClub = new Card("Club","Nine",9,"NineClub.PNG");
		NineClub.setImage();
		theDeck.addCard(NineClub);
		
		Card NineHeart = new Card("Heart","Nine",9,"NineHeart.PNG");
		NineHeart.setImage();
		theDeck.addCard(NineHeart);
		
		Card EightSpades = new Card("Spades","Eight",8,"EightSpades.PNG");
		EightSpades.setImage();
		theDeck.addCard(EightSpades);
		
		Card EightDiamond = new Card("Diamond","Eight",8,"EightDiamond.PNG");
		EightDiamond.setImage();
		theDeck.addCard(EightDiamond);
		
		Card EightClub = new Card("Club","Eight",8,"EightClub.PNG");
		EightClub.setImage();
		theDeck.addCard(EightClub);
		
		Card EightHeart = new Card("Heart","Eight",8,"EightHeart.PNG");//
		EightHeart.setImage();
		theDeck.addCard(EightHeart);
		
		Card SevenSpades = new Card("Spades","Seven",7,"SevenSpades.PNG");
		SevenSpades.setImage();
		theDeck.addCard(SevenSpades);
		
		Card SevenDiamond = new Card("Diamond","Seven",7,"SevenDiamond.PNG");
		SevenDiamond.setImage();
		theDeck.addCard(SevenDiamond);
		
		Card SevenClub = new Card("Club","Seven",7,"SevenClub.PNG");
		SevenClub.setImage();
		theDeck.addCard(SevenClub);
		
		Card SevenHeart = new Card("Heart","Seven",7,"SevenHeart.PNG");
		SevenHeart.setImage();
		theDeck.addCard(SevenHeart);
		
		Card SixSpades = new Card("Spades","Six",6,"SixSpades.PNG");
		SixSpades.setImage();
		theDeck.addCard(SixSpades);
		
		Card SixDiamond = new Card("Diamond","Six",6,"SixDiamond.PNG");
		SixDiamond.setImage();
		theDeck.addCard(SixDiamond);
		
		Card SixClub = new Card("Club","Six",6,"SixClub.PNG");
		SixClub.setImage();
		theDeck.addCard(SixClub);
		
		Card SixHeart = new Card("Heart","Six",6,"SixHeart.PNG");
		SixHeart.setImage();
		theDeck.addCard(SixHeart);
		
		Card FiveSpades = new Card("Spades","Five",5,"FiveSpades.PNG");
		FiveSpades.setImage();
		theDeck.addCard(FiveSpades);
		
		Card FiveDiamond = new Card("Diamond","Five",5,"FiveDiamond.PNG");
		FiveDiamond.setImage();
		theDeck.addCard(FiveDiamond);
		
		Card FiveClub = new Card("Club","Five",5,"FiveClub.PNG");
		FiveClub.setImage();
		theDeck.addCard(FiveClub);
		
		Card FiveHeart = new Card("Heart","Five",5,"FiveHeart.PNG");
		FiveHeart.setImage();
		theDeck.addCard(FiveHeart);
		
		Card FourSpades = new Card("Spades","Four",4,"FourSpades.PNG");
		FourSpades.setImage();
		theDeck.addCard(FourSpades);
		
		Card FourDiamond = new Card("Diamond","Four",4,"FourDiamond.PNG");
		FourDiamond.setImage();
		theDeck.addCard(FourDiamond);
		
		Card FourClub = new Card("Club","Four",4,"FourClub.PNG");
		FourClub.setImage();
		theDeck.addCard(FourClub);
		
		Card FourHeart = new Card("Heart","Four",4,"FourHeart.PNG");
		FourHeart.setImage();
		theDeck.addCard(FourHeart);
		
		Card ThreeSpades = new Card("Spades","Three",3,"ThreeSpades.PNG");
		ThreeSpades.setImage();
		theDeck.addCard(ThreeSpades);
		
		Card ThreeDiamond = new Card("Diamond","Three",3,"ThreeDiamond.PNG");
		ThreeDiamond.setImage();
		theDeck.addCard(ThreeDiamond);
		
		Card ThreeClub = new Card("Club","Three",3,"ThreeClub.PNG");
		ThreeClub.setImage();
		theDeck.addCard(ThreeClub);
		
		Card ThreeHeart = new Card("Heart","Three",3,"ThreeHeart.PNG");
		ThreeHeart.setImage();
		theDeck.addCard(ThreeHeart);
		
		Card TwoSpades = new Card("Spades","Two",2,"TwoSpades.PNG");
		TwoSpades.setImage();
		theDeck.addCard(TwoSpades);
		
		Card TwoDiamond = new Card("Diamond","Two",2,"TwoDiamond.PNG");
		TwoDiamond.setImage();
		theDeck.addCard(TwoDiamond);
		
		Card TwoClub = new Card("Club","Two",2,"TwoClub.PNG");
		TwoClub.setImage();
		theDeck.addCard(TwoClub);
		
		Card TwoHeart = new Card("Heart","Two",2,"TwoHeart.PNG");
		TwoHeart.setImage();
		theDeck.addCard(TwoHeart);
		
	}//value of 10 not displaying

	
}
