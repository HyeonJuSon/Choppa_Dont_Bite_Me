package bj;
import java.io.*;
import java.util.*;
/*
 * [ 아이디어 ] 
 * 1. 치킨집 위치와 가정집 위치를 담을 리스트가 각각 필요
 * 2. 치킨집들 중에 M개 만큼 뽑아야 하는데 순서는 상관 없어 보임.
 * 3. 그럼 조합을 활용해서 치킨집 리스트에서 M개를 뽑아서 선택리스트에 넣음
 * 4. 가정집과 각 치킨집들의 거리를 검사해서 제일 작은 거리를 저장.
 * 5. 그리고 도시의 치킨 거리에 더함. 근데 이때도 합계가 도시의 치킨 거리보다 작으면 넣는다.
 * 6. 도시의 치킨 거리 최소 값 = 각 가정집의 치킨 거리 최소 값들의 합.
 */
public class bj_15686 {
	static int N, M;
	static ArrayList<int[]> houseList = new ArrayList<>();
	static ArrayList<int[]> chickenList = new ArrayList<>();
	static Stack<int[]> selectedStack = new Stack<>();
	static int total = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int house = 1;
		final int chicken = 2;
		N = Int(st.nextToken());
		M = Int(st.nextToken());
		for (int i = 1; i <= N; ++i) { // �룄�떆�쓽 遺�遺꾨뱾�쓣 �엯�젰 諛쏅뒗�떎.
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; ++j) {
				int tmp = Int(st.nextToken());
				if(tmp == house) houseList.add(new int[] {i,j});
				else if(tmp == chicken) chickenList.add(new int[] {i,j});
			}
		}
		pickChicken(0, 0);
		System.out.println(total);
	}
	static void  pickChicken(int cnt, int start) {
		if(cnt == M) {
			Update();
			return;
		}
		for(int i=start; i<chickenList.size();++i) {
			selectedStack.push(chickenList.get(i));
			pickChicken(cnt+1, i+1);
			selectedStack.pop();
		}
	}
	static void Update() {
		int sum =0;
		for(int[] house : houseList) {
			int min = Integer.MAX_VALUE;
			for(int[] select : selectedStack) {
				int dist = Math.abs(house[0]-select[0]) + Math.abs(house[1]-select[1]);
				min = Math.min(min, dist);
			}
			sum += min;
		}
		total = Math.min(total, sum);
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}