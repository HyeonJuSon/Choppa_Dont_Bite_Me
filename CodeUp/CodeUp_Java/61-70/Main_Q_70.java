package CodeUp61to70;
import java.util.*;
import java.io.*;
public class Main_Q_70 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mon = Integer.parseInt(br.readLine());
		System.out.println(mon==12||mon==1||mon==2? "winter" :
						(3<=mon&&mon<=5 ? "spring":
						(6<=mon&&mon<=8 ? "summer": "fall")));
	}

}
