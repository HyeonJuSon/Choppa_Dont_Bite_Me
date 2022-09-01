package bj;

import java.io.*;
/*
 * [ IDEA ]
 * 2�� ����� �̷���� �����Ƿ�. 4��о� ���....
 * �������� ���̵��.
 */

public class bj_1992 {
	static int[][] arr; 					// ���� �迭 N*N
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Int(br.readLine());			// ���� �迭�� ũ��
		arr = new int[N][N]; 				// ���� �迭 �Ҵ�
		for(int i=0; i < N; i++) {			// ���� �迭 �Է�
            String str = br.readLine();
            for(int j=0; j < N; j++) {
                arr[i][j] = Int(str.substring(j, j+1));
            }
        }
		divide(N, 0, 0);					//���� ���� ����
		System.out.println(sb);				//���
	}

	// ������ ���� �޼ҵ� 
	static void divide(int n, int x, int y) {
		if(isPossible(n, x, y)) {			//���δ� ���� ���ڷ� �Ǿ��ִٸ�
            sb.append(arr[x][y]);			//��Ʈ�� ������ ���
        }else {
        	int half = n/2;					//�ݾ� �پ���. 8..4...2...
        	sb.append("(");
            divide(half, x, y);				//���� ��ġ (0,0)
            divide(half,x, y + half);		//���� ��ġ (0,half)
            divide(half, x + half, y);		//���� ��ġ (half,0)
            divide(half, x + half, y + half);//���� ��ġ (half,half)
            sb.append(")");
        }
	}
	// ��� ���� ���������� �Ǻ��ϴ� �޼ҵ�
	static boolean isPossible(int n, int x, int y) {
		int tmp = arr[x][y];				// �ϳ��� �̸� �޾Ƶΰ�.
		for (int i = x; i < x + n; i++) 
			for (int j = y; j < y + n; j++) // �ϳ��� �ٸ��� �ȵǹǷ� false
				if (tmp != arr[i][j]) return false; 
		return true;						//������ �� �ɷ����Ƿ� ��� ����. true
	}
	// Int�� ��ȯ���ִ� �޼ҵ�
	static int Int(String s) {
		return Integer.parseInt(s);
	}
	
}
