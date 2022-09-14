
class UserSolution {
	class Dir {
		Dir parent;
		Dir child[];
		char[] name;
		int childCnt;

		public Dir(char[] name, Dir parent) {
			this.name = new char[NAME_MAX + 1];
			mstrcpy(this.name, name);
			this.parent = parent;
			this.child = new Dir[31];// 최대 30개
			childCnt = 0;
		}
	}

	private final static int NAME_MAX = 6;

	Dir root; // 루트 디렉토리
	int N = 0;

	void init(int n) {
		root = new Dir(new char[] { '/', 0, 0, 0, 0, 0, 0 }, null);
		N = n;
	}

	// 디렉토리 찾아서 반환
	Dir getDir(char[] name) {
		if (name[1] == 0) return root;

		int idx = 1;
		Dir now = root;

		while (true) {
			boolean isFind = false;
			for (Dir d : now.child) {
				for (int i = idx, j = 0; j < 7; ++i, ++j) {
					if (name[i] == '/' && d.name[j] == 0) {
						isFind = true;
						now = d;// 찾은 디렉토리를 넣어주고
						idx = i + 1;
						if (name[idx] == 0) return now;
						break;
					} else if (name[i] != d.name[j])
						break;
				}

				if (isFind) break;
			}
		}

	}

	void cmd_mkdir(char[] path, char[] name) {
		Dir parent = getDir(path);// 상위 디렉토리를 받고
		Dir child = new Dir(name, parent); // 하위 디렉토리 생성
		parent.child[parent.childCnt++] = child; // 상위 디렉토리에 기록
	}

	void cmd_rm(char[] path) {
		Dir target = getDir(path);
		Dir parent = target.parent;

		for (int i = 0; i < parent.childCnt; ++i) {
			if (!parent.child[i].equals(target))
				continue;

			if (i == parent.childCnt - 1) {// 마지막 자식이면
				parent.child[i] = null;// 자식에서 지워주고
			} else { // 중간에 끼어있으면 맨뒤에거를 지울 자리에 넣음
				parent.child[i] = parent.child[parent.childCnt - 1];
				parent.child[parent.childCnt - 1] = null;
			}
			--parent.childCnt; // 카운트 감소
			return;
		}
	}

	Dir copy(Dir target) {
		Dir tmp = new Dir(target.name.clone(), null);

		int cCnt = target.childCnt;
		if (cCnt == 0) return tmp;
		tmp.childCnt = cCnt;
		
		for (int i = 0; i < cCnt; ++i) {
			tmp.child[i] = copy(target.child[i]);
			tmp.child[i].parent = tmp;
		}
		
		return tmp;
	}

	void cmd_cp(char[] srcPath, char[] dstPath) {
		Dir to = getDir(dstPath);
		Dir from = getDir(srcPath);
		to.child[to.childCnt] = copy(from);
		to.child[to.childCnt++].parent = to;
	}

	void cmd_mv(char[] srcPath, char[] dstPath) {
		Dir to = getDir(dstPath);
		Dir from = getDir(srcPath);
		Dir old = from.parent; // 기존의 부모
		
		for(int i=0;i<old.childCnt;++i) {
			if(!old.child[i].equals(from)) continue;
			
			if(i==old.childCnt-1) {
				old.child[i]=null;
			}else {
				old.child[i] = old.child[old.childCnt-1];
				old.child[old.childCnt-1]=null;
			}
			--old.childCnt;
		}
		
		to.child[to.childCnt] = from;
		to.child[to.childCnt++].parent = to;
	}

	int getCount(Dir target) {
		if(target.childCnt == 0) return 0;
		int answer = target.childCnt;
		for(int i=0;i<target.childCnt;++i)
			answer += getCount(target.child[i]);
		return answer;
	}
	
	int cmd_find(char[] path) {
		Dir target = getDir(path);
		return getCount(target);
	}

	// 같은 글자인지 비교
	int mstrcmp(char[] a, char[] b) {
		int i;
		for (i = 0; a[i] != '\0'; i++) {
			if (a[i] != b[i])
				return a[i] - b[i];
		}
		return a[i] - b[i];
	}

	// 글자 복사
	void mstrcpy(char[] dest, char[] src) {
		int i = 0;
		while (src[i] != '\0') {
			dest[i] = src[i++];
		}
		dest[i] = src[i];
	}

}
