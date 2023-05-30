#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	int n, cnt;
	cin >> n;
	cnt = n;
	for (int i = 1; i < n; i++) {
		string tmp = to_string(i);
		for (int j = 0; j < tmp.length()-1; j++) {
			if (tmp[j] == '5' && tmp[j+1] == '0') {
				cnt++;
				break;
			}
		}
	}
	cout << cnt;
	return 0;
}
