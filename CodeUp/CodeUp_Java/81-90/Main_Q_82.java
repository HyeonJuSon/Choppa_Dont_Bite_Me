package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_82 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String hex = br.readLine();
		int deci = Integer.parseInt(hex,16);
		for(int i=1;i<16;++i) {
			System.out.println(hex +"*"+Integer.toHexString(i).toUpperCase()+"="+Integer.toHexString((deci*i)).toUpperCase());
		}
	}
}
