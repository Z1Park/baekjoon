#include <vector>

using namespace std;

typedef long long ll;

int solution(int n) {
    ll a = 1, b = 2, tmp;
    for (int i = 3; i <= n; i++) {
        tmp = (a + b) % 1000000007;
        a = b;
        b = tmp;
    }
    return b;
}