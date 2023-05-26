#include <iostream>
#include <set>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	FIO;
	int t, k, n;
	char c;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> k;
		multiset<int> s;
		for (int j = 0; j < k; j++) {
			cin >> c >> n;
			if (c == 'I') s.insert(n);
			else if (!s.empty()) {
				if (n == 1) s.erase(--s.end());
				else s.erase(s.begin());
			}
		}
		if (s.empty()) cout << "EMPTY" << endl;
		else cout << *(--s.end()) << " " << *(s.begin()) << endl;
	}
}
