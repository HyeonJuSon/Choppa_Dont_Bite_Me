package bronze;
import java.util.*;
public class bj_2902_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String full = sc.next();
		String answer ="";
		for(int i=0;i<full.length();++i) {
			char alpha = full.charAt(i);
			if(65<=alpha && alpha <=90) {
				answer += alpha;
			}
		}
		System.out.println(answer);
	
	}

}
