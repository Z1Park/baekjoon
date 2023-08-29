#include <stdio.h>
#include <vector>

using namespace std;

int nums[100000];
vector<int> segTree;

void saveMin(int node, int start, int end) {
	if (end == start) {
		segTree[node] = nums[start];
		return;
	}
	int next = node * 2;
	int mid = (start + end) / 2;
	saveMin(next, start, mid);
	saveMin(next+1, mid+1, end);
	segTree[node] = min(segTree[next], segTree[next+1]);
}

int findMin(int node, int start, int end, int s, int e) {
	if (end < s || e < start) return 1000000001;
	if (s <= start && end <= e) return segTree[node];

	int next = node * 2;
	int mid = (start + end) / 2;
	int tmp1 = findMin(next, start, mid, s, e);
	int tmp2 = findMin(next+1, mid+1, end, s, e);
	return min(tmp1, tmp2);
}

int main() {

	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%d", &nums[i]);
	for (int i = 0; i < n; i++) {
		if ((1 << i) > n) {
			segTree.resize(1 << (i + 1));
			break;
		}
	}
	saveMin(1, 0, n-1);

	int start, end;
	for (int t = 0; t < m; t++) {
		scanf("%d %d", &start, &end);
		printf("%d\n", findMin(1, 0, n-1, start-1, end-1));
	}

	return 0;
}