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
	vector<int> group(1);
	for (int i = 1; i <= n; i++) {
		cin >> x1 >> x2 >> y;
		v.push_back(logData(x1, x2, i));
		group.push_back(0);
	}
	sort(v.begin(), v.end(), comp);
	int ind = 0, end = v[0].x2;
	group[0] = ind;
	for (int i = 1; i < v.size(); i++) {
		if (v[i].x1 > end) ind++;
		end = v[i].x2;
		group[v[i].idx] = ind;
	}
	int s, e;
	for (int i = 0; i < q; i++) {
		cin >> s >> e;
		cout << ((group[s] == group[e]) ? 1 : 0) << endl;
	}

	return 0;
}
