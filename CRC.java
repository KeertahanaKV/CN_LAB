import java.util.*;

public class CRC {
	public static void main(String args[]){
		Scanner key=new Scanner(System.in);
		System.out.print("Enter the data: ");
		String data=key.next();
		String polynomial="100100110101";
		String encoded=data+CRC(data, polynomial, false);
		System.out.println("The encoded data is " + encoded);
		System.out.println("Enter the recieved data: ");
		String recieved=key.next();
		String decoded=CRC(recieved, polynomial, true);
		if(Integer.parseInt(decoded, 2)==0)
			System.out.println("No Error in transmission.");
		else
			System.out.println("Erroneous transmission.");
	}
	
	public static String CRC(String data, String polynomial, boolean error){
		StringBuffer rem=new StringBuffer(data);
		if(!error){
			for(int i=0; i<polynomial.length()-1; i++)
				rem.append("0");
		}
		for(int i=0; i<rem.length()-polynomial.length()+1; i++){
			if(rem.charAt(i)=='1'){
				for(int j=0; j<polynomial.length()-1; j++)
				rem.setCharAt(i+j, (rem.charAt(i+j)==polynomial.charAt(j)? '0' : '1'));
			}
		}
		return rem.substring(rem.length()-polynomial.length()+1);
	}
}
		
