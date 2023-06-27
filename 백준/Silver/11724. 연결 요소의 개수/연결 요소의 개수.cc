#include <stdio.h>
#include <vector>
#include <deque>

using namespace std;

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	vector<int> vec[n+1];
	for (int i = 0; i < m; i++) {
		int u, v;
		scanf("%d %d", &u, &v);
		vec[u].push_back(v);
		vec[v].push_back(u);
	}
	int cnt = 0;
	bool visited[n+1];
	for (int i = 1; i <= n; i++)
		visited[i] = false;
	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			cnt++;
			visited[i] = true;
			deque<int> dq;
			dq.push_back(i);
			while (!dq.empty()) {
				int tmp = dq.front();
				dq.pop_front();
				for (auto v : vec[tmp]) {
					if (!visited[v]) {
						visited[v] = true;
						dq.push_back(v);
					}
				}
			}
		}
	}
	printf("%d\n", cnt);
}
