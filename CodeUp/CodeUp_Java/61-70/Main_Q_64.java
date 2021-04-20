package CodeUp61to70;
import java.util.*;
import java.io.*;
public class Main_Q_64 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a= Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		System.out.println(Integer.min(a, Integer.min(b, c)));
	}

}
