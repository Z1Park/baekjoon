#include <stdio.h>
#include <vector>

using namespace std;

typedef long long ll;

ll nums[1000001];
vector<ll> segTree;

void savePartialSum(int node, ll start, ll end) {
	if (start == end) {
		segTree[node] = nums[start];
		return;
	}

	int next = node * 2;
	ll mid = (start + end) / 2;
	savePartialSum(next, start, mid);
	savePartialSum(next+1, mid+1, end);
	segTree[node] = segTree[next] + segTree[next+1];
}

ll getPartialSum(int node, ll start, ll end, ll s, ll e) {
	if (end < s || e < start) return 0;
	if (s <= start && end <= e) return segTree[node];

	int next = node * 2;
	ll mid = (start + end) / 2;
	ll tmp1 = getPartialSum(next, start, mid, s, e);
	ll tmp2 = getPartialSum(next+1, mid+1, end, s, e);
	return tmp1 + tmp2;
}

ll modifyPartialSum(int node, ll start, ll end, int target, ll value) {
	ll tmp;
	if (start == end && start == target) {
		tmp = segTree[node];
		segTree[node] = value;
		return value - tmp;
	}
	int next = node * 2;
	int mid = (start + end) / 2;
	if (start <= target && target <= mid)
		tmp = modifyPartialSum(next, start, mid, target, value);
	else
		tmp = modifyPartialSum(next+1, mid+1, end, target, value);
	segTree[node] += tmp;
	return tmp;
}

int main() {
	ll N, M, K, V;

	scanf("%lld %lld %lld", &N, &M, &K);
	V = M + K;
	for (int i = 0; i < N; i++) scanf("%lld", &nums[i]);
	for (int i = 0; ; i++) {
		if ((1 << i) > N) {
			segTree.resize(1 << (i + 1));
			break;
		}
	}
	savePartialSum(1, 0, N-1);
	for (int i = 0; i < V; i++) {
		int a;
		long long b, c;
		scanf("%d %lld %lld", &a, &b, &c);
		if (a == 1) modifyPartialSum(1, 0, N-1, b-1, c);
		else printf("%lld\n", getPartialSum(1, 0, N-1, b-1, c-1));
	}

	return 0;
}