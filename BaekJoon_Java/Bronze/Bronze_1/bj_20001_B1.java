package bronze;
import java.io.*;
public class bj_20001_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int sum = 0;
		while(!((input = br.readLine()).equals("고무오리 디버깅 끝"))) {
			if(input.equals("문제")) sum -= 1;
			else {
				if(sum!=0) sum += 1;
				else sum -= 2;
			}
		}
		System.out.println(sum ==0 ? "고무오리야 사랑해":"힝구");
	}

}
