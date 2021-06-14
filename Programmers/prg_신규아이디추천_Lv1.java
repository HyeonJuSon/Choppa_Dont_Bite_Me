
public class prg_신규아이디추천_Lv1 {
	// Step1.
	static String stepOne(String new_id) {
		String lowerAlpha ="";//바꿀 문자를 저장할 변수
		for(int i=0;i<new_id.length();++i) {
			int tmp = (int)new_id.charAt(i);//문자열은 아스키코드로 저장되므로 int형으로변환
			if(65<=tmp && tmp <=90) { // 글자가 대문자라면
				lowerAlpha+=(char)(tmp+32);//소문자로 바꿔준다.
			}else lowerAlpha+=(char)tmp;//그 외의 글자는 그냥 더해준다.
		}
		return lowerAlpha;
	}
	// Step2. 
	static String stepTwo(String new_id) {
		String delAlpha ="";
		for(int i=0;i<new_id.length();++i) {
			int tmp = (int)new_id.charAt(i);//문자열은 아스키코드로 저장되므로 int형으로변환
			if(isRule(tmp)) delAlpha+=(char)tmp;//가능한 문자만 반환문자열에저장
		}
		return delAlpha;//반환
	}
	static boolean isRule(int tmp) { // 소문자,숫자,빼기,밑줄,마침표만 가능
		return ((97<=tmp && tmp <= 122) || (48<=tmp&&tmp<=57) ||
				(char)tmp=='.' || (char)tmp =='-' ||(char)tmp =='_');
	}
	// Step 3.
	static String StepThree(String new_id) {
		String change="";//반환될 문자열
		char before =' ';//직전문자
		for(int i=0; i<new_id.length();++i) {
			char tmp = new_id.charAt(i);
			if(tmp == '.') before = tmp;// 현재 문자가 .이면 저장해주고
			else {// 현재 문자가 .이 아니면(마지막 .을 찾으면됌) 
				if(before != ' ') { // .을 저장해준다.
					change += before;// 한개의.만 더해주고
					before = ' ';//다시 초기화
				}
				change += tmp;//그리고 현재문자를 저장해준다.
			}
		}
		if(before=='.'&&new_id.length()==1) change += before;//한글자 .이면 그대로 반환
		return change;//반환
	}
	// Step 4.
	static String StepFour(String new_id) {
		String erase = "";//반환문자열
		if(new_id.length()<=1) {//1글자 이하면
			if(new_id.equals(".")) return "";//.이면 그냥 빈문자열반환
			else return new_id;//아니면 그냥반환
		}else {//2글자 이상이면
			boolean first = false, last = false;// 맨앞, 맨뒤 플래그
			if(new_id.charAt(0)=='.') first = true;//맨앞 플래그
			if(new_id.charAt(new_id.length()-1)=='.') last = true; //맨뒤 플래그
			if(first&&last) erase = new_id.substring(1,new_id.length()-1);//둘다?
			else if(first) erase = new_id.substring(1,new_id.length());//앞만
			else if(last) erase = new_id.substring(0,new_id.length()-1);//뒤만
			else erase = new_id;//둘다아님
		}
		return erase;//반환
	}
	// Step 5.
	static String StepFive(String new_id) {
		return new_id.length()==0? "a":new_id; //문자열 길이 0이면 a 아니면 그대로 반환
	}
	// Step 6.
	static String StepSix(String new_id) {//16글자 이상이면 15자까지 아니면 그대로 반환
		return new_id.length()>=16 ? new_id.substring(0,15) : new_id;
	}
	// Step 7.
	static String StepSeven(String new_id) {
		if(new_id.length()<=2) {// 2글자 이하면
			char last = new_id.charAt(new_id.length()-1);//마지막 문자를 
			while(new_id.length()<3) // 3글자이상이 될 때까지 붙여주고
				new_id+= last;
		}
		return new_id;//반환
	}
	static String solution(String new_id) {
		String answer="";
//		1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		new_id = stepOne(new_id);
//		2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		new_id = stepTwo(new_id);
//		3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		new_id = StepThree(new_id);
//		4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		new_id = StepFour(new_id);
//		5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		new_id = StepFive(new_id);
//		6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//		     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		new_id = StepFour(StepSix(new_id));
//		7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		new_id = StepSeven(new_id);
		return answer = new_id;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}

}
