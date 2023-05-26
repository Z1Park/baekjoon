#include <iostream>
#include <queue>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	FIO;
	int n, value, size;
	priority_queue<int, vector<int>> max_que;
	priority_queue<int, vector<int>, greater<int>> min_que;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> value;
		if (max_que.size() > min_que.size()) min_que.push(value);
		else max_que.push(value);
		if (!max_que.empty() && !min_que.empty() && max_que.top() > min_que.top()) {
			min_que.push(max_que.top());
			max_que.pop();
			max_que.push(min_que.top());
			min_que.pop();
		}
		cout << max_que.top() << '\n';
	}
	return 0;
}
