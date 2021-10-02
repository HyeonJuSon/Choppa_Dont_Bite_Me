package bronze;
import java.io.*;
public class bj_5586_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String input = br.readLine();
		String joi = "JOI";
		String ioi="IOI";
		int[] cnt = new int[2];
		for(int i=0;i<input.length()-2;++i) {
			String part = input.substring(i,i+3);
			if(joi.equals(part)) ++cnt[0];
			else if(ioi.equals(part)) ++cnt[1];
		}
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}

}
