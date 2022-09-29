import java.io.*;
import java.util.*;

public class BJ_4493_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int t = 0; t < N; ++t) {
			int battle = Integer.parseInt(br.readLine());
			int[] winCnt = new int[2];
			for (int i = 0; i < battle; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String A = st.nextToken();
				String B = st.nextToken();
				switch (A) {
				case "R":
					if (B.equals("S"))
						++winCnt[0];
					else if (B.equals("P"))
						++winCnt[1];
					break;
				case "S":
					if (B.equals("P"))
						++winCnt[0];
					else if (B.equals("R"))
						++winCnt[1];
					break;
				case "P":
					if (B.equals("R"))
						++winCnt[0];
					else if (B.equals("S"))
						++winCnt[1];
					break;
				}
			}
			if (winCnt[0] > winCnt[1])
				System.out.println("Player 1");
			else if (winCnt[0] < winCnt[1])
				System.out.println("Player 2");
			else
				System.out.println("TIE");

		}
	}

}
