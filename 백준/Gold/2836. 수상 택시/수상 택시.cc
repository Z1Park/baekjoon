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

	int n, m, x, y;
	cin >> n >> m;
	vector<pii> v;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		if (x > y) v.push_back(make_pair(y, x));
	}
	sort(v.begin(), v.end(), comp);
	long long sum = m;
	int left = v[0].first;
	int right = v[0].second;
	for (int i = 1; i < v.size(); i++) {
		if (right < v[i].first) {
			sum += (long long)(right - left) * 2ll;
			left = v[i].first;
			right = v[i].second;
		}
		else if (right < v[i].second) right = v[i].second;
	}
	sum += (long long)(right - left) * 2ll;
	cout << sum;

	return 0;
}
