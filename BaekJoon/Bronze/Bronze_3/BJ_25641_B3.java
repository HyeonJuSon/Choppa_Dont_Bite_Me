import java.io.*;
import java.util.*;

public class BJ_25641_B3 {

	static int N, sCnt, tCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) == 's')
				++sCnt;
			else
				++tCnt;
		}
		if (sCnt == tCnt)
			System.out.println(input);
		else {
			int idx = 0;
			while(true) {
				char now = input.charAt(idx++);
				if(now =='s') --sCnt;
				else --tCnt;
				if(sCnt == tCnt) {
					System.out.println(input.substring(idx,N));
					break;
				}
			}
		}
	}

}
