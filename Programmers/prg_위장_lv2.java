import java.util.*;

public class prg_위장_lv2 {

	static public int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hashMap = new HashMap<>();//해쉬사용
		for(int i=0;i<clothes.length;++i) {//옷개수만큼 반복한다.
			hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1],0)+1);//key : 옷종류, value : 옷종류 개수
		}
		Iterator<String> keys = hashMap.keySet().iterator();//이터레이터로 접근 
		while(keys.hasNext()) answer *= (hashMap.get(keys.next())+1); // 순열계산
		return --answer;//전부다 안입는경우 빼줌
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}}));
	}

}
