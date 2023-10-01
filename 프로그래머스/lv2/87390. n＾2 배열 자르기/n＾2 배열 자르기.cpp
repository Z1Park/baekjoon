#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    int r = left / n, c = left % n;
    int tmp = r + ((c > r) ? c - r : 0) + 1;
    for (long long i = left; i <= right; i++) {
        answer.push_back(tmp);
        if (++c >= n) {
            c = 0;
            r++;
            tmp = r + 1;
        }
        if (c > r) tmp++;
    }
    return answer;
}