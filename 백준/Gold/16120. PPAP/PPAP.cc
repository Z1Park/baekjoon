#include <iostream>
#include <string>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	string str;
	cin >> str;
	int p_cnt = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == 'P') {
			p_cnt++;
			continue;
		}
		if (p_cnt >= 2 && str[i+1] == 'P') {
			i++;
			p_cnt--;
		}
		else {
			cout << "NP";
			return 0;
		}
	}
	if (p_cnt == 1) cout << "PPAP";
	else cout << "NP";
	return 0;
}