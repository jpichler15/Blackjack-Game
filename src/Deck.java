import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Collections;
import java.util.LinkedList;
public class Deck<E> {
	LinkedList<E> Deck = new LinkedList<E>();
	public Deck(){
		
	}
	public Deck(LinkedList<E>Deck){
		this.Deck=Deck;
	}
	public void addCard(E item){
		Deck.add(item);
	}
	public E getCard(int index){
		return Deck.get(index);
	}
	public void shuffleDeck(){
		Collections.shuffle(Deck);
	}
}
