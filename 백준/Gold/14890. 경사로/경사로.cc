#include <iostream>
#define fio ios::sync_with_stdio(0); cin.tie(0);

using namespace std;

typedef pair<int, int> pii;

int n, l;
int arr1[100][100];
int arr2[100][100];

int countRoad(int arr[100][100]) {
	int count = 0;
	for (int i = 0; i < n; i++) {
		bool slope[100] = {false};
		bool flag = true;
		for (int j = 0; j < n-1; j++) {
			if (arr[i][j] == arr[i][j+1]) continue;
			if (abs(arr[i][j] - arr[i][j+1]) > 1) {
				flag = false;
				break;
			}
			// 내리막길
			if (arr[i][j] - arr[i][j+1] == 1) {
				for (int k = 0; k < l; k++) {
					if (j+1+k > n-1 || slope[j+1+k] || arr[i][j+1] != arr[i][j+1+k]) {
						flag = false;
						break;
					}
				}
				if (flag)
					for (int k = 0; k < l; k++) slope[j+1+k] = true;
			}
			// 오르막길
			else {
				for (int k = 0; k < l; k++) {
					if (j-k < 0 || slope[j-k] || arr[i][j] != arr[i][j-k]) {
						flag = false;
						break;
					}
				}
				if (flag)
					for (int k = 0; k < l; k++) slope[j-k] = true;
			}
		}
		if (flag) count++;
	}
	return count;
}

int main() {
	fio;

	std::cin >> n >> l;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr1[i][j];
			arr2[j][i] = arr1[i][j];
		}
	}

	int count = countRoad(arr1);
	count += countRoad(arr2);
	cout << count;

	return 0;
}