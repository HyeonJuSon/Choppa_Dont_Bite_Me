package com.algo;
import java.util.Scanner;

public class Main_bj_17478_재귀함수가뭔가요_구미_4_손현주 {
	public static int n = 0;

	public static void Print(String str, int count) {
		for (int i = 0; i < count; i++) {
			System.out.print("____");
		}
		System.out.println(str);
	}

	public static void ChatBot(int i) {

		Print("\"재귀함수가 뭔가요?\"",i);
		if (i == n) {
			Print("\"재귀함수는 자기 자신을 호출하는 함수라네\"",i);
		} else {
			Print("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", i);
			Print("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", i);
			Print("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"", i);
			ChatBot(i + 1);
		}
		Print("라고 답변하였지.", i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		ChatBot(0);
		sc.close();
	}

}
