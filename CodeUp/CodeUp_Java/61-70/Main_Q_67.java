package CodeUp61to70;
import java.util.*;
import java.io.*;
public class Main_Q_67 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println(a>0?"plus":"minus");
		System.out.println(a%2==0?"even":"odd");
	}

}
