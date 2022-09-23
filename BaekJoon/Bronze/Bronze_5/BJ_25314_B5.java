import java.util.*;
public class BJ_25314_B5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String front = "";
		for(int i=0;i<N/4;++i) front+="long ";
		System.out.println(front+"int");
	}

}
