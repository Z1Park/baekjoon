#include <iostream>
#include <vector>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define INF 300000000

using namespace std;

typedef pair<int, int> pii;

vector<pii> graph[501];
int arr[501];

int main() {
	FIO;

	int tc;
	cin >> tc;
	for (int a = 0; a < tc; a++) {
		int n, m, w;
		cin >> n >> m >> w;
		for (int i = 1; i <= n; i++) graph[i].clear();
		for (int i = 0; i < m; i++) {
			int s, e, t;
			cin >> s >> e >> t;
			graph[s].push_back({e, t});
			graph[e].push_back({s, t});
		}
		for (int i = 0; i < w; i++) {
			int s, e, t;
			cin >> s >> e >> t;
			graph[s].push_back({e, -t});
		}

		for (int i = 1; i <= n; i++) arr[i] = INF;
		arr[1] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j <= n; j++) {
				for (auto g : graph[j]) {
					int dist = arr[j] + g.second;
					if (arr[g.first] > dist) arr[g.first] = dist;
				}
			}
		}

		bool flag = false;
		for (int i = 1; i <= n; i++) {
			for (auto g : graph[i]) {
				if (arr[g.first] > arr[i] + g.second) {
					flag = true;
					break;
				}
			}
			if (flag) break;
		}
		cout << (flag ? "YES" : "NO") << endl;
	}

	return 0;
}
