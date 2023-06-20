#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

typedef pair<int, int> pii;

int main() {
	FIO;

	int n;
	cin >> n;
	vector<pii> v;
	priority_queue<int, vector<int>, greater<int>> pq;
	for (int i = 0; i < n; i++) {
		int s, t;
		cin >> s >> t;
		v.push_back({s, t});
	}
	sort(v.begin(), v.end());
	pq.push(v[0].second);
	for (int i = 1; i < n; i++) {
		if (v[i].first >= pq.top()) pq.pop();
		pq.push(v[i].second);
	}
	cout << pq.size();

	return 0;
}
