import java.io.*;
import java.util.*;

public class bj_13335_S1 {

	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 트럭의 개수
		int W = Integer.parseInt(st.nextToken());// 다리의 길이
		int L = Integer.parseInt(st.nextToken());// 다리의 최대 하중
		final int dummy = 0;// 더미 값
		int[] arr = new int[N]; // 트럭을 담을 배열
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)	arr[i] = Integer.parseInt(st.nextToken());// 트럭값 담기
		// process
		Queue<Integer> trucks = new LinkedList<>();// 다리에 올라가있는 트럭
		int hour = W, sum = 0, truckIdx = 0;// 마지막 트럭은 w 시간이 지나면 다리를 건너므로 w로 초기화시킴
		while (truckIdx < N) {//배열이라서 truckIdx가 N보다 작을때까지 (마지막트럭이 적재되면 바로 종료된다)
			if (trucks.size() == W) sum -= trucks.poll(); // 다리 길이만큼 찼으면 트럭 통과완료(큐에서 빼주기)
			if ( sum + arr[truckIdx] <= L) { // 최대 하중 L 이하라면
				sum += arr[truckIdx];//적재
				trucks.offer(arr[truckIdx++]);// 다리에 트럭을 올린다.
			} else trucks.offer(dummy);// 초과시에는 더미값을 넣어준다
			++hour;// 시간증가
		}
		System.out.println(hour);// 출력한다
	}

}
