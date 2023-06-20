#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

typedef pair<int, int> pii;

bool cmp(pii a, pii b) {
	if (a.first < b.first) return true;
	else if (a.first > b.first) return false;
	return (a.second > b.second) ? true : false;
}

int main() {
	FIO;

	int n;
	cin >> n;
	vector<pii> v;
	priority_queue<int, vector<int>, greater<int>> pq;
	for (int i = 0; i < n; i++) {
		int dead, cup;
		cin >> dead >> cup;
		v.push_back({dead, cup});
	}
	sort(v.begin(), v.end(), cmp);
	for (int i = 0; i < n; i++) {
		if (pq.size() < v[i].first) {
			pq.push(v[i].second);
		}
		else if (pq.top() < v[i].second) {
			pq.pop();
			pq.push(v[i].second);
		}
	}
	int res = 0;
	while (!pq.empty()) {
		res += pq.top();
		pq.pop();
	}
	cout << res;

	return 0;
}
