
public class Drive {
	
	public static void main(String[] args) {
		Functions s=new Functions();
		Deck pok=new Deck(52);
		Card[] deck=pok.getDeck();
		Card[] hand1=new Card[5];
		Card[] hand2=new Card[5];
		for(int i=0;i<hand1.length;i++) {
			hand1[i]=new Card("","",0);
			hand2[i]=new Card("","",0);
		}
		                                                            //initialize all local variables
		System.out.println("the in-order deck: ");
		s.printCards(deck);
		System.out.println();
		                                                            //print the in-order deck
		System.out.println("after shuffle: ");
		s.shuffle(deck);
		s.printCards(deck);
		System.out.println();
		                                                            //print the after-shuffle deck
		s.twohands(hand1,hand2,deck);
		s.sort(hand1);
		s.sort(hand2);
		                                                            //generate two hands of cards and then sort them
		System.out.println();
		System.out.println("after sorting, the two hands are: ");
		System.out.print("hand#1: ");
		s.printCards(hand1);
		System.out.print("hand#2: ");
		s.printCards(hand2);
		                                                            //print out the result of sorting
		
		System.out.println();
		System.out.println("the category of hand#1 is "+s.out(s.classify(hand1)[0]));
		System.out.println("the category of hand#2 is "+s.out(s.classify(hand2)[0]));
		System.out.println();
                                                                   //identify the category of the two hands
		s.compare(hand1, hand2);
		System.out.println();
		                                                           //print out the result of comparison
	}	                                            
}
