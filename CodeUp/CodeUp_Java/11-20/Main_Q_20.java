package CodeUp11to20;

import java.io.*;
import java.util.*;

public class Main_Q_20 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for(int i =0;i<str.length();++i) {
			if(str.charAt(i) !='-') System.out.print(str.charAt(i));
		}
	}

}