package bronze;
import java.io.*;
import java.util.*;
public class bj_5656_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int idx = 1;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int A= Integer.parseInt(st.nextToken());
			String oper = st.nextToken();
			if(oper.equals("E")) break;
			int B= Integer.parseInt(st.nextToken());
			System.out.print("Case "+idx+++": ");
			switch(oper) {
			case ">":
				System.out.println(A>B);
				break;
			case ">=":
				System.out.println(A>=B);
				break;
			case "<":
				System.out.println(A<B);
				break;
			case "<=":
				System.out.println(A<=B);
				break;
			case "==":
				System.out.println(A==B);
				break;
			case "!=":
				System.out.println(A!=B);
				break;
			}
		}
	}

}
