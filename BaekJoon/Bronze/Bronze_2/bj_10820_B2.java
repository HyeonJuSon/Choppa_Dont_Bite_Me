package bronze;

import java.io.*;
import java.util.*;

public class bj_10820_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int s, d, n, z;
		while ((str = br.readLine()) != null) {
			s = d = n = z = 0;
			for(int i=0;i<str.length();++i) {
				char val = str.charAt(i);
				if('a' <= val && val <='z') ++s;
				else if('A'<=val && val <='Z') ++d;
				else if('0'<=val && val <='9') ++n;
				else if(' '==val) ++z;
			}
			System.out.println(s +" "+d +" "+n+" "+z);
		}
	}

}
