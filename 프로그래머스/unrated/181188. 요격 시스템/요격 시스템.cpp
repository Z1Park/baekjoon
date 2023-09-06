#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(vector<int>& a, vector<int>& b) {
    return a[1] < b[1];
}

int solution(vector<vector<int>> targets) {
    int answer = 0;
    sort(targets.begin(), targets.end(), cmp);
    int last = -1;
    for (auto target : targets) {
        if (target[0] >= last) {
            answer++;
            last = target[1];
        }
    }
    return answer;
}