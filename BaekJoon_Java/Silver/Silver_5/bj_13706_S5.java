package silver;
import java.io.*;
import java.math.BigInteger;
public class bj_13706_S5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger target = new BigInteger(br.readLine());
		BigInteger start = new BigInteger("1");
		BigInteger end = target;
		BigInteger mid;
		
		while(true) {
			mid = start.add(end);//start+end
			mid = mid.divide(new BigInteger("2"));// /2
			
			int comp =(mid.multiply(mid)).compareTo(target); // 같은지 여부		
			if(comp==0) break; // 찾았으니 그만
			else if(comp==1) end = mid.subtract(new BigInteger("1")); // 이분탐색 좌측으로 탐색진행
			else start = mid.add(new BigInteger("1"));
		}
		
		System.out.println(mid.toString());
	}

}
