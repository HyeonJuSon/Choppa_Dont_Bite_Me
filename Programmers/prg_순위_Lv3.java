// 아이디어 : 거쳐가네..?플로이드인감..?풀어보니되넴 개꿀
// 1,2,3번한테 2번이 지고 2번이 5번한테 이긴다? = 1,2,3 -> 2 -> 5 렇게 이어지네
public class prg_순위_Lv3 {

	static public int solution(int n, int[][] results) {
		int answer = 0;
		boolean[][] winBoard = new boolean[n][n];// 승패여부를 불린배열로 체크한다.
		int length = results.length;
		for (int i = 0; i < length; ++i) {
			int win = results[i][0] - 1;// 배열이라1빼줌
			int lose = results[i][1] - 1;// 배열이라 1빼줌
			winBoard[win][lose]=true;
		}
		// 거쳐서 갈 수있는지 체크해본다
		for(int i=0;i<n;++i) { 
			for(int j=0;j<n;++j) {
				for(int k=0;k<n;++k) {//j->i , i->k 이면 j->k임을 활용한다.
					if(winBoard[j][i]&&winBoard[i][k]) winBoard[j][k]=true;
				}
			}
		}
		// 경기 수를 체크해서 순위를 알 수 있는 번호들을 찾는다.
		for(int i=0;i<n;++i) {
			int game = 1;//경기 수 (N이랑 같으면 모든 경기결과가 있는거임)
			for(int j=0;j<n;++j) {
				if(winBoard[i][j] || winBoard[j][i]) ++game;//이겼거나졌으면 경기 수 +1
			}
			if(game == n) ++answer; // 5번의 경기를 진행했으면 순위를 알수 있음
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {
			{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
		}));
	}

}
