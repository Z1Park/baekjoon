#include <stdio.h>
#include <vector>

using namespace std;

int nums[100000];
vector<int> minSegTree;
vector<int> maxSegTree;

int minValue(int &a, int &b) {
	if (a > b) return b;
	return a;
}

int maxValue(int &a, int &b) {
	if (a >= b) return a;
	return b;
}

void saveValue(vector<int> &segTree, int (*func)(int&, int&), int node, int start, int end) {
	if (end == start) {
		segTree[node] = nums[start];
		return;
	}
	int next = node * 2;
	int mid = (start + end) / 2;
	saveValue(segTree, func, next, start, mid);
	saveValue(segTree, func, next+1, mid+1, end);
	segTree[node] = func(segTree[next], segTree[next+1]);
}

int findValue(vector<int> &segTree, int (*func)(int&, int&), int node, int start, int end, int s, int e) {
	if (end < s || e < start) return -1;
	if (s <= start && end <= e) return segTree[node];

	int next = node * 2;
	int mid = (start + end) / 2;
	int tmp1 = findValue(segTree, func, next, start, mid, s, e);
	int tmp2 = findValue(segTree, func, next+1, mid+1, end, s, e);
	if (tmp1 == -1) return tmp2;
	if (tmp2 == -1) return tmp1;
	return func(tmp1, tmp2);
}

int main() {

	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%d", &nums[i]);
	for (int i = 0; i < n; i++) {
		if ((1 << i) > n) {
			minSegTree.resize(1 << (i + 1));
			maxSegTree.resize(1 << (i + 1));
			break;
		}
	}
	saveValue(minSegTree, minValue, 1, 0, n-1);
	saveValue(maxSegTree, maxValue, 1, 0, n-1);

	int start, end;
	for (int t = 0; t < m; t++) {
		scanf("%d %d", &start, &end);
		printf("%d %d\n",
			findValue(minSegTree, minValue, 1, 0, n-1, start-1, end-1),
			findValue(maxSegTree, maxValue, 1, 0, n-1, start-1, end-1));
	}

	return 0;
}