#include <iostream>
#include <algorithm>
#include <vector>
#define fio ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

typedef pair<int, int> pii;

bool comp(pii& a, pii& b) {
	if (a.first != b.first)
		return a.first < b.first;
	return a.second > b.second;
}

int main() {
	fio;

	int n, x, y;
	cin >> n;
	vector<pii> v;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}
	sort(v.begin(), v.end(), comp);
	int sum = 0;
	int left = v[0].first;
	int right = v[0].second;
	for (int i = 1; i < v.size(); i++) {
		if (right < v[i].first) {
			sum += right - left;
			left = v[i].first;
			right = v[i].second;
		}
		else {
			if (left > v[i].first) left = v[i].first;
			if (right < v[i].second) right = v[i].second;
		}
	}
	sum += right - left;
	cout << sum;

	return 0;
}
