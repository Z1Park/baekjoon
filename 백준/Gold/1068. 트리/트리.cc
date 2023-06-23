#include <iostream>
#include <vector>
#define FIO ios::sync_with_stdio(0), cin.tie(0);

using namespace std;

vector<int> v[55];

int findLeafNode(int node, int del) {
	if (v[node].size() == 0) {
		return 1;
	}
	int leaf = 0;
	for (int i = 0; i < v[node].size(); i++) {
		if (v[node][i] == del) {
			if (v[node].size() == 1) leaf++;
		}
		else
			leaf += findLeafNode(v[node][i], del);
	}
	return leaf;
}

int main() {
	FIO;

	int n, m;
	cin >> n;
	int root;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		if (tmp != -1) v[tmp].push_back(i);
		else root = i;
	}
	cin >> m;
	if (root == m) cout << 0;
	else cout << findLeafNode(root, m);

	return 0;
}