import java.io.*;

public class bj_7682_G5 {

	static char[][] ttt = new char[3][3];
	static int xCnt = 0, oCnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while (!(input = br.readLine()).equals("end")) {//end아닐때까지 반복
			checkCnt(input); // X와 O의 개수를 카운트한다.
			System.out.println(isValid() ? "valid" : "invalid");// 유효성 검사해서 출력하기
		}
	}

	static void checkCnt(String input) { // X와 O의 개수를 센다.
		xCnt = oCnt = 0; // 개수 초기화시키고
		for (int i = 0; i < 9; ++i) { //입력 및 카운팅
			char val = input.charAt(i);
			ttt[i / 3][i % 3] = val; 
			xCnt = val == 'X' ? xCnt + 1 : xCnt;
			oCnt = val == 'O' ? oCnt + 1 : oCnt;
		}
	}

	static boolean isValid() { // 유효성 검사
		if (xCnt + oCnt == 9) { // 빈공간 없이 가득 찼을 경우
			return (xCnt - 1 == oCnt) && !TicTacToe('O');// X가5개 O가 4개이고, O가 이긴상태면 안됌
		} else {// 빈공간이 있으면
			if (xCnt == oCnt) {// X카운트가 O카운트와 같으면 O검사
				return TicTacToe('O') && !TicTacToe('X'); // O가 이기고 X가 져야함
			} else if (xCnt - 1 == oCnt) { // X카운트가 O카운트보다 1개많으면 X검사 (더많으면 false임)
				return !TicTacToe('O') && TicTacToe('X'); // X가 이기고 O가 져야함
			}
		}
		return false; // 위의 경우 외는 걍 다 false ㄱ
	}

	static boolean TicTacToe(char target) {
		// 가로,세로
		for (int ij = 0; ij < 3; ++ij) {
			if (ttt[0][ij] == target && ttt[1][ij] == target && ttt[2][ij] == target) return true;
			if (ttt[ij][0] == target && ttt[ij][1] == target && ttt[ij][2] == target) return true;
		}
		// 대각선 2개 좌대각 우대각
		if (ttt[1][1] == target) {
			if (ttt[0][0] == target && ttt[2][2] == target) return true; // 좌대각
			if (ttt[0][2] == target && ttt[2][0] == target) return true; // 우대각
		}
		return false;
	}

}
