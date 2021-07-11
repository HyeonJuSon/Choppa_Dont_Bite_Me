import java.util.*;
public class prg_크레인인형뽑기_lv1 {

	static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for(int i=0;i<moves.length;++i) {
        	int val = moves[i]-1;//어느 열인지
        	int top = -1;//가장 위에 놓여진 인형의 값
        	for(int row = 0; row<board.length;++row) {
        		if(board[row][val]!=0) {//비어있지않다면
        			top = board[row][val];//실어주고
        			board[row][val] = 0;//비워준다
        			break;//끝낸다.
        		}
        	}
        	if(top!=-1) {//실어졌으면 -> 0일때 방지
        		if(basket.isEmpty()) basket.add(top);//스택이 비어있으면 그냥바로넣고
        		else {//안비어있으면 같은 인형인지 검사한다.
        			if(basket.peek() == top) {//같은인형이면
        				basket.pop();//뽑아주고
        				answer+=2;//2개가 터진다.
        			}else basket.add(top);//다른인형이면 넣어준다.
        		}
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(
				new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},
								{4,2,4,4,2},{3,5,1,3,1}},
				new int[] {1,5,3,5,1,2,1,4}));
	}
}
