package CodeUp61to70;
import java.util.*;
import java.io.*;
public class Main_Q_68 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println(a>=90?"A":(a>=70?"B":(a>=40?"C": "D")));
	}

}
