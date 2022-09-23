import java.math.BigInteger;
import java.io.*;

public class BJ_1252_B2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] val = br.readLine().split(" ");
		String front = val[0];
		String rear = val[1];
		BigInteger sum = new BigInteger(front,2).add(new BigInteger(rear,2));
		String answer=sum.toString(2);
		System.out.println(answer);
	}

}
