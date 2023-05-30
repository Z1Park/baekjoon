#include <iostream>
#include <string>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int cnt = 0, j = 0;
		string str, res;
		cin >> str;
		while (j < str.length()) {
			switch (str[j]) {
				case '@':
					res += 'a';
					cnt++;
					break;
				case '[':
					res += 'c';
					cnt++;
					break;
				case '!':
					res += 'i';
					cnt++;
					break;
				case ';':
					res += 'j';
					cnt++;
					break;
				case '^':
					res += 'n';
					cnt++;
					break;
				case '0':
					res += 'o';
					cnt++;
					break;
				case '7':
					res += 't';
					cnt++;
					break;
				case '\\':
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
					break;
				default:
					res += str[j];
					break;
			}
			j++;
		}
		if (cnt >= (res.length()+1)/2) cout << "I don't understand" << endl;
 		else cout << res << endl;
	}
}
