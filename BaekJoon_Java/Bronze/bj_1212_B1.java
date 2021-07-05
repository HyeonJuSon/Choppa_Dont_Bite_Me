package bronze;

import java.io.*;

public class bj_1212_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] oct = br.readLine().toCharArray();
		for(int i=0;i<oct.length;++i) {
			String tmp = Integer.toBinaryString(oct[i]-'0');
			if(i!=0) {
				if(tmp.length()==1) tmp = "00"+tmp;
				else if(tmp.length()==2) tmp= "0"+tmp;
			}
			sb.append(tmp);
		}
		System.out.println(sb.toString());
	}

}
