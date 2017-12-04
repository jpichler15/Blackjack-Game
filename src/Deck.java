import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Collections;
public class Deck<E> {
	private LinkedList<E> theDeck = new LinkedList<E>();
	public Deck(){
		
	}
	public Deck(LinkedList<E>Deck){
		this.theDeck=Deck;
	}
	public void addCard(E item){
		theDeck.add(item);
	}
	public E getCard(int index){
		return theDeck.get(index);
	}
	public void shuffleDeck(){
		Collections.shuffle(theDeck);
	}
	public E Draw(){
		Random ran = new Random();
		int random = ran.nextInt(theDeck.size());
		E x = theDeck.remove(random);
		//size--;
		return x;
		
	}
}
