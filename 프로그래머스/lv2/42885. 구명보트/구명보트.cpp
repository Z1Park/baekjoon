#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int cnt = 0;
    int start = 0, end = people.size() - 1;
    sort(people.begin(), people.end());
    while (start <= end) {
        if (start == end) {
            cnt++;
            break;
        }
        if (people[start] + people[end] <= limit) {
            start++;
        }
        end--;
        cnt++;
    }
    return cnt;
}