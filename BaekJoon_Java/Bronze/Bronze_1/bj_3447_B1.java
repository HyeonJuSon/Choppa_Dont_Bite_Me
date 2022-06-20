package day;
import java.io.*;
import java.util.*;
public class bj_3447_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(true) {
			String tmp = br.readLine();
			if(tmp==null) break;
			while(tmp.contains("BUG"))
				tmp.replaceAll("BUG", "");
			str+=tmp;
		}
		System.out.println(str);
	}

}
