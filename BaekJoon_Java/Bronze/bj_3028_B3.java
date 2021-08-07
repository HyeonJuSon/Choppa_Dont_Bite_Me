package bronze;
import java.util.*;
public class bj_3028_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String order = sc.next();
		boolean[] isHere= new boolean[3];
		int start = 0;
		isHere[start]=true;
		for(int i=0;i<order.length();++i) {
			char ch = order.charAt(i);
			if(ch=='A') {
				if(isHere[0]) {
					isHere[0] = false;
					isHere[1] = true;
				}else if(isHere[1]) {
					isHere[0] = true;
					isHere[1] = false;
				}
			}else if(ch=='B') {
				if(isHere[1]) {
					isHere[1] = false;
					isHere[2] = true;
				}else if(isHere[2]) {
					isHere[1] = true;
					isHere[2] = false;
				}
			}else {
				if(isHere[0]) {
					isHere[0] = false;
					isHere[2] = true;
				}else if(isHere[2]) {
					isHere[0] = true;
					isHere[2] = false;
				}
			}
		}
		for(int i=0;i<3;++i) {
			if(isHere[i]) {
				System.out.println(i+1);
				break;
			}
		}
	}

}
