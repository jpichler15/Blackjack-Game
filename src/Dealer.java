
public class Dealer {
	Hand dealerHand = new Hand();
	public Dealer(){
		
	}
	public Dealer(Hand dealerHand){
		this.dealerHand=dealerHand;
	}
	public Hand getHand(){
		return dealerHand;
	}
	public void setHand(Hand playerHand){
		this.dealerHand=playerHand;
	}
	
}

