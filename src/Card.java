import javafx.*;
import javafx.scene.image.Image;
public class Card {
	String Suit;
	String Name;
	int Value;
	String imageName;
	Image img = new Image(imageName);
	
	public Card(){
		
	}
	public Card(String Suit,String Name, int Value,String imageName){
		this.Name=Name;
		this.Suit=Suit;
		this.Value=Value;
		this.imageName=imageName;
		
	}
	public void setValue(int Value){
		this.Value=Value; 
	}
	public void setimageName(String imageName){
		this.imageName=imageName;
	}
	public int getValue(){
		return Value;
	}
	public void setName(String Name){
		this.Name=Name;
	}
	public String getName(){
		return Name;
	}
	public void setSuit(String Suit){
		this.Suit=Suit;
	}
	public String getSuit(){
		return Suit;
	}
	public Image getImage(){
		return img;
	}
}
