#include <iostream>
#include <vector>
#include <algorithm>
#include <tuple>
#define fio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

typedef struct logData {
	int x1, x2, idx;

	logData(int x1, int x2, int idx) {
		this->x1 = x1;
		this->x2 = x2;
		this->idx = idx;
	}
} logData;

bool comp(logData& a, logData& b) {
	if (a.x1 != b.x1) return a.x1 < b.x1;
	return a.x2 > b.x2;
}

int main() {
	fio;

	int n, q, x1, x2, y;
	cin >> n >> q;
	vector<logData> v;
	for (int i = 1; i <= n; i++) {
		cin >> x1 >> x2 >> y;
		v.push_back(logData(x1, x2, i));
	}
	sort(v.begin(), v.end(), comp);
	int start, end;
	for (int i = 0; i < q; i++) {
		cin >> start >> end;
		bool flag = false;
		for (int j = 0; j < v.size(); j++) {
			if (v[j].idx == start || v[j].idx == end) {
				int idx = j+1;
				int right = v[j].x2;
				for (; idx < v.size(); idx++) {
					if (v[idx].x1 > right) break;
					if (v[idx].idx == end || v[idx].idx == start) {
						flag = true;
						cout << 1 << endl;
						break;
					}
					right = v[idx].x2;
				}
				break;
			}
		}
		if (!flag) cout << 0 << endl;
	}

	return 0;
}
