import java.util.*;

public class PRG_오픈채팅방_LV1 {
	static class Msg{
		String userId;
		String msg; 
		Msg(String userId, String msg){
			this.userId	= userId;
			this.msg = msg;
		}
	}
	static HashMap<String, String> user = new HashMap<>();

	static public String[] solution(String[] record) {
		Queue<Msg> msg = new LinkedList<>();
		for(int i=0;i<record.length;++i) {
			String[] rc = record[i].split(" ");
			if(rc[0].equals("Enter")) {
				user.put(rc[1], rc[2]);
				msg.offer(new Msg(rc[1], "님이 들어왔습니다."));
			}else if(rc[0].equals("Leave")) {
				msg.offer(new Msg(rc[1],"님이 나갔습니다."));
			}else {
				user.put(rc[1], rc[2]);
			}
		}
		String[] answer = new String[msg.size()];
		int idx= 0;
		while(!msg.isEmpty()) {
			answer[idx++] = user.get(msg.peek().userId)+msg.poll().msg;
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		String [] rc= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(rc);
	}

}
