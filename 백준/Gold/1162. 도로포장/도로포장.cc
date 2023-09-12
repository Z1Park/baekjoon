#include <cstdio>
#include <vector>
#include <queue>

using namespace std;

typedef long long int ll;
typedef pair<int, int> pii;
typedef pair<ll, pii> pli;

int N, M, K;
ll arr[10001][21];
vector<pii> graph[10001];
priority_queue<pli, vector<pli>, greater<pli> > pq;

__inline ll dijk(int start) {
	ll cost, nextCost;
	int curr, cnt, next;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < 21; j++)
			arr[i][j] = -1;
	}
	pq.push(make_pair(0, make_pair(start, 0)));
	arr[start][0] = 0;
	while (!pq.empty()) {
		cost = pq.top().first;
		curr = pq.top().second.first;
		cnt = pq.top().second.second;
		pq.pop();

		if (arr[curr][cnt] < cost) continue;
		for (int i = 0; i < graph[curr].size(); i++) {
			next = graph[curr][i].first;
			nextCost = cost + graph[curr][i].second;
			if (cnt < K && (arr[next][cnt+1] == -1 || arr[next][cnt+1] > cost)) {
				arr[next][cnt+1] = cost;
				pq.push(make_pair(cost, make_pair(next, cnt+1)));
			}
			if (arr[next][cnt] > nextCost || arr[next][cnt] == -1) {
				arr[next][cnt] = nextCost;
				pq.push(make_pair(nextCost, make_pair(next, cnt)));
			}
		}
	}
	ll minVal = arr[N][0];
	for (int i = 1; i <= K; i++) {
		if (minVal > arr[N][i] && arr[N][i] != -1) minVal = arr[N][i];
	}
	return minVal;
}

int main() {
	scanf("%d %d %d", &N, &M, &K);
	int a, b, c;
	for (int i = 0; i < M; i++) {
		scanf("%d %d %d", &a, &b, &c);
		graph[a].push_back(make_pair(b, c));
		graph[b].push_back(make_pair(a, c));
	}
	printf("%lld", dijk(1));

	return 0;
}