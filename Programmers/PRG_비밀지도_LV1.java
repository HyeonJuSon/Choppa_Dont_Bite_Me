public class PRG_비밀지도_LV1 {

	static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;++i) {
        	String now = Integer.toBinaryString(arr1[i] | arr2[i]);
        	while(now.length()<n) {
        		now = " "+now;
        	}
        	String val = "";
        	for(int j=0;j<now.length();++j) {
        		if(now.charAt(j)=='1') val+="#";
        		else val+=" ";
        	}
        	answer[i] = val;
        }
        
        return answer;
    }
		
	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		String[] answer = solution(n,arr1,arr2);
		for(String s : answer) System.out.println(s+" ");
	}

}
