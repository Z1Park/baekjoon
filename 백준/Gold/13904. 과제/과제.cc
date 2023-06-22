#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

typedef pair<int, int> pii;

int main() {
	FIO;
	int n;
	cin >> n;
	vector<pii> v(n);
	for (int i = 0; i < n; i++)
		cin >> v[i].first >> v[i].second;
	sort(v.begin(), v.end());
	priority_queue<int, vector<int>, greater<int>> pq;
	for (int i = 0; i < n; i++) {
		if (pq.size() < v[i].first) {
			pq.push(v[i].second);
		}
		else if (pq.top() < v[i].second) {
			pq.pop();
			pq.push(v[i].second);
		}
	}
	int sum = 0;
	while (!pq.empty()) {
		sum += pq.top();
		pq.pop();
	}
	cout << sum;
	return 0;
}
