#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer(2);
    answer[0] = -1;
    answer[1] = -1;
    int start = 0, end = 0;
    int s = sequence[start];
    while (start <= end && end < sequence.size()) {
        if (s == k) {
            if (answer[0] == -1 || answer[1] - answer[0] > end - start) {
                answer[0] = start;
                answer[1] = end;
            }
            end++;
            s += sequence[end];
        }
        else if (s < k) {
            end++;
            s += sequence[end];
        }
        else {
            s -= sequence[start];
            start++;
        }
    }
    return answer;
}