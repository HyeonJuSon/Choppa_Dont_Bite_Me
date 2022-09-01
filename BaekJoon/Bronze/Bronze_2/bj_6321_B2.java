package bronze;

import java.io.*;

public class bj_6321_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			String str = br.readLine();
			String answer ="";
			for(int s=0;s<str.length();++s) {
				char now = str.charAt(s);
				if(now=='Z') now ='A';
				else now = (char)(now+1);
				answer+= now;
			}
			System.out.println("String #"+(i+1));
			System.out.println(answer);
			System.out.println();
		}
	}

}
