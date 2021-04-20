package CodeUp61to70;
import java.util.*;
import java.io.*;
public class Main_Q_65 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a= Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		System.out.println((a%2==0?Integer.toString(a)+"\n":"")+
				(b%2==0?Integer.toString(b)+"\n":"")+
				(c%2==0?Integer.toString(c)+"\n":""));
	}

}
