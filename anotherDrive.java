import java.util.Scanner;

public class anotherDrive {

	public static void main(String[] args) {
		Functions s=new Functions();
		Scanner a=new Scanner(System.in);
		
		
		System.out.println("please enter your hand:");
		System.out.println("(note that this String should be in the form of RSRSRSRSRS where R are the ranks:2,3,4,5,6,7,8,9,T,t,J,j,Q,q,K,k,A,a");
		System.out.println("(and S are the suits:'s,S'for Spade, 'c,C'for Club, 'h,H'for Heart,'d,D'for Diamond )");
		String user=a.next();
		Card use[]=s.convert(user);
		System.out.print("the hand you just entered is: ");
		s.printCards(use);
		
		
		
		System.out.println("please enter another hand:");
		System.out.println("(note that this String should be in the form of RSRSRSRSRS where R are the ranks:2,3,4,5,6,7,8,9,T,t,J,j,Q,q,K,k,A,a");
		System.out.println("(and S are the suits:'s,S'for Spade, 'c,C'for Club, 'h,H'for Heart,'d,D'for Diamond )");
		String user2=a.next();
		Card use2[]=s.convert(user2);
		System.out.print("the hand you just entered is: ");
		s.printCards(use2);
		s.sort(use);
		s.sort(use2);
		
		System.out.println("the category of the first hand is "+s.out(s.classify(use)[0]));
		System.out.println("the category of the second hand is "+s.out(s.classify(use2)[0]));
		s.compare(use, use2);
		
	}
}
