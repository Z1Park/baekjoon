#include <stdio.h>
#include <vector>

using namespace std;

typedef pair<int, int> pii;

int main() {
	int n;
	long long maxValue = 0;
	scanf("%d", &n);
	vector<pii> stk;
	for (int i = 0; i < n; i++) {
		int input;
		scanf("%d", &input);
		int cnt = 0;
		while (!stk.empty() && stk.back().second >= input) {
			int tmp = stk.back().second;
			cnt += stk.back().first;
			stk.pop_back();
			long long now = (long long)tmp * (long long)cnt;
			if (maxValue < now) maxValue = now;
		}
		stk.push_back(make_pair(++cnt, input));
	}
	int tmp, cnt = 0;
	while (!stk.empty()) {
		tmp = stk.back().second;
		cnt += stk.back().first;
		stk.pop_back();
		long long now = (long long)tmp * (long long)cnt;
		if (maxValue < now) maxValue = now;
	}
	printf("%lld", maxValue);
}