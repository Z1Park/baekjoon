#include <iostream>
#include <vector>
#include <queue>
#define fio ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

using namespace std;

int counts[32000];
vector< vector<int> > graph;

int main() {
	fio

	int N, M;
	cin >> N >> M;
	graph.resize(N);
	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		graph[a-1].push_back(b-1);
		counts[b-1]++;
	}
	priority_queue< int, vector<int>, greater<int> > pq;
	for (int i = 0; i < N; i++) {
		if (counts[i] == 0)
			pq.push(i);
	}
	vector<int> res;
	while (!pq.empty()) {
		int tmp = pq.top();
		pq.pop();
		res.push_back(tmp);
		for (int i = 0; i < graph[tmp].size(); i++) {
			int next = graph[tmp][i];
			if (--counts[next] == 0)
				pq.push(next);
		}
	}
	for (int i = 0; i < res.size(); i++) {
		cout << res[i] + 1 << " ";
	}

	return 0;
}