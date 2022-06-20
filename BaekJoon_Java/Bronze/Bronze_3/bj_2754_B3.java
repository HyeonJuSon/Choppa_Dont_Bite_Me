package bronze;
import java.util.*;
import java.io.*;
public class bj_2754_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Double> hm = new HashMap<>();
		hm.put("A+", 4.3);
		hm.put("A0", 4.0);
		hm.put("A-", 3.7);
		hm.put("B+", 3.3);
		hm.put("B0", 3.0);
		hm.put("B-", 2.7);
		hm.put("C+", 2.3);
		hm.put("C0", 2.0);
		hm.put("C-", 1.7);
		hm.put("D+", 1.3);
		hm.put("D0", 1.0);
		hm.put("D-", 0.7);
		hm.put("F", 0.0);
		System.out.println(hm.get(br.readLine()));
	}

}
