package bronze;

import java.io.*;

public class bj_11816_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();
		if(val.length()>=2) {
			String front = val.substring(0,2);
			if(front.equals("0x")) System.out.println(Integer.parseInt(val.substring(2),16));
			else {
				front = val.substring(0,1);
				if(front.equals("0")) System.out.println(Integer.parseInt(val.substring(1),8));
				else System.out.println(Integer.parseInt(val));
			}
		}
	}

}
