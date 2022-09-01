package bronze;

import java.io.*;

public class bj_9243_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int len = input.length();
		String ing = "";
		for(int i=0;i<T;++i) {
			for(int j=0;j<len;++j) {
				char now = input.charAt(j);
				if(now=='1') ing+='0';
				else ing+='1';
			}
			input = ing;
			ing="";
		}
		String output = br.readLine();
		System.out.println(input.equals(output)?"Deletion succeeded":"Deletion failed");
	}

}
