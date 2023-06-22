#include <iostream>
#include <string>
#include <vector>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

vector<int> nums;
bool broken[10] = {false, };

void makeNum(int idx, int len, int num) {
	if (idx == len) {
		nums.push_back(num);
		return;
	}
	for (int i = 0; i < 10; i++)
		if (!broken[i]) makeNum(idx + 1, len, num * 10 + i);
}

int main() {
	FIO;

	int n, m, tmp;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> tmp;
		broken[tmp] = true;
	}
	int len = to_string(n).length();
	int minVal = abs(n - 100);
	for (int i = 1; i <= len+1; i++) {
		nums.clear();
		makeNum(0, i, 0);
		while (!nums.empty()) {
			int num = i + abs(n - nums.back());
			nums.pop_back();
			if (minVal > num) minVal = num;
		}
	}
	cout << minVal;

	return 0;
}