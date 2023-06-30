#include <iostream>
#include <string>
#include <deque>
#define fio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

deque<char> crank[4];

void crankRotation(int idx, int dir) {
	if (dir == 1) {
		int tmp = crank[idx].back();
		crank[idx].pop_back();
		crank[idx].push_front(tmp);
	}
	else {
		int tmp = crank[idx].front();
		crank[idx].pop_front();
		crank[idx].push_back(tmp);
	}
}

int main() {
	fio;

	for (int i = 0; i < 4; i++) {
		string tmp;
		cin >> tmp;
		for (int j = 0; j < 8; j++)
			crank[i].push_back(tmp[j]);
	}
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int idx, tmpIdx, dir, tmpDir, joinLeft, joinRight;
		cin >> idx >> dir;
		tmpIdx = --idx;
		tmpDir = -1 * dir;
		if (tmpIdx > 0) {
			joinLeft = crank[tmpIdx-1][2];
			joinRight = crank[tmpIdx][6];
		}
		while (tmpIdx > 0 && joinLeft != joinRight) {
			if (tmpIdx != 1)  {
				joinLeft = crank[tmpIdx-2][2];
				joinRight = crank[tmpIdx-1][6];
			}
			crankRotation(tmpIdx-1, tmpDir);
			tmpIdx--;
			tmpDir *= -1;
		}
		tmpIdx = idx;
		tmpDir = -1 * dir;
		if (tmpIdx < 3) {
			joinLeft = crank[tmpIdx][2];
			joinRight = crank[tmpIdx+1][6];
		}
		while (tmpIdx < 3 && joinLeft != joinRight) {
			if (tmpIdx != 2) {
				joinLeft = crank[tmpIdx+1][2];
				joinRight = crank[tmpIdx+2][6];
			}
			crankRotation(tmpIdx+1, tmpDir);
			tmpIdx++;
			tmpDir *= -1;
		}
		crankRotation(idx, dir);
	}
	int score = 0;
	for (int i = 0; i < 4; i++)
		score |= (crank[i][0] - '0') * (1 << i);
	cout << score;

	return 0;
}