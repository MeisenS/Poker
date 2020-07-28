
public class Deck {
	public int num;
	public Card[] deck;
	
	public Deck(int num) {
		this.num=num;
		this.deck=new Card[num];
		
		String rank[]= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		for(int i=0;i<deck.length;i++) {
			if(i<=12) {
				deck[i]=new Card("Diamond","",i+1);
			}else if(i<=25) {
				deck[i]=new Card("Heart","",i-12);
			}else if(i<=38) {
				deck[i]=new Card("Spade","",i-25);
			}else if(i<=51) {
				deck[i]=new Card("Club","",i-38);
			}
		}
		for(int i=0;i<rank.length;i++) {
			for(int j=0;j<=3;j++) {
				deck[(i+13*j)].setRank(rank[i]);
			}
		}
		
	}                                                              //constructors
		public void setNum(int num) {
			this.num=num;
		} 
		public void setDeck(int num) {
			this.num=num;
		}                                                         //setters  
		
		public int getNum() {
			return num;
		}
		public Card[] getDeck() {
			return deck;
		}                                                          //getter
}	 
