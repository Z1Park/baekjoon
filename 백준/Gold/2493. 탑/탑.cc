#include <stdio.h>
#include <vector>

using namespace std;

typedef pair<int, int> pii;

int recv[500000];

int main() {
	int n;
	scanf("%d", &n);
	vector<pii> stk;
	for (int i = 1; i <= n; i++) {
		int tmp;
		scanf("%d", &tmp);
		if (stk.empty()) stk.push_back(make_pair(i, tmp));
		else if (stk.back().second > tmp) {
			recv[i] = stk.back().first;
			stk.push_back(make_pair(i, tmp));
		}
		else {
			while (!stk.empty() && stk.back().second <= tmp) {
				stk.pop_back();
			}
			if (stk.empty()) recv[i] = 0;
			else recv[i] = stk.back().first;
			stk.push_back(make_pair(i, tmp));
		}
	}
	for (int i = 1; i <= n; i++)
		printf("%d ", recv[i]);
}