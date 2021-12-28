package Programmers;

public class prg_행렬의덧셈_LV1 {
	static public int[][] solution(int[][] arr1, int[][] arr2) {
		int N = arr1.length, M = arr1[0].length;
		int[][] answer = new int[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				answer[i][j] = arr1[i][j]+arr2[i][j];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] answer = solution(new int[][] {{1,2},{2,3}},
				new int[][] {{3,4},{5,6}});
		for(int i=0;i<answer.length;++i) {
			for(int j=0;j<answer[i].length;++j) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}

}
