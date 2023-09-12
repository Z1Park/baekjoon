#include <cstdio>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int N, M, K;
long long int arr[10001][21];
vector<pair<int, int> > graph[10001];
priority_queue<pair<long long, pair<int, int> > > pq;

long long int dijk(int start) {
	long long int cost, nextCost;
	int curr, cnt, next;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < 21; j++)
			arr[i][j] = -1;
	}
	arr[start][0] = 0;
	pq.push(make_pair(0, make_pair(start, 0)));
	while (!pq.empty()) {
		cost = -pq.top().first;
		curr = pq.top().second.first;
		cnt = pq.top().second.second;
		pq.pop();

		if (arr[curr][cnt] < cost) continue;
		for (int i = 0; i < graph[curr].size(); i++) {
			next = graph[curr][i].first;
			nextCost = cost + graph[curr][i].second;
			if (cnt < K && (arr[next][cnt+1] == -1 || arr[next][cnt+1] > cost)) {
				arr[next][cnt+1] = cost;
				pq.push(make_pair(-cost, make_pair(next, cnt+1)));
			}
			if (arr[next][cnt] > nextCost || arr[next][cnt] == -1) {
				arr[next][cnt] = nextCost;
				pq.push(make_pair(-nextCost, make_pair(next, cnt)));
			}
		}
	}
	long long int minVal = arr[N][0];
	for (int i = 1; i <= K; i++) {
		if (minVal > arr[N][i] && arr[N][i] != -1)
			minVal = arr[N][i];
	}
	return minVal;
}

int main() {
	int a, b, c;
	scanf("%d %d %d", &N, &M, &K);
	for (int i = 0; i < M; i++) {
		scanf("%d %d %d", &a, &b, &c);
		graph[a].push_back(make_pair(b, c));
		graph[b].push_back(make_pair(a, c));
	}
	printf("%lld\n", dijk(1));
}