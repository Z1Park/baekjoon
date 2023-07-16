#include <iostream>
#include <vector>
#include <algorithm>
#define fio ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

typedef pair<int, int> pii;

bool comp(pii& a, pii& b) {
	if (a.first != b.first) return a.first < b.first;
	return a.second > b.second;
}

int main() {
	fio;

	int n, x, r;
	cin >> n;
	vector<pii> v;
	for (int i = 0; i < n; i++) {
		cin >> x >> r;
		v.push_back(make_pair(x-r, 0));
		v.push_back(make_pair(x+r, 1));
	}
	sort(v.begin(), v.end(), comp);
	vector<pii> stk;
	int cnt = 1;
	for (int i = 0; i < v.size(); i++) {
		int pos = v[i].first, pat = v[i].second;
		if (pat == 0) {
			stk.push_back(make_pair(0, pos));
		}
		else {
			int sum = 0;
			while (!stk.empty() && stk.back().first == 1) {
				sum += stk.back().second;
				stk.pop_back();
			}
			int tmp = stk.back().second;
			stk.pop_back();
			stk.push_back(make_pair(1, pos - tmp));
			if (stk.back().second == sum) cnt += 2;
			else cnt++;
		}
	}
	cout << cnt;

	return 0;
}
