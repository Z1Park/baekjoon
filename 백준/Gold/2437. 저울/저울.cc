#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	vector<int> nums(N);
	for (int i = 0; i < N; i++) scanf("%d", &nums[i]);
	sort(nums.begin(), nums.end());
	int maxEval = 0;
	for (int i = 0; i < nums.size(); i++) {
		if (nums[i] > maxEval + 1) break;
		maxEval += nums[i];
	}
	printf("%d", maxEval+1);
	return 0;
}