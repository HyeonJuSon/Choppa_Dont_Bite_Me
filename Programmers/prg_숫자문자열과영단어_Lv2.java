package day;

// 일부 자릿수를 영단어로 바꾼 카드 -> 원래 숫자 찾기

// 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어진다.
// s가 의미하는 원래 숫자를 return 하도록 solution함수를 완성.
import java.util.*;

public class prg_lv2_숫자문자열과영단어 {

	static HashMap<String, String> hm = new HashMap<>();

	static public int solution(String s) {
		int answer = 0;
		initMap();
		String output= "";
		for (int i = 0; i < s.length(); ++i) {
			char now = s.charAt(i);
			if('0'<=now && now <='9') output+=now;
			else {
				for(int j=3;j<6;++j) {
					String sub = s.substring(i,i+j);
					if(hm.containsKey(sub)) {
						output+=hm.get(sub);
						i= i+j-1;
						break;
					}
				}
			}
		}
		return answer = Integer.parseInt(output);
	}
	// 최소 길이 3 ~ 최대길이 5
	static void initMap() {
		hm.put("zero", "0");
		hm.put("one", "1");
		hm.put("two", "2");
		hm.put("three", "3");
		hm.put("four", "4");
		hm.put("five", "5");
		hm.put("six", "6");
		hm.put("seven", "7");
		hm.put("eight", "8");
		hm.put("nine", "9");
	}

	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}

}
