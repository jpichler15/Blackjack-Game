
public class Player {
	Hand playerHand = new Hand();
	String Name;
	int Money=500;
	public Player(){
		
	}
	public Player(Hand playerHand){
		this.playerHand=playerHand;
	}
	public Hand getHand(){
		return playerHand;
	}
	public void setHand(Hand playerHand){
		this.playerHand=playerHand;
	}
	public void bet(){
		Money = Money -10;
	}
	public void addBet(int x){
		Money = Money-x;
	}
	public String getName(){
		return Name;
	}
	public void gainMoney(int x){
		Money = Money +x;
	}
	public void setName(String Name){
		this.Name=Name;
	}
	
}
