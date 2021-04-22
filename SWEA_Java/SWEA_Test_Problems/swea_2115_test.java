package test;

import java.io.*;
import java.util.*;

public class swea_2115_test {

	static int N,M,C,map[][],input[],max, revsumA, revsumB;
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/swea_2115_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for(int tc=1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = stoi(st.nextToken());//����ũ��
			M = stoi(st.nextToken());//���밳��
			C = stoi(st.nextToken());//��ä���ִ��
			map = new int[N][N];//�����
			input = new int[2];
			max = Integer.MIN_VALUE; // �ִ� ����
			for(int i=0;i<N;++i) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;++j) map[i][j] = stoi(st.nextToken());
			}
			//Ž���� �����Ѵ�.
			searchHoney(0,0);
			sb.append("#").append(tc).append(" ").append(max).append('\n');
		}
		System.out.println(sb);
	}
	static void searchHoney(int start, int cnt) {
		if(cnt == 2) { // ���� ��ŭ �� ����ٸ� ?(�ϲ��� �θ���)
			// ��ġ�� �������ش�.input[1]�� input[0]~input[0]+M-1�� ��ġ�� �ȵȴ�.
			if(input[0]<input[1] && input[1]<input[0]+M) return;
			// ���� �ٸ��� ���η� ���ӵȰ� �ƴϹǷ� �������ش�.(���۰����� �ٸ����̸��)
			if(input[0]/N != (input[0]+(M-1))/N) return; // ���� A
			if(input[1]/N != (input[1]+(M-1))/N) return; // ���� B
			// ���� �������� �ִ� ������ ���캸�� �������ش�.
			max = Math.max(max, getRevenu(input[0], input[1]));
			return;
		}
		for(int i=start;i<N*N;++i) { // 0-15������ �迭�ε����� 2��ŭ �̴´�.
			input[cnt] = i;
			searchHoney(i+1,cnt+1);
		}
	}
	
	// ���Ͱ���ؼ� ��ȯ���ش�.
	private static int getRevenu(int honeyA, int honeyB) {
		revsumA = 0;
		for(int i=1;i<=M;++i) {
			check(0,honeyA,honeyA+M,i,0,0,0); // 1��..2��...3��..m�� �̱�
		}
		revsumB = 0;
		for(int i=1;i<=M;++i) {
			check(1,honeyB,honeyB+M,i,0,0,0);
		}
		int revenu = revsumA + revsumB;//��ü ������ �����ְ�
		return revenu; // ��ȯ���ش�.
	}
	static void check(int type, int start, int n, int R, int cnt, int sum, int rev) {
		if(cnt == R) { // 1��...2..R�� �̾Ƽ� ����� �ִ� �ִ������� ������.
			if(sum <= C) { // ���뷮 ���� ���̸�  ������ �����Ѵ�.
				if(type == 0) revsumA= Math.max(revsumA, rev);
				else revsumB = Math.max(revsumB, rev);
			}
			return;
		}
		for(int i=start; i<n;++i) {
			int val = map[i/N][i%N];
			check(type,i+1, n, R,cnt+1, sum + val, rev + (int)Math.pow(val, 2));
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
