#include <iostream>
#include <deque>
#define fio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

typedef pair<int, int> pii;

int main() {
	fio;

	int n, l, tmp;
	deque<pii> dq;
	cin >> n >> l;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		if (!dq.empty())
			if (i >= dq.front().second + l) dq.pop_front();
		while (!dq.empty() && dq.back().first > tmp) {
			dq.pop_back();
		}
		dq.push_back(make_pair(tmp, i));
		cout << dq.front().first << " ";
	}

	return 0;
}