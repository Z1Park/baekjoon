#include <iostream>
#include <vector>
#include <algorithm>
#define fio ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pll;

bool cmp(pll a, pll b) {
	if (a.first == b.first)
		return a.second > b.second;
	return a.first < b.first;
}

int main() {
	fio;

	long long n, x, y;
	cin >> n;
	vector<pll> v(n);
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		v[i] = make_pair(x, y);
	}
	sort(v.begin(), v.end(), cmp);
	long long last = v[0].second, sum = v[0].second - v[0].first;
	for (int i = 1; i < v.size(); i++) {
		if (v[i].first > last)
			last = v[i].first;
		if (v[i].second > last) {
			sum += v[i].second - last;
			last = v[i].second;
		}
	}
	cout << sum;

	return 0;
}