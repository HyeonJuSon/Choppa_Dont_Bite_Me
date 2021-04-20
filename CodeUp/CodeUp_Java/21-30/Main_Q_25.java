package CodeUp21to30;

import java.util.*;
import java.io.*;

public class Main_Q_25 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int zero = 10000;
		for(int i=0;i<str.length();++i) {
			System.out.println("["+(str.charAt(i)-'0')*zero+"]");
			zero /=10;
		}
	}

}
