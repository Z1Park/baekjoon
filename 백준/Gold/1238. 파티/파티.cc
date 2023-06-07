#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

typedef pair<int, int> pii;

vector<pii> graph[1001];
int arr[1001];
int res[1001];

int main() {
	FIO;

	int n, m, x;
	cin >> n >> m >> x;
	for (int i = 0; i < m; i++) {
		int s, e, t;
		cin >> s >> e >> t;
		graph[s].push_back({e, t});
	}

	for (int i = 1; i <= n; i++) {
		memset(arr, -1, sizeof(arr));
		priority_queue<pii, vector<pii>, greater<pii>> pq;
		pq.push({0, i});
		while (!pq.empty()) {
			int dist = pq.top().first;
			int node = pq.top().second;
			pq.pop();
			if (node == x) break;
			for (auto g : graph[node]) {
				int next = g.first, weight = dist + g.second;
				if (arr[next] == -1 || weight < arr[next]) {
					pq.push({weight, next});
					arr[next] = weight;
				}
			}
		}
		res[i] = arr[x];
	}

	memset(arr, -1, sizeof(arr));
	priority_queue<pii, vector<pii>, greater<pii>> pq;
	pq.push({0, x});
	while (!pq.empty()) {
		int dist = pq.top().first;
		int node = pq.top().second;
		pq.pop();
		for (auto g : graph[node]) {
			int next = g.first, weight = dist + g.second;
			if (arr[next] == -1 || weight < arr[next]) {
				pq.push({weight, next});
				arr[next] = weight;
			}
		}
	}

	int maxVal = 0;
	for (int i = 1; i <= n; i++) {
		res[i] += arr[i];
		if (res[i] > maxVal) maxVal = res[i];
	}
	cout << maxVal;

	return 0;
}
