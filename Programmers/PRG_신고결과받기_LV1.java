package gold;
import java.util.*;

public class PRG_신고결과받기_LV1 {

	static public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> Report = new HashMap<>();
        HashMap<String, Integer> idx=new HashMap<>();
        for(int i=0;i<id_list.length;++i) {
        	idx.put(id_list[i], i);
        }
        for(int i=0;i<report.length;++i){
            StringTokenizer st = new StringTokenizer(report[i]," ");
            String from = st.nextToken();
            String to = st.nextToken();
            if(!Report.containsKey(to)) Report.put(to, new HashSet<>());
            if(!Report.get(to).contains(from))Report.get(to).add(from);
        }
        for(int i=0;i<id_list.length;++i){
        	String now = id_list[i];
        	if(!Report.containsKey(now)) continue;
        	HashSet<String> reportNow = Report.get(id_list[i]);
        	if(reportNow.size()>=k) {
        		for(String reporter : reportNow) {
        			++answer[idx.get(reporter)];
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int[] arr = solution(id_list,report,k);
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}

}
