#include <iostream>
#include <string>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int main() {
	int n, grade[1001], pos = 0;
	string tier[1001];
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tier[i];
		char c = tier[i][0];
		int tmp = stoi(tier[i].substr(1, tier[i].npos));
		tmp = 1000 - tmp;
		switch (c) {
			case 'S':
				tmp += 1000;
				break;
			case 'G':
				tmp += 2000;
				break;
			case 'P':
				tmp += 3000;
				break;
			case 'D':
				tmp += 4000;
				break;
			default:
				break;
		}
		grade[i] = tmp;
	}
	for (int i = 0; i < n-1; i++) {
		if (grade[i] > grade[i+1]) {
			cout << "KO" << endl;
			if (i == n-2) cout << tier[i+1] << " " << tier[i];
			else if (grade[i] < grade[i+2]) cout << tier[i+1] << " " << tier[i];
			else {
				for (int j = i+1; j < n-1; j++) {
					if (grade[j] > grade[j+1]) {
						cout << tier[j+1] << " " << tier[i];
						break;
					}
					if (j == n-2) cout << tier[j+1] << " " << tier[i];
				}
			}
			return 0;
		}
	}
	cout << "OK";
	return 0;
}
