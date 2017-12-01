import java.util.*;
import java.io.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Hand {
	int totalCards =0;
	ArrayList<Card> Hand = new ArrayList<>();
	public Hand(){
		
	}
	public void addCard(Card x){
		Hand.add(x);
		totalCards++;
	}
	public void clearHand(){
		Hand.clear();
	}
	public void displayPlayerHand(Stage gameStage){
		
	}
	public void displayDealerHand(Stage gameStage){
		
	}
	public Card getCard(int index){
		return Hand.get(index);
	}
	public int getValue(){
		int value=0;
		for(int i=0;i<Hand.size();i++){
			value+= Hand.get(i).getValue();
		}
		return value;
	}
	
}
