
public class Card {
	private String suit;
	private String rank;
	private int value;                                      //local variables
	
	public Card(String suit,String rank,int value) {
		this.suit=suit;
		this.rank=rank;
		this.value=value;
	}                                                       //constructors              
		public void setValue(int value) {
			this.value=value;
		}
		public void setSuit(String suit) {
			this.suit=suit;
		}
		public void setRank(String rank) {
			this.rank=rank;
		}                                                   //setters
		
		public String getSuit() {
			return suit;
		}
		public String getRank() {
			return rank;
		}
		public int getValue() {
			return value;
		}                                                   //getters
	public String toString() {
		return suit+rank;
	}                                                       //override toString
}
