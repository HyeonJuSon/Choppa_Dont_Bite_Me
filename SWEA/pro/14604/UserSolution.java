import java.util.*;

class UserSolution {
	final int TRAINING = 1, WORK = 2, BROKEN = 3;
	class Robot {
		int id, smart = 0, time = 0, wID = 0, stat = TRAINING;
	}
	Robot[] robots;
	HashMap<Integer, ArrayList<Robot>> job;
	TreeSet<Robot> max, min;

	public void init(int N) {
		robots = new Robot[N + 1];
		job = new HashMap<>();
		min = new TreeSet<>(new Comparator<Robot>() {
			@Override
			public int compare(Robot o1, Robot o2) {
				if (o1.smart == o2.smart)
					return Integer.compare(o1.id, o2.id);
				return Integer.compare(o1.smart, o2.smart);
			}
		});
		max = new TreeSet<>(new Comparator<Robot>() {
			@Override
			public int compare(Robot o1, Robot o2) {
				if (o1.smart == o2.smart)
					return Integer.compare(o1.id, o2.id);
				return Integer.compare(o2.smart, o1.smart);
			}
		});
		// robot init
		for (int i = 1; i <= N; ++i) {
			robots[i] = new Robot();
			robots[i].id = i;
			min.add(robots[i]);
			max.add(robots[i]);
		}
	}

	public int callJob(int cTime, int wID, int mNum, int mOpt) {
		int answer = 0;
		Robot robot;
		ArrayList<Robot> tmp = new ArrayList<>();
		for (int i = 0; i < mNum; ++i) {
			if (mOpt == 0) {
				robot = max.pollFirst();
				min.remove(robot);
			} else {
				robot = min.pollFirst();
				max.remove(robot);
			}
			robot.wID = wID;
			robot.smart += cTime;
			robot.stat = WORK;
			tmp.add(robot);
			answer += robot.id;
		}
		job.put(wID, tmp);
		return answer;
	}

	public void returnJob(int cTime, int wID) {
		ArrayList<Robot> tmp = job.get(wID);
		if (!tmp.isEmpty()) {
			for (Robot r : tmp) {
				r.smart -= cTime;
				r.wID = 0;
				r.stat = TRAINING;
				min.add(r);
				max.add(r);
			}
			job.get(wID).clear();
		}
	}

	public void broken(int cTime, int rID) {
		Robot r = robots[rID];
		// 작업 중인 경우에만
		if (r.stat == WORK) {
			ArrayList<Robot> tmp = job.get(r.wID);
			tmp.remove(r);
			r.wID = 0;
			r.stat = BROKEN;
			r.smart = 0;
		}
	}

	public void repair(int cTime, int rID) {
		Robot r = robots[rID];
		if (r.stat == BROKEN) {
			r.stat = TRAINING;
			r.smart -= cTime;
			min.add(r);
			max.add(r);
		}
	}

	public int check(int cTime, int rID) {
		Robot r = robots[rID];
		if (r.stat == BROKEN)
			return 0;
		else if (r.stat == WORK)
			return r.wID * -1;
		return r.smart + cTime;
	}
}