package bj;

import java.util.*;

public class bj_4884 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		while (true) {
			// �Է� �κ�
			long G = sc.nextLong();
			long T = sc.nextLong();
			long A = sc.nextLong();
			long D = sc.nextLong();
			if (G == -1) break;

			long X = G * (T * (T - 1) / 2);// ��ü ����
			long tonerCnt = G * A + D; // ��ʸ�Ʈ ���� ����
			// 2��n���������� �˻�
			long check = 1;
			while (tonerCnt > check) {
				X += check;
				check *= 2;
			}
			long Y = check - tonerCnt; // �߰� �� ��
			// ��� ���� ���� =========================

			System.out.printf("%d*%d/%d+%d=%d+%d\n", G, A, T, D, X, Y);
		}
		sc.close();
	}
}
