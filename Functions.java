import java.util.Random;

public class Functions {
	
	public void printCards(Card some[]) {
		for(int i=0;i<some.length;i++) {
			if(i==some.length-1) {
				System.out.print(some[i]);
			}
			else {
				System.out.print(some[i]+" ");
			}
		}
		System.out.println();
	}                                                //print out cards
	
	public void shuffle(Card some[]) {
		Card temp = new Card("","",1);
		Random ranm=new Random();
		int shuf=ranm.nextInt(51)+1;
		                                            
		for(int i=0;i<some.length;i++) {
			temp.setSuit(some[i].getSuit());
			temp.setRank(some[i].getRank());
			temp.setValue(some[i].getValue());
			
			some[i].setRank(some[shuf].getRank());
			some[i].setSuit(some[shuf].getSuit());
			some[i].setValue(some[shuf].getValue());
			
			some[shuf].setRank(temp.getRank());
			some[shuf].setSuit(temp.getSuit());
			some[shuf].setValue(temp.getValue());
			shuf=ranm.nextInt(51)+1;                                    //use random number generator and then switch card positions to shuffle the whole deck
		}
	}
	
	public void twohands(Card[]hand1,Card[] hand2,Card[] some) {
		for(int i=0;i<5;i++) {
			hand1[i].setRank(some[i].getRank());
			hand1[i].setSuit(some[i].getSuit());
			hand1[i].setValue(some[i].getValue());
			
			hand2[i].setRank(some[i+5].getRank());
			hand2[i].setSuit(some[i+5].getSuit());
			hand2[i].setValue(some[i+5].getValue());
			}
		System.out.print("hand#1: ");
		printCards(hand1);
		System.out.print("hand#2: ");
		printCards(hand2);
		System.out.println();
		System.out.println("the remaining deck: ");
		for(int i=0;i<some.length;i++) {
			if(i>9) {
				System.out.print(some[i]+" ");
			}
		}                                                           //since the deck has been completely shuffled, generating two hands of cards just need to draw ten cards from the top
		System.out.println();
	}                        
	
	public void sort(Card[] some) {
		Card temp=new Card("","",0);
		for(int i=0;i<5;i++) {
			for(int j=i;j<5;j++) {
				if(some[i].getValue()>some[j].getValue()) {
					temp.setSuit(some[i].getSuit());
					temp.setRank(some[i].getRank());
					temp.setValue(some[i].getValue());
					
					some[i].setRank(some[j].getRank());
					some[i].setSuit(some[j].getSuit());
					some[i].setValue(some[j].getValue());
					
					some[j].setRank(temp.getRank());
					some[j].setSuit(temp.getSuit());
					some[j].setValue(temp.getValue());
	
				}
			}                                                               //use nested for loops to sort cards
		}
	} 
	
	public int[] classify(Card[]some) {
		int suitcounter=0;
		int rankdif1=0;
		int rankdif2=0;
		int rankdif3=0;
		int rankdif4=0;
		int cs=0;
		int hi1=0;
		int hi2=0;
		int hi3=0;
		int hi4=0;
		int hi5=0;                                                //initialize all variables
			 
		for(int i=0;i<5;i++) {
			int counter=0;
			for(int j=i;j<5;j++) {
				if((some[i].getSuit().contentEquals(some[j].getSuit()))) {
				counter++;
				}
			}
			if(counter>suitcounter) {
				suitcounter=counter;
			}else if(suitcounter==counter){
				suitcounter=suitcounter;
			}
		}                                                        //get the max number of appearance of suit
		
		rankdif1=some[1].getValue()-some[0].getValue();
		rankdif2=some[2].getValue()-some[1].getValue();
		rankdif3=some[3].getValue()-some[2].getValue();
		rankdif4=some[4].getValue()-some[3].getValue();         //set four variables as rank difference between adjacent cards
		
		if((suitcounter==5)) {
			if((rankdif1==rankdif2)&&(rankdif2==rankdif3)&&(rankdif3==rankdif4)&&(rankdif4==1)) {
				cs=9;
				hi1=some[4].getValue();
				
			}
			else {
				cs=6;
				hi1=some[4].getValue();
				hi2=some[3].getValue();
				hi3=some[2].getValue();
				hi4=some[1].getValue();
				hi5=some[0].getValue();
			}
		}else if(suitcounter==4) {
			if((rankdif1==rankdif2)&&(rankdif2==rankdif3)&&(rankdif3==rankdif4)&&(rankdif4==1)) {
				cs=5;
				hi1=some[4].getValue();
				
			}else if(rankdif1==0||rankdif2==0||rankdif3==0||rankdif4==0) {
				cs=2;
				if(rankdif1==0) {
					hi1=some[1].getValue();
				}else if(rankdif2==0) {
					hi1=some[2].getValue();
				}else if(rankdif3==0) {
					hi1=some[3].getValue();
				}else if(rankdif4==0) {
					hi1=some[4].getValue();
				}
				
			}else {
				cs=1;
				hi1=some[4].getValue();
				hi2=some[3].getValue();
				hi3=some[2].getValue();
				hi4=some[1].getValue();
				hi5=some[0].getValue();

			}
		}else if(suitcounter==3) {
			if((rankdif1==rankdif2)&&(rankdif2==rankdif3)&&(rankdif3==rankdif4)&&(rankdif4==1)) {
				cs=5;
				hi1=some[4].getValue();
				
			}else if(((rankdif1==rankdif2)&&(rankdif2==0))||((rankdif2==rankdif3)&&(rankdif2==0))||((rankdif3==rankdif4)&&(rankdif4==0))) {
				cs=4;
				if(((rankdif1==rankdif2)&&(rankdif2==0))) {
					hi1=some[2].getValue();
					hi2=some[4].getValue();
					hi3=some[3].getValue();
				}else if(((rankdif2==rankdif3)&&(rankdif2==0))) {
					hi1=some[3].getValue();
					hi2=some[4].getValue();
					hi3=some[0].getValue();
				}else if(((rankdif3==rankdif4)&&(rankdif4==0))) {
					hi1=some[4].getValue();
					hi2=some[1].getValue();
					hi3=some[0].getValue();
				}
				
			}else if(((rankdif1==rankdif3)&&(rankdif1==0))||((rankdif2==rankdif4)&&(rankdif4==0))||((rankdif1==rankdif4)&&(rankdif1==0))) {
				cs=3;
				if(((rankdif1==rankdif3)&&(rankdif1==0))) {
					hi1=some[3].getValue();
					hi2=some[1].getValue();
					hi3=some[4].getValue();
				}else if(((rankdif2==rankdif4)&&(rankdif4==0))) {
					hi1=some[4].getValue();
					hi2=some[2].getValue();
					hi3=some[0].getValue();
				}if(((rankdif1==rankdif4)&&(rankdif1==0))) {
					hi1=some[4].getValue();
					hi2=some[1].getValue();
					hi3=some[2].getValue();
				}
				
			}else if(rankdif1==0||rankdif2==0||rankdif3==0||rankdif4==0) {
				cs=2;
				if(rankdif1==0) {
					hi1=some[1].getValue();
				}else if(rankdif2==0) {
					hi1=some[2].getValue();
				}else if(rankdif3==0) {
					hi1=some[3].getValue();
				}else if(rankdif4==0) {
					hi1=some[4].getValue();
				}
				
			}else {
				cs=1;
				hi1=some[4].getValue();
				hi2=some[3].getValue();
				hi3=some[2].getValue();
				hi4=some[1].getValue();
				hi5=some[0].getValue();

			}
		}else if((suitcounter==2)) {
			if(((rankdif1==rankdif2)&&(rankdif2==rankdif3)&&(rankdif3==0)&&(rankdif4!=0))||((rankdif2==rankdif3)&&(rankdif3==rankdif4)&&(rankdif4==0)&&(rankdif1!=0))) {
				cs=8;
				if(((rankdif1==rankdif2)&&(rankdif2==rankdif3)&&(rankdif3==0)&&(rankdif4!=0))) {
					hi1=some[3].getValue();
					hi2=some[4].getValue();
				}else if(((rankdif2==rankdif3)&&(rankdif3==rankdif4)&&(rankdif4==0)&&(rankdif1!=0))) {
					hi1=some[4].getValue();
					hi2=some[0].getValue();
				}
				
			}else if(((rankdif1==rankdif2)&&(rankdif2==0)&&(rankdif3!=0)&&(rankdif4==0))||((rankdif3==rankdif4)&&(rankdif4==0)&&(rankdif1==0)&&(rankdif2!=0))) {
				cs=7;
				if(((rankdif1==rankdif2)&&(rankdif2==0)&&(rankdif3!=0)&&(rankdif4==0))) {
					hi1=some[2].getValue();
					hi2=some[4].getValue();
				}else if(((rankdif3==rankdif4)&&(rankdif4==0)&&(rankdif1==0)&&(rankdif2!=0))) {
					hi1=some[4].getValue();
					hi2=some[1].getValue();
				}
				
			}else if((rankdif1==rankdif2)&&(rankdif2==rankdif3)&&(rankdif3==rankdif4)&&(rankdif4==1)) {
				cs=5;
				hi1=some[4].getValue();
			}else if(((rankdif1==rankdif2)&&(rankdif2==0))||((rankdif2==rankdif3)&&(rankdif2==0))||((rankdif3==rankdif4)&&(rankdif4==0))) {
				cs=4;
				if(((rankdif1==rankdif2)&&(rankdif2==0))) {
					hi1=some[2].getValue();
					hi2=some[4].getValue();
					hi3=some[3].getValue();
				}else if(((rankdif2==rankdif3)&&(rankdif2==0))) {
					hi1=some[3].getValue();
					hi2=some[4].getValue();
					hi3=some[0].getValue();
				}else if(((rankdif3==rankdif4)&&(rankdif4==0))) {
					hi1=some[4].getValue();
					hi2=some[1].getValue();
					hi3=some[0].getValue();
				}
				
			}else if(((rankdif1==rankdif3)&&(rankdif1==0))||((rankdif2==rankdif4)&&(rankdif4==0))||((rankdif1==rankdif4)&&(rankdif1==0))) {
				cs=3;
				if(((rankdif1==rankdif3)&&(rankdif1==0))) {
					hi1=some[3].getValue();
					hi2=some[1].getValue();
					hi3=some[4].getValue();
				}else if(((rankdif2==rankdif4)&&(rankdif4==0))) {
					hi1=some[4].getValue();
					hi2=some[2].getValue();
					hi3=some[0].getValue();
				}if(((rankdif1==rankdif4)&&(rankdif1==0))) {
					hi1=some[4].getValue();
					hi2=some[1].getValue();
					hi3=some[2].getValue();
				}
			}else if(rankdif1==0||rankdif2==0||rankdif3==0||rankdif4==0) {
				cs=2;
				if(rankdif1==0) {
					hi1=some[1].getValue();
				}else if(rankdif2==0) {
					hi1=some[2].getValue();
				}else if(rankdif3==0) {
					hi1=some[3].getValue();
				}else if(rankdif4==0) {
					hi1=some[4].getValue();
				}
			}else {
				cs=1;
				hi1=some[4].getValue();
				hi2=some[3].getValue();
				hi3=some[2].getValue();
				hi4=some[1].getValue();
				hi5=some[0].getValue();
			}
		}else {
			cs=1;
			hi1=some[4].getValue();
			hi2=some[3].getValue();
			hi3=some[2].getValue();
			hi4=some[1].getValue();
			hi5=some[0].getValue();
		}                                                            //use nested if conditions to classify the card category
		 
		int[] oo= {cs,hi1,hi2,hi3,hi4,hi5};
		return oo;
	}

	public String out(int cs) {
		String outc="";
		if(cs==9){
			outc="Straight flush.";
		}else if(cs==8) {
			outc="Four of a Kind.";
		}else if(cs==7) {
			outc="Full House.";
		}else if(cs==6) {
			outc="Flush.";
		}else if(cs==5) {
			outc="Straight.";
		}else if(cs==4) {
			outc="Three of a Kind.";
		}else if(cs==3) {
			outc="Two Pair.";
		}else if(cs==2) {
			outc="One pair.";
		}else{
			outc="High card.";
		}
		return outc;                                       //convert the classification number into the String of result
	}
	
	public void compare(Card[]hand1,Card[]hand2) {
		Functions s=new Functions();
		
		if(s.classify(hand1)[0]>s.classify(hand2)[0]) {
			System.out.println("hand#1 wins!");
		}else if(s.classify(hand1)[0]<s.classify(hand2)[0]) {
			System.out.println("hand#2 wins!");
		}else {
			if(s.classify(hand1)[1]>s.classify(hand2)[1]) {
				System.out.println("hand#1 wins!");
			}else if(s.classify(hand1)[1]<s.classify(hand2)[1]) {
				System.out.println("hand#2 wins!");
			}else {
				if(s.classify(hand1)[2]>s.classify(hand2)[2]) {
					System.out.println("hand#1 wins!");
				}else if(s.classify(hand1)[2]<s.classify(hand2)[2]) {
					System.out.println("hand#2 wins!");
				}else {
					if(s.classify(hand1)[3]>s.classify(hand2)[3]) {
						System.out.println("hand#1 wins!");
					}else if(s.classify(hand1)[3]<s.classify(hand2)[3]) {
						System.out.println("hand#2 wins!");
					}else {
						if(s.classify(hand1)[4]>s.classify(hand2)[4]) {
							System.out.println("hand#1 wins!");
						}else if(s.classify(hand1)[4]<s.classify(hand2)[4]) {
							System.out.println("hand#2 wins!");
						}else {
							if(s.classify(hand1)[5]>s.classify(hand2)[5]) {
								System.out.println("hand#1 wins!");
							}else if(s.classify(hand1)[5]<s.classify(hand2)[5]) {
								System.out.println("hand#2 wins!");
							}
						}
					}
				}
			}                                                                                 //one-by-one comparison 
		}
		
	}
	
	public Card[] convert(String some) {
		String R[]= {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
		String R1[]= {"2","3","4","5","6","7","8","9","t","j","q","k","a"};
		String R2[]= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String S[]= {"c","h","s","d"};
		String S2[]= {"C","H","S","D"};
		String S1[]= {"Club","Heart","Spade","Diamond"};
		Card[] user=new Card[5];
		String suit="";
		String rank="";
		int value=0;
		
		for(int i=0;i<=10;i++) {
			for(int j=0;j<=12;j++) {
				if(i==10) {
					if((some.substring(i).contentEquals(R[j]))||(some.substring(i).contentEquals(R1[j]))) {
						rank=R2[j];
						value=j+1;
						}
				}
				else{	
					if(some.substring(i, i+1).contentEquals(R[j])||some.substring(i, i+1).contentEquals(R1[j])) {
					rank=R2[j];
					value=j+1;
					}
				}
			}                                                                        //use nested for loops and substring to match with specific content and then convert into an array of cards
			for(int j=0;j<=3;j++) {
				if(i==10) {
					if(some.substring(i).contentEquals(S[j])||some.substring(i).contentEquals(S2[j])) {
						suit=S1[j];
					}
				}else{
					if(some.substring(i, i+1).contentEquals(S[j])||some.substring(i, i+1).contentEquals(S2[j])) {
						suit=S1[j];
					}
				}
				
				
				if(i%2==1) {
					user[(i-1)/2]=new Card(suit,rank,value);            //assign cards
				}	
			}
		}
		return user;
	}
	
}
