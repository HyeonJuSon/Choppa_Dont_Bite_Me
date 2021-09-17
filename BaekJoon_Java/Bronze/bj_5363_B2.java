package bronze;
import java.io.*;
import java.util.*;
public class bj_5363_B2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String back = st.nextToken()+" "+st.nextToken()+" ";
			String front ="";
			while(st.hasMoreTokens())front+=st.nextToken()+" ";
			System.out.println(front+back);
		}
	}

}
