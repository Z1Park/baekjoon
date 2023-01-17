#include <iostream>

using namespace std;

int bitmask;

int main() {
	int tc;

	cin >> tc;
	for (int i = 0; i < tc; i++) {
		int N;
		int tmp;
		cin >> N;
		bitmask = 0;
		int k = 1;
		while (bitmask != 1023) {
			tmp = N * k;
			while (tmp != 0) {
				int one = tmp % 10;
				bitmask |= (1 << one);
				tmp /= 10;
			}
            k++;
		}
		cout << "#" << i + 1 << " " << (k - 1) * N << endl;
	}
}