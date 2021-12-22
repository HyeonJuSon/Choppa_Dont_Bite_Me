package gold;
import java.io.*;
import java.util.*;
public class bj_1644_G3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 1. 소수리스트 구하기
		boolean[] notPrime = new boolean[N+1];
		notPrime[0] = notPrime[1] = true;
		for(int i=2;i*i<=N; ++i) {
			if(!notPrime[i]) for(int j=i*i; j<=N; j+=i) notPrime[j]=true;
		}
		ArrayList<Integer> primeList = new ArrayList<>();
		for(int i=2; i<=N;++i) if(!notPrime[i]) primeList.add(i);
		// 2. 투포인터
		int start = 0 , end = 0;
		int answer =0;
		while(true) {
			if(end == primeList.size()) break;
			int sum = 0;
			for(int i=start;i<=end;++i) sum+= primeList.get(i);
			if(sum < N) ++end;
			else {
				if(sum==N)++answer;
				++start;
			}
		}
		System.out.println(answer);
	}

}
