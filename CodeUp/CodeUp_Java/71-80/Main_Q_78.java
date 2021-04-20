package CodeUp71to80;
import java.util.*;
import java.io.*;
public class Main_Q_78 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum=0;
		for(int i=1;i<=N;++i) if(i%2==0) sum+=i;
		System.out.println(sum);
	}

}
