package silver;
import java.io.*;
public class bj_9655_S5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(N%2==0?"CY":"SK");
	}
}
