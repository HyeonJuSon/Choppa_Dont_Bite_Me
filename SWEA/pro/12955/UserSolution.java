import java.util.*;

class UserSolution {

	private final static int MAXServer = 10;
	private final static int MAXUser = 10000;

	class Server {
		int sid;
		int axis;
		int max;
		int cnt;

		public Server(int sid, int axis, int max) {
			this.sid = sid;
			this.axis = axis;
			this.max = max;
			this.cnt = 0;
		}
	}

	class UDist{
		int id;
		int dist;
		public UDist(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}
	}

	class Dist implements Comparable<Dist> {
		int id;
		int dist;

		public Dist(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}

		@Override
		public int compareTo(Dist o) {
			if (this.dist == o.dist)
				return Integer.compare(this.id, o.id);
			return Integer.compare(this.dist, o.dist);
		}
	}

	class User {
		int uid;
		int axis;
		TreeSet<Dist> priority; // 시청자 기준 서버
		int batch;
		public User(int uid, int axis) {
			this.uid = uid;
			this.axis = axis;
			this.priority = new TreeSet<>();
		}
	}

	TreeSet<UDist> userPriority;// 사용자 우선순위
	User[] users;// 유저 정보
	Server[] servers;// 서버정보
	int serverCnt;
	int Length; // 전체길이
	int maxCount;

	public void init(int L, int N, int C, int[] axis) {
		Length = L;
		maxCount = C;
		// server init
		serverCnt = N;
		servers = new Server[serverCnt];
		// server batch info
		// for N
		for (int i = 0; i < N; ++i) {
			servers[i] = new Server(i, axis[i], C);
		}
		// user init
		users = new User[MAXUser];
		for (int i = 0; i < MAXUser; ++i) {
			users[i] = null;
		}
		userPriority = new TreeSet<>(new Comparator<UDist>() {
			@Override
			public int compare(UDist o1, UDist o2) {
				if (o1.dist == o2.dist)
					return Integer.compare(o1.id, o2.id);
				return Integer.compare(o2.dist, o1.dist);
			}
		});
	}

	public void batchUser() {
		// 서버 돌면서 max값 만큼 배치
		for(int i=0;i<serverCnt;++i) servers[i].cnt = 0;
		
		for(UDist u : userPriority) { // 10000 1000 100000000
			int user = u.id;
			for(Dist s : users[user].priority) {//1000
				int server = s.id;
				// 서버가 꽉차지않았다면 배정
				if(servers[server].cnt < maxCount) {
					++servers[server].cnt;
					users[user].batch=server;
					break;
				}
			}
		}
	}
	
	int getDist(int uaxis, int saxis) {
		int answer;
		if (uaxis <saxis)
			answer = Math.min(saxis - uaxis, Length - saxis + uaxis);
		else
			answer = Math.min(uaxis - saxis, Length - uaxis + saxis);
		return answer;
	}

	public int add_user(int uid, int axis) {
		// 사용자 정보 추가
		users[uid] = new User(uid, axis);
		// 사용자 서버 우선순위 검사 후 저장
		int max = 0;
		for (int i = 0; i < serverCnt; ++i) {
			int dist = getDist(axis, servers[i].axis);
			max = Math.max(max, dist);
			users[uid].priority.add(new Dist(i, dist));
		}
		userPriority.add(new UDist(uid, max));
		// 배치
		batchUser();
		return users[uid].batch;
	}

	public int remove_user(int uid) {
		// 시청자 배치 위치 찾기
		int answer = users[uid].batch;
		// 시청자 제거
		users[uid] = null;
		for(UDist u : userPriority)
			if (u.id == uid) {
				userPriority.remove(u);
				break;
			}
		// 재배치
		batchUser();
		return answer;
	}

	public int get_users(int sid) {
		return servers[sid].cnt;
	}
}
