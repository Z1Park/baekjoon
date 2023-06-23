#include <iostream>
#include <vector>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

typedef pair<int, int> pii;

int n, m;
pii my[8];
pii opp[8];
bool used[8];
vector<pii> cmdQueue;

bool checkClear() {
	for (int i = 0; i < n; i++) {
		if (my[i].second > 0)
			return false;
	}
	for (int j = 0; j < m; j++) {
		if (opp[j].second > 0)
			return false;
	}
	return true;
}

int useModok() {
	int modokCnt = 0;
	bool modokFlag = true;
	while (modokFlag) {
		modokFlag = false;
		modokCnt++;
		for (int i = 0; i < n; i++) {
			my[i].second--;
			if (my[i].second == 0)
				modokFlag = true;
		}
		for (int i = 0; i < m; i++) {
			opp[i].second--;
			if (opp[i].second == 0)
				modokFlag = true;
		}
	}
	return modokCnt;
}

void restoreModok(int modokCnt) {
	for (int i = 0; i < n; i++)
		my[i].second += modokCnt;
	for (int i = 0; i < m; i++)
		opp[i].second += modokCnt;
}

bool recursive() {
	if (checkClear())
		return true;
	for (int i = 0; i <= n; i++) {
		if (!used[i]) {
			used[i] = true;
			if (i == n) {
				cmdQueue.push_back(make_pair(-1, -1));
				int cnt = useModok();
				if (recursive())
					return true;
				restoreModok(cnt);
				cmdQueue.pop_back();
				used[i] = false;
				continue;
			}
			if (my[i].second > 0) {
				for (int j = 0; j < m; j++) {
					if (opp[j].second > 0) {
						cmdQueue.push_back(make_pair(i+1, j+1));
						opp[j].second -= my[i].first;
						my[i].second -= opp[j].first;
						if (recursive())
							return true;
						opp[j].second += my[i].first;
						my[i].second += opp[j].first;
						cmdQueue.pop_back();
					}
				}
			}
			used[i] = false;
		}
	}
	return false;
}

int main() {
	FIO;

	cin >> n >> m;
	int offence, deffence;
	for (int i = 0; i < n; i++) {
		cin >> offence >> deffence;
		my[i] = make_pair(offence, deffence);
	}
	for (int i = 0; i < m; i++) {
		cin >> offence >> deffence;
		opp[i] = make_pair(offence, deffence);
	}
	if (m == 0)
		cout << 0;
	else if (recursive()) {
		cout << cmdQueue.size() << endl;
		for (int i = 0; i < cmdQueue.size(); i++) {
			pii tmp = cmdQueue[i];
			if (tmp.first == -1 && tmp.second == -1)
				cout << "use modok" << endl;
			else
				cout << "attack " << tmp.first << " " << tmp.second << endl;
		}
	}
	else cout << -1;

	return 0;
}