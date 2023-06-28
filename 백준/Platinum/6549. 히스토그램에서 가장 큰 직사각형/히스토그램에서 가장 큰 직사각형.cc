#include <stdio.h>
#include <vector>

using namespace std;

typedef pair<int, long long> pil;

vector<pil> stk;

int main() {
	int n;
	while (true) {
		scanf("%d", &n);
		if (n == 0) break;
		long long maxArea = 0;
		for (int i = 0; i < n; i++) {
			long long tmp;
			scanf("%lld", &tmp);
			int cnt = 0;
			if (!stk.empty() && stk.back().second > tmp) {
				long long top;
				while (!stk.empty() && stk.back().second > tmp) {
					top = stk.back().second;
					cnt += stk.back().first;
					stk.pop_back();
					long long now = top * (long long)cnt;
					if (maxArea < now) maxArea = now;
				}
			}
			stk.push_back(make_pair(++cnt, tmp));
		}
		int cnt2 = 0;
		while (!stk.empty()) {
			long long top = stk.back().second;
			cnt2 += stk.back().first;
			stk.pop_back();
			long long now = top * (long long)cnt2;
			if (maxArea < now) maxArea = now;
		}
		printf("%lld\n", maxArea);
	}
}