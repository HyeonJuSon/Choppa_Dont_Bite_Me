package CodeUp71to80;
import java.util.*;
import java.io.*;
public class Main_Q_76 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char ch = (char)br.read();
		char a = 'a';
		while(true) {
			System.out.print(a+" ");
			if(a==ch) break;
			a = (char)(a+1);
		}
	}

}
