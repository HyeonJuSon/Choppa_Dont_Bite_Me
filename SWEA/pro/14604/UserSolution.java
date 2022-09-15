import java.util.*;

import UserSolution.Node;
import UserSolution.Server;
import UserSolution.User;

class UserSolution {
	private final static int MAXServer = 10;
	private final static int MAXUser = 10000;

	Node[] pools = new Node[MAXUser * MAXServer];
	int poolIdx;
	Server[] servers = new Server[MAXServer];
	User[] users = new User[MAXUser];
	int length, serverCnt, capacity;

	void serverInOut(int sid, Node node, boolean in) {
		if(in) {
			++servers[sid].cnt;
			servers[sid].in.add(node);
		}else {
			servers[sid].out.add(node);
		}
	}

	Node popInOut(int sid, boolean in) {
		Node node = null;
		if(in) {
			--servers[sid].cnt;
			if (!servers[sid].in.isEmpty()) {
				node = servers[sid].in.pollFirst();
			}
		}else {
			if (!servers[sid].out.isEmpty()) {
				node = servers[sid].out.pollLast();
			}
		}
		return node;
	}

	void removeIn(int sid, Node node) {
		--servers[sid].cnt;
		servers[sid].in.remove(node);
	}

	void batchServer(int uid) {
		int sid = users[uid].servers[users[uid].sidx];

		serverInOut(sid, users[uid].node,true);
		if (servers[sid].cnt > capacity) {
			Node node = popInOut(sid,true);
			Node outNode = pools[poolIdx++];
			outNode.uid = node.uid;
			outNode.priority = node.priority;
			serverInOut(sid, outNode,false);
			++users[node.uid].sidx;
			batchServer(node.uid);
		}
	}

	void updateServer(int sid) {
		Node cur;
		while(true) {
			cur = popInOut(sid,false);
			if (cur == null) break;

			int uid = cur.uid;
			if (users[uid].node == null) continue;

			for (int i = 0; i < users[uid].sidx; ++i) {
				if (users[uid].servers[i] != sid) continue;
				int prevSid = users[uid].servers[users[uid].sidx];
				removeIn(prevSid, users[uid].node);
				users[uid].sidx = i;
				serverInOut(sid, users[uid].node,true);
				updateServer(prevSid);
				return;
			}
		}
	}

	public void init(int L,int N, int C, int[] axis) {
		for (int i = 0; i < pools.length; ++i) pools[i] = new Node();
		for (int i = 0; i < servers.length; ++i) servers[i] = new Server();
		for (int i = 0; i < users.length; ++i) users[i] = new User();
		
		poolIdx = 0;
		serverCnt = N;
		length = L;
		capacity = C;

		for (int i = 0; i < serverCnt; ++i) {
			servers[i].axis = axis[i];
			servers[i].cnt = 0;
			servers[i].in = new TreeSet<>();
			servers[i].out = new TreeSet<>();
		}
	}

	public int getDist(int u, int s) {
		if (u < s)
			return Math.min(s- u, length - s + u);
		return Math.min(u - s, length - u + s);
	}
	
	public int add_user(int uid, int axis) {
		int maxDist = 0;
		ArrayList<int []> serverDist = new ArrayList<>();
		for (int i = 0; i < serverCnt; ++i) {
			int dist=getDist(axis,servers[i].axis);
			serverDist.add(new int[]{i, dist});
			maxDist = Math.max(maxDist, dist);
		}

		Collections.sort(serverDist, (int[] a, int[] b) -> {
			if (a[1] == b[1]) return Integer.compare(a[0],b[0]);
			return Integer.compare(a[1],b[1]);
		});

		for (int i = 0; i < serverCnt; ++i) {
			users[uid].servers[i] = serverDist.get(i)[0];
		}

		Node newNode = pools[poolIdx++];
		newNode.uid = uid;
		newNode.priority = maxDist;
		users[uid].sidx = 0;
		users[uid].node = newNode;
		batchServer(uid);

		return users[uid].servers[users[uid].sidx];
	}

	public int remove_user(int uid) {
		int sid = users[uid].servers[users[uid].sidx];
		removeIn(sid, users[uid].node);
		users[uid].node = null;
		updateServer(sid);
		return sid;
	}

	public int get_users(int sid) {
		return servers[sid].cnt;
	}
	
	class Node implements Comparable<Node> {
		int uid;
		int priority;

		@Override
		public int compareTo(Node o) {
			if (this.priority == o.priority)
				return Integer.compare(o.uid, this.uid);
			return Integer.compare(this.priority, o.priority);
		}
	};
	
	class User {
		int sidx;
		int[] servers = new int[MAXServer];
		Node node;
	};

	class Server {
		int axis;
		int cnt;
		TreeSet<Node> in;
		TreeSet<Node> out;
	};
}