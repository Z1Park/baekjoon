#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define fio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

struct busLine {
	int start, end, line;
	busLine(int s, int e, int l) : start(s), end(e), line(l) {}
};

bool compare(busLine& a, busLine& b) {
	if (a.start != b.start)
		return a.start < b.start;
	return a.end > b.end;
}

bool line[500002];

int main() {
	fio;

	int n, m;
	cin >> n >> m;
	vector<busLine> v;
	int s, e;
	for (int i = 1; i <= m; i++) {
		cin >> s >> e;
		if (s > e) v.push_back(busLine(s, e+n, i));
		else {
			v.push_back(busLine(s+n, e+n, i));
			v.push_back(busLine(s, e, i));
		}
		line[i] = true;
	}
	sort(v.begin(), v.end(), compare);

	int last = -1;
	for (int i = 0; i < v.size(); i++) {
		if (v[i].end <= last) line[v[i].line] = false;
		else last = v[i].end;
	}

	for (int i = 1; i <= m; i++) {
		if (line[i]) cout << i << " ";
	}

	return 0;
}
