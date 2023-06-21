#include <iostream>
#define FIO ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

using namespace std;

int n;
int matrix[5][5];
int tmp[5][5];
int res[5][5];

void cross(int arr1[5][5], int arr2[5][5]) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			tmp[i][j] = 0;
			for (int k = 0; k < n; k++)
				tmp[i][j] += arr1[i][k] * arr2[k][j];
			tmp[i][j] %= 1000;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			arr1[i][j] = tmp[i][j];
	}
}

int main() {
	FIO;

	long long b;
	cin >> n >> b;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> matrix[i][j];
		res[i][i] = 1;
	}
	while (b > 0) {
		if (b % 2 == 1) cross(res, matrix);
		cross(matrix, matrix);
		b /= 2;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << res[i][j] << " ";
		cout << endl;
	}

	return 0;
}
