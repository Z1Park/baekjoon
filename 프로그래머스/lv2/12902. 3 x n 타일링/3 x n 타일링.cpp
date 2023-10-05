#include <vector>

using namespace std;

typedef long long ll;

int solution(int n) {
    if (n % 2 == 1) return 0;
    vector<ll> vec(n+1);
    int acc = 2;
    vec[2] = 3;
    for (int i = 4; i <= n; i += 2) {
        vec[i] = (vec[i-2] * 3 + acc) % 1000000007;
        acc = (acc + vec[i-2] * 2) % 1000000007;
    }
    return vec[n];
}