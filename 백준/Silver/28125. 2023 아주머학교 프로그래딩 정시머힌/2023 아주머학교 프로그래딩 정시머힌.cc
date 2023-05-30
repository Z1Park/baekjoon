#include <iostream>
#include <string>
#include <map>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	map<char, char> mp;
	mp.insert(pair<char, char>('@', 'a'));
	mp.insert(pair<char, char>('[', 'c'));
	mp.insert(pair<char, char>('!', 'i'));
	mp.insert(pair<char, char>(';', 'j'));
	mp.insert(pair<char, char>('^', 'n'));
	mp.insert(pair<char, char>('0', 'o'));
	mp.insert(pair<char, char>('7', 't'));

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int cnt = 0, j = 0;
		string str, res;
		cin >> str;
		while (j < str.length()) {
			if (str[j] == '\\') {
				if (j+1 < str.length() && str[j+1] == '\'') {
					cnt++;
					res += 'v';
					j++;
				}
				else if (j+2 < str.length() && str[j+1] == '\\' && str[j+2] == '\'') {
					cnt++;
					res += 'w';
					j += 2;
				}
				else res += str[j];
			}
			else {
				auto it = mp.find(str[j]);
				if (it != mp.end()) {
					cnt++;
					res += it->second;
				}
				else res += str[j];
			}
			j++;
		}
		if (cnt >= (res.length()+1)/2) cout << "I don't understand" << endl;
 		else cout << res << endl;
	}
}
