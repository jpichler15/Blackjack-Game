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
	ArrayList<Card> theHand = new ArrayList<>();
	public Hand(){
		
	}
	public void addCard(Card x){
		theHand.add(x);
		totalCards++;
	}
	public void clearHand(){
		theHand.clear();
	}
	public void displayPlayerHand(Stage gameStage){
		
	}
	public void displayDealerHand(Stage gameStage){
		
	}
	public Card getCard(int index){
		return theHand.get(index);
	}
	public boolean containsAce(){
		boolean x = false;
		for(int i = 0;i<theHand.size();i++){
			if(theHand.get(i).getValue()==11){
				x=true;
			}
		}
		return x;
	}
	public void setAce(){
		for(int i = 0;i<theHand.size();i++){
			if(theHand.get(i).getValue()==11){
				theHand.get(i).setValue(1);
				break;
			}
		}
	}
	public int getValue(){
		int value=0;
		for(int i=0;i<theHand.size();i++){
			value=value+ getCard(i).getValue();
		}
		return value;
	}
	
}
