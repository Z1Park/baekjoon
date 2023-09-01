#include <stdio.h>
#include <vector>
#define MOD 1000000007

using namespace std;

typedef long long ll;

int N, M, K;
int nums[1000001];
vector<ll> segTree;

void saveValue(int node, int start, int end) {
	if (start == end) {
		segTree[node] = nums[start] % MOD;
		return;
	}

	int next = node * 2;
	int mid = (start + end) / 2;
	saveValue(next, start, mid);
	saveValue(next+1, mid+1, end);
	segTree[node] = segTree[next] * segTree[next+1] % MOD;
}

void modifyValue(int node, int start, int end, int target, int value) {
	if (start == end && start == target) {
		segTree[node] = value % MOD;
		return;
	}
	int next = node * 2;
	int mid = (start + end) / 2;
	if (start <= target && target <= mid)
		modifyValue(next, start, mid, target, value);
	else
		modifyValue(next+1, mid+1, end, target, value);
	segTree[node] = segTree[next] * segTree[next+1] % MOD;
}

ll getValue(int node, int start, int end, int s, int e) {
	if (end < s || e < start)
		return -1;
	if (s <= start && end <= e)
		return segTree[node];
	int next = node * 2;
	int mid = (start + end) / 2;
	ll tmp1 = getValue(next, start, mid, s, e);
	ll tmp2 = getValue(next+1, mid+1, end, s, e);
	if (tmp1 == -1) return tmp2;
	if (tmp2 == -1) return tmp1;
	return tmp1 * tmp2 % MOD;
}

int main() {
	scanf("%d %d %d", &N, &M, &K);
	for (int i = 0; i < N; i++)
		scanf("%d", &nums[i]);
	for (int i = 0; ; i++) {
		if ((1 << i) > N) {
			segTree.resize(1 << (i + 1));
			break;
		}
	}
	saveValue(1, 0, N-1);
	int a, b, c, V = M + K;
	for (int i = 0; i < V; i++) {
		scanf("%d %d %d", &a, &b, &c);
		if (a == 1) modifyValue(1, 0, N-1, b-1, c);
		else printf("%lld\n", getValue(1, 0, N-1, b-1, c-1));
	}

	return 0;
}